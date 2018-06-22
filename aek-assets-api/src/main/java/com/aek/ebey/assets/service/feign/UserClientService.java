package com.aek.ebey.assets.service.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aek.common.core.Result;
import com.aek.ebey.assets.model.DeptNameAndUserName;
import com.aek.ebey.assets.service.feign.vo.DeptVo;
import com.aek.ebey.assets.service.feign.vo.TenantVo;

/**
 * 用户远程调用接口value=${feign-sys.serviceId}
 */
@FeignClient(value="${feign-sys.serviceId}", fallback = UserClientHystrix.class)
public interface UserClientService {
	/**
	 * 调用接口，用用户ids 查找用户名称
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sys/invoke/user/list/{ids}")
	Result<List<DeptNameAndUserName>> findByIds(@PathVariable(value = "ids") String ids,
			@RequestHeader("X-AEK56-Token") String token);

	/**
	 * 调用接口，用部门ids 查找部门名称
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sys/invoke/dept/list/{ids}")
	Result<List<DeptNameAndUserName>> findByDeptIds(@PathVariable(value = "ids") String ids,
			@RequestHeader("X-AEK56-Token") String token);

	/**
	 * 根据用户id、机构、权限code查询用户指定权限数据范围
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sys/invoke/role/user/{userId}/tenantId/{tenantId}/permissCode/{code}")
	public Result<Integer> findUserDateScopeByPermissCode(@PathVariable(value = "userId", required = true) Long userId,
			@PathVariable(value = "tenantId", required = true) Long tenantId,
			@PathVariable(value = "code", required = true) String code, @RequestHeader("X-AEK56-Token") String token);

	/**
	 * 根据部门id查询子部门集合
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sys/invoke/dept/{deptId}/sub")
	public Result<String> findAllSubDeptById(@PathVariable(value = "deptId", required = true) Long deptId,
			@RequestHeader("X-AEK56-Token") String token);

	/**
	 * 根据部门id查询子部门集合
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sys/dept/search/tenant/{tenantId}")
	public Result<List<DeptVo>> findDeptNameById(@PathVariable(value = "tenantId", required = true) Long tenantId,
			@RequestHeader("X-AEK56-Token") String token, @RequestParam("name") String name);

	/**
	 * 查询监管机构所监管的医疗机构
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sys/invoke/tenant/{tenantId}/hplTenantIds")
	public Result<List<Long>> findTenantidsById(@PathVariable(value = "tenantId", required = true) Long tenantId,
			@RequestHeader("X-AEK56-Token") String token);
	
	/**
	 * 查询平台所有的医疗机构
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sys/invoke/tenant/all/hplTenantIds")
	public Result<List<Long>> findAllHplTenant(@RequestHeader("X-AEK56-Token") String token);
	
	/**
	 * 查询机构信息
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sys/invoke/tenant/{tenantId}")
	public Result<TenantVo> findTenantById(@PathVariable(value = "tenantId", required = true) Long tenantId,
			@RequestHeader("X-AEK56-Token") String token);

	/**
	 * 根据机构id查询所有的部门包括根部门
	 * @param tenantId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sys/invoke/dept/getAllDepts")
	public Result<List<DeptVo>> getAllDepts(@RequestParam("tenantId") Long tenantId,@RequestHeader("X-AEK56-Token") String token);
}