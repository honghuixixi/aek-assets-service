package com.aek.ebey.assets.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.assets.model.Assets;
import com.aek.ebey.assets.model.AssetsCount;
import com.aek.ebey.assets.model.AssetsInfo;
import com.aek.ebey.assets.model.AssetsInfoExt;
import com.aek.ebey.assets.model.AssetsNumAndMoney;
import com.aek.ebey.assets.model.AssetsPm;
import com.aek.ebey.assets.model.AssetsQc;
import com.aek.ebey.assets.model.MtAssets;
import com.aek.ebey.assets.model.query.AssertQuery;
import com.aek.ebey.assets.model.query.AssertReportQuery;
import com.aek.ebey.assets.model.query.AssetsCurveQuery;
import com.aek.ebey.assets.model.query.LedgerPaging;
import com.aek.ebey.assets.model.query.MtAssertQuery;
import com.aek.ebey.assets.model.request.TenantAssets;
import com.aek.ebey.assets.model.vo.AssetsCurveVo;
import com.aek.ebey.assets.model.vo.AssetsScanVO;
import com.aek.ebey.assets.model.vo.AssetsStats2Vo;
import com.aek.ebey.assets.model.vo.AssetsStatsVo;
import com.aek.ebey.assets.model.vo.MdAssetsVO;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 资产信息表 Mapper 接口
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
public interface AssetsInfoMapper extends BaseMapper<AssetsInfo> {

	List<Assets> getAssetsPage(Page<Assets> page, @Param("q") AssertQuery query, @Param("user") AuthUser authUser);

	/**
	 * 台账列表查询
	 */
	List<Assets> getLedgerPage(Page<Assets> page, @Param("q") LedgerPaging query, @Param("user") AuthUser authUser);
	
	/**
	 * 新建转科单列表查询
	 */
	List<Assets> getTransferPage(Page<Assets> page, @Param("q") LedgerPaging query, @Param("user") AuthUser authUser);

	/**
	 * 预台账验收
	 */
	void updateVerify(Map<String, Object> map);

	/**
	 * 查询所有台账信息
	 */
	Assets getAssetsDetail(@Param("id") Long id, @Param("user") AuthUser authUser);

	/**
	 * 提交确认
	 */
	void addConfirm(AssetsInfoExt ext);

	/**
	 * 查询id是否存在
	 */
	Long checkId(long id);

	/**
	 * 查询预台账状态
	 */
	List<Map<String, Object>> getStatusNum(@Param("tenantId") Long tenantId);

	/**
	 * 台账状态数量查询
	 */
	List<Map<String, Object>> getAssetsStatusNum(@Param("tenantId") Long tenantId);

	/**
	 * 台账每种生成方式数量查询
	 * 
	 * @return [返回每种方式的数量集合]
	 */
	List<Map<String, Object>> getAssetsSourceNum(@Param("tenantId") Long tenantId);

	/**
	 * 台账导出查询
	 */
	List<Map<String, Object>> getReportAssetsList(AssertReportQuery query);

	/**
	 *
	 * @param deptIds 部门ID数组
	 * @return 是否存在设备使用信息
	 */
	Integer deviceQuery(@Param("deptIds") Long[] deptIds);

	/**
	 * 台账曲线图(初始数据)
	 */
	AssetsCurveVo queryAssetsHis(AssetsCurveQuery query);
	/**
	 * 台账曲线图
	 */
	List<AssetsCurveVo> queryAssetsCurve(AssetsCurveQuery query);
	
	List<AssetsCount> getAssetsCount(@Param("sysIds") Set<Long> set);

	AssetsNumAndMoney getAssetsNumAndMoney(@Param("sysIds") Set<Long> set);

	/**
	 * 
	 * @param info
	 * 更新台帐信息
	 */
	void updateAssetsInfoById(AssetsInfo info);
	/**
	 * 查询后更新
	 */
	int updateAfterSelect(AssetsInfo info);

	void updateBatchAssetsStatus(Map<String, Object> map);

	void updateBatchAssetsDepartment(Map<String, Object> map);

	void updateAssetsName(Map<String, Object> map);

	void batchInsert(List<AssetsInfo> assInfos);

	List<TenantAssets> getAssetsByTenantIds(@Param("ids")Long[] ids);

	List<Assets> getPageAssets(Page<Assets> page, @Param("q") LedgerPaging query, @Param("user") AuthUser authUser);
	
	List<Assets> getPageAssets2(Page<Assets> page, @Param("q") LedgerPaging query, @Param("user") AuthUser authUser);

	List<Assets> getPageAssets3(Page<Assets> page, @Param("q") LedgerPaging query, @Param("user") AuthUser authUser);
	
	/**
	 * 根据机构科室查询巡检设备列表
	 * @param tenantId
	 * @param deptIds
	 * @param authUser
	 * @return
	 */
	List<AssetsQc> getQcAssetsList(@Param("tenantId") Long tenantId,@Param("deptIds") Long[] deptIds, @Param("user") AuthUser authUser);
	
	/**
	 * 根据机构科室分页查询巡检设备列表
	 * @param tenantId
	 * @param deptIds
	 * @param authUser
	 * @return
	 */
	List<AssetsQc> getQcAssetsPage(Page page,@Param("tenantId") Long tenantId,@Param("deptIds") Long[] deptIds, @Param("user") AuthUser authUser);
	
	/**
	 * 分页拉取本机构所有未加入保养计划的资产
	 * @param page
	 * @param query
	 * @param authUser
	 * @return
	 */
	List<MtAssets> getMtAssetsPage(Page<MtAssets> page,@Param("query")MtAssertQuery query,@Param("user") AuthUser authUser);

	void updateBatchByIds(@Param("ids") List<Long> listAssetsIds);
	
	/**
	 * 根据资产ids和转科状态查询资产
	 * @param assetIds
	 * @return
	 */
	List<AssetsInfo> checkIsTransfer(@Param("assetIds") List<Long> assetIds,@Param("transferStatus") Integer transferStatus);

	 /** 根据机构查询PM设备列表
	 * @param tenantId
	 * @param authUser
	 * 
	 */
	List<AssetsPm> getPmAssetsList(@Param("tenantId") Long tenantId,@Param("departmentId")Long departmentId,@Param("keyword")String keyword,@Param("user") AuthUser authUser);
	
	/**
	 * 根据机构分页查询PM设备列表
	 * @param tenantId
	 * @param authUser
	 * @return
	 */
	List<AssetsPm> getPmAssetsPage(Page<AssetsPm> page,@Param("tenantId") Long tenantId,@Param("departmentId")Long departmentId,@Param("keyword")String keyword,@Param("user") AuthUser authUser);
	
	/**
	 * 查询设备状态
	 * @param assetId
	 * @return
	 */
	Integer getStatus(@Param("id") Integer assetId);
	
	/**
	 * 资产统计概览
	 * @param endTime
	 * @return
	 */
	List<AssetsStatsVo> statsAssetOverview(@Param("endTime") Date endTime);
	
	/**
	 * 按价值区间统计资产数目
	 * @param sort
	 * @param endTime
	 * @param tenantId
	 * @param minCapital
	 * @param maxCapital
	 * @return
	 */
	int statsDistributionCapitalRange(@Param("sort") int sort,@Param("endTime") Date endTime,@Param("tenantId") Long tenantId,@Param("minCapital") Double minCapital,@Param("maxCapital") Double maxCapital);
	
	/**
	 * 统计资产设备总数和设备总额
	 * @return
	 */
	List<AssetsStats2Vo> statsAssetsStats2(@Param("endTime") Date endTime);
	
	/**
	 * 根据扫码内容（资产ID/院内编码）
	 * @param scanResult
	 * @param tenantId
	 */
	AssetsScanVO getAssetsInfoByScanResult(@Param("scanResult") String scanResult, @Param("tenantId") Long tenantId);
	
	/**
	 * 质控填报，模糊查询拉设备
	 * @param tenantId
	 * @param assetsName
	 * @return
	 */
	List<MdAssetsVO> getMdAssets(@Param("tenantId")Long tenantId,@Param("assetsName") String assetsName);
	
	/**
	 * 通过sql查询数据
	 * @param sql
	 * @return
	 */
	List<Map<String,Object>> selectListSql(@Param("sql") String sql);
}