package com.aek.ebey.assets.service;
import java.util.List;
import java.util.Map;

import com.aek.common.core.base.BaseService;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.assets.model.AssAssetsInfoOperate;
import com.aek.ebey.assets.model.Assets;
import com.aek.ebey.assets.model.AssetsCount;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.AssetsInfoExt;
import com.aek.ebey.assets.model.AssetsNumAndMoney;
import com.aek.ebey.assets.model.AssetsPm;
import com.aek.ebey.assets.model.AssetsQc;
import com.aek.ebey.assets.model.AssetsSource;
import com.aek.ebey.assets.model.AssetsVerfyStatus;
import com.aek.ebey.assets.model.Contract;
import com.aek.ebey.assets.model.Feilds;
import com.aek.ebey.assets.model.MtAssets;
import com.aek.ebey.assets.model.query.AssertQuery;
import com.aek.ebey.assets.model.query.AssertReportQuery;
import com.aek.ebey.assets.model.query.LedgerPaging;
import com.aek.ebey.assets.model.query.MtAssertQuery;
import com.aek.ebey.assets.model.query.PmAssertPaging;
import com.aek.ebey.assets.model.request.AssetsCurveRequest;
import com.aek.ebey.assets.model.request.AssetsInfoRequest;
import com.aek.ebey.assets.model.request.EditAssetsInfoRequest;
import com.aek.ebey.assets.model.request.PreAssetsInfoRequest;
import com.aek.ebey.assets.model.request.TenantAssets;
import com.aek.ebey.assets.model.vo.AssetsCurveVo;
import com.aek.ebey.assets.model.vo.AssetsScanVO;
import com.aek.ebey.assets.model.vo.AssetsStats2Vo;
import com.aek.ebey.assets.model.vo.AssetsStatsVo;
import com.aek.ebey.assets.model.vo.MdAssetsVO;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 预台账接口
 */
public interface AssetsInfoService extends BaseService<AssetsInfo> {

	/**
	 * 预台账确认
	 */
	public void addConfirm(Long id);


	/**
	 * 资产分页查询
	 */
	public Page<Assets> getAssetsPage(Page<Assets> page, AssertQuery query);

	/**
	 * 预台账验收 <通过与不通过，修改验收信息>
	 * 
	 * @param id
	 *            台账ID
	 * @param verifyDate
	 *            验收日期
	 * @param verifyRemark
	 *            验收说明
	 * @param verifyStatus
	 *            状态(1：未审核 2:通过 3:不通过)
	 */
	public void verify(Long id, Long verifyDate, String verifyRemark, String verifyStatus);

	/**
	 * 预台账详情查询
	 */
	public Assets getAssetsDetail(Long id);

	/**
	 * 预台账状态数量查询
	 */
	AssetsVerfyStatus getStatusNum(Long tenantId);

	/**
	 * 删除预台账
	 */
	public void delAssets(Long id);

	/**
	 * 资产台账状态数量查询
	 */
	List<Map<String, Object>> getAssetsStatusNum(Long tenantId);

	/**
	 * 资产台账的生成方式【批量导入/入库新增】
	 */
	AssetsSource getAssetsSourceNum(Long tenantId);

	/**
	 * 台账列表分页查询
	 * 
	 * @param query
	 *            【状态，来源，可是，设备名称/编号，排序】
	 */
	public Page<Assets> getLedgerPage(Page<Assets> page, LedgerPaging query);
	
	/**
	 * 新建转科单列表查询
	 */
	public Page<Assets> getTransferPage(LedgerPaging query);

	/**
	 * 台账导出查询
	 */
	public List<Map<String, Object>> getReportAssetsList(AssertReportQuery query);

	/**
	 * 批量插入数据
	 */
	public void addAssetsByImport(List<AssetsInfo> assetInfos, List<AssetsInfoExt> assetExts, String uploadId, String token, AuthUser authUser);

	/**
	 * 查询部门ID下是否有台账信息
	 * 
	 * @param deptIds
	 *            部门ID集合
	 * @return 返回是否存在台账信息
	 * 
	 * @return Boolean [返回是否存在台账信息]
	 */
	public Boolean deviceQuery(Long[] deptIds);

	/**
	 * 仅给前端提供导出 需要的所有字段
	 */
	public List<Feilds> fieldDisplay();

	List<AssetsCurveVo> queryAssetsCurve1(AssetsCurveRequest req);

	/**
	 * 
	 * @param tenantid
	 * @return 根据tenantid进行统计
	 */
	public List<AssetsCount> getAssetsCount(Long tenantid);

	/**
	 * 
	 * @param tenantid
	 * @return 根据tenantid统计资产数跟资产金额
	 */

	public AssetsNumAndMoney getAssetsNumAndMoney(Long tenantid);

	String generateAssetsNum(Long tenantId);
	/**
	 * 
	 * @param tenantId
	 * @param module
	 *            1:设备
	 *            2:转科
	 *            3:报废
	 * @param count
	 * @return 根据tenantId生成流水号
	 */
	public Long getSerialNumber(Long tenantId, int module, int count, boolean updateDB);
	
	/**
	 * 编辑预台账接口
	 * @param assetsInfo
	 * @param assetsInfoExt
	 * @param request
	 * @param contract
	 * @param s
	 */
	public void editPreAssets(AssetsInfo assetsInfo, AssetsInfoExt assetsInfoExt,EditAssetsInfoRequest request,Contract contract,String s);
	
	/**
	 * 编辑台账接口,并记录台账编辑日志
	 * @param assetsInfo
	 * @param assetsInfoExt
	 * @param request
	 * @param contract
	 * @param s
	 */
	public void editAssets(AssetsInfo assetsInfo, AssetsInfoExt assetsInfoExt,EditAssetsInfoRequest request,Contract contract,String s);

	public void updateBatchAssetsStatus(Map<String,Object> params);

	public void updateBatchAssetsDepartment(Map<String, Object> params);

	public void updateAssetsName(Map<String, Object> params);

	/**
	 * 新增资产台账
	 * @param data
	 */
	public void addAssetsInfo(AssetsInfoRequest data);
	
	/**
	 * 新增预台账
	 * @param data
	 */
	public void addPreAssetsInfo(PreAssetsInfoRequest data);

	public List<TenantAssets> getAssetsByTenantIds(Long[] ids);

	public Page<?> getPageAssets(Page<Assets> page, LedgerPaging query);

	public void getList(List<AssAssetsInfoOperate> list);
	
	int updateAfterSelect(AssetsInfo info);
	
	/**
	 * 根据机构科室查询巡检设备列表
	 * @param tenantId
	 * @param deptIds
	 * @param authUser
	 * @return
	 */
	List<AssetsQc> getQcAssetsList(Long tenantId,Long[] deptIds);
	
	/**
	 * 根据机构科室分页查询巡检设备列表
	 * @param tenantId
	 * @param deptIds
	 * @param authUser
	 * @return
	 */
	Page<AssetsQc> getQcAssetsPage(Page page,Long tenantId,Long[] deptIds);
	
	/**
	 * 分页拉取本机构所有未加入保养计划的资产
	 * @param query
	 * @return
	 */
	Page<MtAssets> getMtAssetsPage(MtAssertQuery query);
	
	/**
	 * 批量修改设备是否已经在保养计划
	 * @param assetIds
	 * @param flag
	 */
	public void changeMtPlanFlag(List<Long> assetIds,Integer flag);
	
	public void updateBatchByIds(List<Long> listAssetsIds);
	
	 /** 根据机构查询PM设备列表
	 * @param tenantId
	 * @param authUser
	 * 
	 */
	List<AssetsPm> getPmAssetsList(Long tenantId,Long departmentId,String keyword);
	
	/**
	 * 根据机构分页查询PM设备列表
	 * @param tenantId
	 * @param authUser
	 * @return
	 */
	Page<AssetsPm> getPmAssetsPage(Page<AssetsPm> page, PmAssertPaging query,Long tenantId);
	
	 /* 根据SQL查询数据
	 * @param sql
	 * @return
	 */
	Map<String,Object> selectListSql(String sql);
	
	/**
	 * 获取资产概览统计数据
	 * @return
	 */
	List<AssetsStatsVo> getAssetsData();
	
	/**
	 * 获取资产月份统计数据
	 * @return
	 */
	List<AssetsStats2Vo> addAssetsDataMonth();
	
	/**
	 * 根据扫码内容(资产ID/院内编码)
	 * @param scanResult
	 * @param tenangId
	 * @return
	 */
	AssetsScanVO getAssetsInfoByScanResult(String scanResult,Long tenantId);
	
	/**
	 * 质控填报，模糊查询拉设备
	 * @param tenantId
	 * @param assetsName
	 * @return
	 */
	List<MdAssetsVO> getMdAssets(String assetsName);
}
