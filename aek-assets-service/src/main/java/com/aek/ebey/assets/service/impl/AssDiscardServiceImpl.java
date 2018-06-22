package com.aek.ebey.assets.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.assets.constant.DiscardConstant;
import com.aek.ebey.assets.constant.SysConstant;
import com.aek.ebey.assets.core.util.LiuHuiPage;
import com.aek.ebey.assets.mapper.AssDiscardMapper;
import com.aek.ebey.assets.model.AssAssetsDiscard;
import com.aek.ebey.assets.model.AssDiscard;
import com.aek.ebey.assets.model.Assets;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.DeptNameAndUserName;
import com.aek.ebey.assets.model.query.AssetsDisApplyQuery;
import com.aek.ebey.assets.model.query.AssetsDisQuery;
import com.aek.ebey.assets.model.request.AssDiscardAddRequest;
import com.aek.ebey.assets.model.request.AssetsDisApplyResponse;
import com.aek.ebey.assets.model.request.AssetsDisInfo;
import com.aek.ebey.assets.model.request.AssetsDisResponse;
import com.aek.ebey.assets.model.request.CancelDiscardRequest;
import com.aek.ebey.assets.model.request.DiscardApplyInfo;
import com.aek.ebey.assets.model.request.DiscardBillInfo;
import com.aek.ebey.assets.model.request.DiscardDetail;
import com.aek.ebey.assets.model.request.DiscardReportDetail;
import com.aek.ebey.assets.model.request.OperateInfo;
import com.aek.ebey.assets.model.request.VerifyRequest;
import com.aek.ebey.assets.service.AssAssetsDiscardService;
import com.aek.ebey.assets.service.AssDiscardService;
import com.aek.ebey.assets.service.AssetsInfoExtService;
import com.aek.ebey.assets.service.AssetsInfoService;
import com.aek.ebey.assets.service.CodeInfoService;
import com.aek.ebey.assets.service.feign.RepairClientService;
import com.aek.ebey.assets.service.feign.UserClientService;
import com.aek.ebey.assets.service.utils.DiscardUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 设备报损单 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-12-14
 */
@Service
@Transactional
public class AssDiscardServiceImpl extends BaseServiceImpl<AssDiscardMapper, AssDiscard> implements AssDiscardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssDiscardServiceImpl.class);
	
	@Autowired
	private AssAssetsDiscardService assAssetsDiscardService;
	
	
	@Autowired
	private AssetsInfoService assetsInfoService;
	
	
	@Autowired
	private AssetsInfoExtService assetsInfoExtService;
	
	@Autowired
	private AssDiscardMapper assDiscardMapper;
	
	@Autowired
	private CodeInfoService codeInfoService;
	
	@Autowired
	private UserClientService userClientService;
	
	@Autowired
	private RepairClientService repairClientService;
	
	@Override
	public void save(AssDiscardAddRequest request) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		AssDiscard assDiscard = BeanMapper.map(request, AssDiscard.class);
		if(assDiscard!=null){
			if(authUser!=null){
				assDiscard.setTenantId(authUser.getTenantId());
				assDiscard.setTenantName(authUser.getTenantName());
			}
			assDiscard.setDiscardNo(DiscardUtils.discardNo());
			assDiscard.setApplyId(authUser.getId());
			assDiscard.setApplyName(authUser.getRealName());
			assDiscard.setApplyInstruction(request.getIllustration());
			assDiscard.setStatus(DiscardConstant.VERFY_STATUS_1);
			this.assDiscardMapper.insert(assDiscard);
			//申请报损的设备id
			List<Long>  listAssetsIds=request.getIds();
			if(listAssetsIds!=null&&listAssetsIds.size()>0){
				Integer[] intstatus={1,2,3};
				List<Integer> list=new ArrayList<>(Arrays.asList(intstatus));
				List<AssAssetsDiscard> listAssAssetsDiscard=new ArrayList<>();
				for(Long id:listAssetsIds){
					//AssetsInfo assetsInfo=assetsInfoService.selectById(id);
					Assets assets=assetsInfoService.getAssetsDetail(id);
					if(assets!=null){
						if(!list.contains(assets.getStatus().intValue())){
							throw ExceptionFactory.create("L_001");
						}else{
							AssAssetsDiscard assAssetsDiscard=new AssAssetsDiscard();
							assAssetsDiscard.setDiscardId(assDiscard.getId());
							assAssetsDiscard.setAssetsId(id);
							assAssetsDiscard.setAssetsName(assets.getAssetsName());
							assAssetsDiscard.setAssetsNum(assets.getAssetsNum());
							assAssetsDiscard.setSerialNum(assets.getSerialNum());
							assAssetsDiscard.setFactoryName(assets.getFactoryName());
							assAssetsDiscard.setSplName(assets.getSplName());
							assAssetsDiscard.setAssetsSpec(assets.getAssetsSpec());
							assAssetsDiscard.setAssetsDeptId(Long.valueOf(assets.getDeptId()+""));
							assAssetsDiscard.setAssetsDeptName(assets.getDeptName());
							assAssetsDiscard.setStatus(assets.getStatus());
							assAssetsDiscard.setAssetsImg(assets.getAssetsImg());
							assAssetsDiscard.setType(DiscardConstant.TYPE_STATUS_1);
							assAssetsDiscard.setStartUseDate(assets.getStartUseDate());
							assAssetsDiscard.setUnitName(assets.getUnitName());
							assAssetsDiscard.setVerifyStatus(DiscardConstant.VERFY_STATUS_1);
							listAssAssetsDiscard.add(assAssetsDiscard);
							//assAssetsDiscardService.insert(assAssetsDiscard);
						}
					}
				}
				assAssetsDiscardService.insertBatch(listAssAssetsDiscard);
				assetsInfoService.updateBatchByIds(listAssetsIds);
			}else{
				throw ExceptionFactory.create("L_002");
			}
			
		}else{
			throw ExceptionFactory.create("L_002");
		}
		
	}

	@Override
	public DiscardDetail getAllById(Long id) {
		AssDiscard  assDiscard =assDiscardMapper.selectById(id);
		if(assDiscard!=null){
			DiscardDetail discardDetail=new DiscardDetail();
			DiscardApplyInfo applyInfo=new DiscardApplyInfo();
			applyInfo.setType(DiscardUtils.getType(assDiscard.getType()));
			applyInfo.setIllustration(assDiscard.getApplyInstruction());
			applyInfo.setSuggestion(assDiscard.getVerifyOpinion());
			List<AssAssetsDiscard> list=assAssetsDiscardService.selectByAssDiscardId(id);
			List<AssetsDisInfo> assetList=new ArrayList<>();
			if(list!=null&&list.size()>0){
				for(AssAssetsDiscard assAssetsDiscard:list){
					AssetsDisInfo assetsDisInfo=new AssetsDisInfo();
					assetsDisInfo.setAssetsId(assAssetsDiscard.getAssetsId());
					assetsDisInfo.setAssetsSpec(assAssetsDiscard.getAssetsSpec());
					assetsDisInfo.setAssetsNum(assAssetsDiscard.getAssetsNum());
					assetsDisInfo.setSerialNum(assAssetsDiscard.getSerialNum());
					assetsDisInfo.setAssetsName(assAssetsDiscard.getAssetsName());
					assetsDisInfo.setStartUseDate(assAssetsDiscard.getStartUseDate());
					assetsDisInfo.setStatus(assAssetsDiscard.getType());
					assetsDisInfo.setFactoryName(assAssetsDiscard.getFactoryName());
					assetsDisInfo.setAssetsUnit(assAssetsDiscard.getUnitName());
					assetsDisInfo.setDeptName(assAssetsDiscard.getAssetsDeptName());
					assetList.add(assetsDisInfo);
				}
			}
			applyInfo.setAssetList(assetList);
			discardDetail.setApplyInfo(applyInfo);
			DiscardBillInfo billInfo=new DiscardBillInfo();
			billInfo.setId(id);
			billInfo.setNum(assDiscard.getDiscardNo());
			List<OperateInfo> results=new ArrayList<>();
			if(assDiscard.getVerifyId()!=null){
				OperateInfo operateInfo=new OperateInfo();
				operateInfo.setName(assDiscard.getVerifyName());
				if(assDiscard.getStatus().intValue()==2){
					operateInfo.setOperate("审核通过");
				}
				if(assDiscard.getStatus().intValue()==3){
					operateInfo.setOperate("审核未通过");
				}
				operateInfo.setTime(assDiscard.getVerifyTime());
				results.add(operateInfo);
			}
			if(assDiscard.getApplyId()!=null){
				OperateInfo operateInfo=new OperateInfo();
				operateInfo.setName(assDiscard.getApplyName());
				operateInfo.setOperate("提交报损申请");
				operateInfo.setTime(assDiscard.getCreateTime());
				results.add(operateInfo);
			}
			billInfo.setResults(results);
			billInfo.setStatus(DiscardUtils.getStatus(assDiscard.getStatus()));
			discardDetail.setBillInfo(billInfo);
			return discardDetail;
		}
		return null;
	}

	@Override
	public LiuHuiPage<AssetsDisResponse> search(AssetsDisQuery query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Page<AssetsDisResponse> pageAssets = query.getPagePlus();
		List<AssetsDisResponse> list=assDiscardMapper.search(pageAssets,query,authUser);
		if(list!=null&&list.size()>0){
			for(AssetsDisResponse assetsDisResponse:list){
				/* 查询科室名称 */
				StringBuffer deptIds = new StringBuffer("");
				Long deptId = assetsDisResponse.getDeptId();// 使用科室
				if (deptId != null) {
					deptIds.append(deptId);
					deptIds.append(",");
				}
				if (deptIds != null && !deptIds.equals("")) {
					Map<String, String> deptNameMap = findDeptNameToMap(deptIds.toString());
					if (deptNameMap != null) {
						assetsDisResponse.setDeptName(deptNameMap.get("" + deptId));// 使用部门
					}
				}
				if(assetsDisResponse.getStatus1()!=null){
					assetsDisResponse.setStatus(DiscardUtils.getStatus2(assetsDisResponse.getStatus1()));
				}
				assetsDisResponse.setUnitName(codeInfoService.getCodeInfoMap(SysConstant.UNIT).get(String.valueOf(assetsDisResponse.getUnitId())));
			}
		}
		LiuHuiPage<AssetsDisResponse> page=new LiuHuiPage<>(pageAssets);
		page.setRecords(list);
		return page;
	}
	
	/**
	 * 查找部门名称
	 */
	private Map<String, String> findDeptNameToMap(String ids) {
		Map<String, String> map = new HashMap<>();
		if (ids != null && !ids.equals(""))// 获取部门名称，存入map
		{
			Result<List<DeptNameAndUserName>> deptName = userClientService.findByDeptIds(ids, WebSecurityUtils.getCurrentToken());
			if (deptName != null && deptName.getData() != null && deptName.getData().size() != 0) {
				for (DeptNameAndUserName dname : deptName.getData()) {
					map.put("" + dname.getId(), dname.getName());// dname.getName());//id为KEY，名称为
					// value
				}
			}
		}
		return map;
	}

	@Override
	public void update_verify(VerifyRequest request) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		String token = WebSecurityUtils.getCurrentToken();
		Long id=request.getId();
		AssDiscard assDiscard=assDiscardMapper.selectById(id);
		if(assDiscard!=null){
			List<AssAssetsDiscard> list=null;
			List<AssAssetsDiscard> listcx=new ArrayList<>();
			List<AssAssetsDiscard> listtg=new ArrayList<>();
			List<AssetsInfo> listall=new ArrayList<>();
			if(assDiscard.getStatus().intValue()==1){
				//得到设备所在科室
				String deptName = assDiscardMapper.getDeptNameByDiscardId(id);
				//通过
				if(request.getStatus()==1){
					assDiscard.setStatus(2);
					list=assAssetsDiscardService.selectByAssDiscardId(id);
					if(list!=null&&list.size()>0){
						for(AssAssetsDiscard assAssetsDiscard:list){
							assAssetsDiscard.setVerifyStatus(2);
							if(assAssetsDiscard.getType().intValue()==1){
								listtg.add(assAssetsDiscard);
							}else{
								listcx.add(assAssetsDiscard);
							}
						}
						
					}
					//发消息
					repairClientService.sendMsg("报损审核通过，查看详情", id, deptName, assDiscard.getApplyId(), 8, token);
					//不通过
				}else if(request.getStatus()==0){
					assDiscard.setStatus(3);
					list=assAssetsDiscardService.selectByAssDiscardId(id);
					if(list!=null&&list.size()>0){
						for(AssAssetsDiscard assAssetsDiscard:list){
							assAssetsDiscard.setVerifyStatus(3);
							listcx.add(assAssetsDiscard);
						}
					}
					//发消息
					repairClientService.sendMsg("报损审核未通过，查看详情", id, deptName, assDiscard.getApplyId(), 8, token);
				}
				if(list!=null&&list.size()>0){
					assAssetsDiscardService.updateBatchById(list);
				}
				//撤销
				if(listcx.size()>0){
					for(AssAssetsDiscard assAssetsDiscard:listcx){
						Long assetsId=assAssetsDiscard.getAssetsId();
						Integer  status =assAssetsDiscard.getStatus();
						AssetsInfo assetsInfo	=assetsInfoService.selectById(assetsId);
						assetsInfo.setStatus(status); 
						listall.add(assetsInfo);
						
					}
				}
				//通过
				if(listtg.size()>0){
					for(AssAssetsDiscard assAssetsDiscard:listtg){
						Long assetsId=assAssetsDiscard.getAssetsId();
						AssetsInfo assetsInfo	=assetsInfoService.selectById(assetsId);
						//报损
						assetsInfo.setStatus(5); 
						listall.add(assetsInfo);
						
					}
				}
				if(listall.size()>0){
					assetsInfoService.updateBatchById(listall);
				}
				//assAssetsDiscardService.selectByAssAssetsDiscard();
				assDiscard.setVerifyOpinion(request.getSuggestion());
				assDiscard.setRemarks(request.getRemarks());
				assDiscard.setVerifyId(authUser.getId());
				assDiscard.setVerifyName(authUser.getRealName());
				assDiscard.setVerifyTime(new Date());
				assDiscardMapper.updateById(assDiscard);
			}else{
				throw ExceptionFactory.create("L_003");
			}
		}else{
			throw ExceptionFactory.create("L_003");
		}
	}

	@Override
	public void update_cancel(CancelDiscardRequest request) {
		Wrapper<AssAssetsDiscard> wrapper=new EntityWrapper<>();
		wrapper.eq("discard_id", request.getId()).eq("assets_id", request.getAssetsId());
		List<AssAssetsDiscard> list=assAssetsDiscardService.selectList(wrapper);
		AssAssetsDiscard assAssetsDiscard=null;
		if(list!=null&&list.size()>0){
			assAssetsDiscard=list.get(0);
		}
		if(assAssetsDiscard!=null){
			if(2==assAssetsDiscard.getType().intValue()){
				throw ExceptionFactory.create("L_004");
			}
			/*if(1!=assAssetsDiscard.getVerifyStatus().intValue()){
				throw ExceptionFactory.create("L_005");
			}*/
			//已撤销
			assAssetsDiscard.setType(2);
			assAssetsDiscardService.updateById(assAssetsDiscard);
			Long assetsId=assAssetsDiscard.getAssetsId();
			Integer  status =assAssetsDiscard.getStatus();
			AssetsInfo assetsInfo=assetsInfoService.selectById(assetsId);
			assetsInfo.setStatus(status); 
			assetsInfoService.updateById(assetsInfo);
		}
		
	}

	@Override
	public LiuHuiPage<AssetsDisApplyResponse> searchApply(AssetsDisApplyQuery query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Page<AssetsDisApplyResponse> pageAssetsDisApply = query.getPagePlus();
		List<AssDiscard> list=assDiscardMapper.searchApply(pageAssetsDisApply,query,authUser);
		List<AssetsDisApplyResponse> listApply=new ArrayList<>();
		for(AssDiscard assDiscard:list){
			AssetsDisApplyResponse assetsDisApplyResponse=new AssetsDisApplyResponse();
			assetsDisApplyResponse.setId(assDiscard.getId());
			assetsDisApplyResponse.setNum(assDiscard.getDiscardNo());
			assetsDisApplyResponse.setName(assDiscard.getApplyName());
			assetsDisApplyResponse.setTime(assDiscard.getCreateTime());
			assetsDisApplyResponse.setType(DiscardUtils.getType(assDiscard.getType()));
			assetsDisApplyResponse.setStatus(DiscardUtils.getStatus(assDiscard.getStatus()));
			List<AssetsDisResponse> listDisResponse=new ArrayList<>();
			Long assDiscardId=assDiscard.getId();
			if(assDiscardId!=null){
				List<AssetsDisResponse> listAssetsDisResponse=assAssetsDiscardService.selectByAssId(assDiscardId);
				if(list!=null&&list.size()>0){
					for(AssetsDisResponse assetsDisResponse:listAssetsDisResponse){
						if(assetsDisResponse.getStatus1()!=null){
							assetsDisResponse.setStatus(DiscardUtils.getStatus2(assetsDisResponse.getStatus1()));
						}
					}
					listDisResponse.addAll(listAssetsDisResponse);
				}
			}
			assetsDisApplyResponse.setList(listDisResponse);
			listApply.add(assetsDisApplyResponse);
		}
		LiuHuiPage<AssetsDisApplyResponse> page=new LiuHuiPage<>(pageAssetsDisApply);
		page.setRecords(listApply);
		return page;
	}

	@Override
	public DiscardReportDetail getReportById(Long id) {
		AssDiscard  assDiscard =assDiscardMapper.selectById(id);
		if(assDiscard!=null){
			DiscardReportDetail discardReportDetail=new DiscardReportDetail();
			discardReportDetail.setNum(assDiscard.getDiscardNo());
			discardReportDetail.setName(assDiscard.getTenantName());
			discardReportDetail.setType(DiscardUtils.getType(assDiscard.getType()));
			discardReportDetail.setStatus(DiscardUtils.getStatus(assDiscard.getStatus()));
			discardReportDetail.setApplyName(assDiscard.getApplyName());
			discardReportDetail.setApplyDate(assDiscard.getCreateTime());
			discardReportDetail.setExamineDate(assDiscard.getVerifyTime());
			discardReportDetail.setExamineName(assDiscard.getVerifyName());
			discardReportDetail.setRemarks(assDiscard.getRemarks());
			discardReportDetail.setIllustration(assDiscard.getApplyInstruction());
			discardReportDetail.setSuggestion(assDiscard.getVerifyOpinion());
			List<AssAssetsDiscard> list=assAssetsDiscardService.selectByAssDiscardId(id);
			List<AssetsDisInfo> assetList=new ArrayList<>();
			if(list!=null&&list.size()>0){
				for(AssAssetsDiscard assAssetsDiscard:list){
					AssetsDisInfo assetsDisInfo=new AssetsDisInfo();
					assetsDisInfo.setAssetsId(assAssetsDiscard.getAssetsId());
					assetsDisInfo.setAssetsSpec(assAssetsDiscard.getAssetsSpec());
					assetsDisInfo.setAssetsNum(assAssetsDiscard.getAssetsNum());
					assetsDisInfo.setSerialNum(assAssetsDiscard.getSerialNum());
					assetsDisInfo.setAssetsName(assAssetsDiscard.getAssetsName());
					assetsDisInfo.setStartUseDate(assAssetsDiscard.getStartUseDate());
					assetsDisInfo.setStatus(assAssetsDiscard.getType());
					assetsDisInfo.setFactoryName(assAssetsDiscard.getFactoryName());
					assetsDisInfo.setAssetsUnit(assAssetsDiscard.getUnitName());
					assetsDisInfo.setDeptName(assAssetsDiscard.getAssetsDeptName());
					assetList.add(assetsDisInfo);
				}
			}
			discardReportDetail.setAssetList(assetList);
			return discardReportDetail;
		}
		return null;
	}

	@Override
	public Integer statsWaitAudit(Long tenantId) {	
		return assDiscardMapper.statsWaitAudit(tenantId);
	}
	
}
