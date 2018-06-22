package com.aek.ebey.assets.service.feign;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import com.aek.common.core.Result;
import com.aek.ebey.assets.model.DeptNameAndUserName;
import com.aek.ebey.assets.service.feign.vo.DeptVo;
import com.aek.ebey.assets.service.feign.vo.TenantVo;

/**
 * 断路器
 */
@Component
public class UserClientHystrix implements UserClientService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserClientHystrix.class);

	@Override
	public Result<Integer> findUserDateScopeByPermissCode(Long userId, Long tenantId, String code, String token) {
		logger.error("userId="+String.valueOf(userId)+", tenantId="+String.valueOf(tenantId)+", code="+code);
		logger.error(token);
		return null;
	}

	@Override
	public Result<String> findAllSubDeptById(Long deptId, String token) {
		logger.error("deptId="+String.valueOf(deptId));
		logger.error(token);
		return null;
	}

	@Override
	public Result<List<DeptNameAndUserName>> findByIds(String ids, String token) {
		logger.error("ids="+ids);
		logger.error(token);
		return null;
	}

	@Override
	public Result<List<DeptNameAndUserName>> findByDeptIds(String ids, String token) {
		logger.error("ids="+ids);
		logger.error(token);
		return null;
	}

	@Override
	public Result<List<DeptVo>> findDeptNameById(Long tenantId, String token, String name) {
		logger.error("tenantId="+String.valueOf(tenantId)+", name="+name);
		logger.error(token);
		return null;
	}

	@Override
	public Result<List<Long>> findTenantidsById(Long tenantId, String token) {
		logger.error("tenantId="+String.valueOf(tenantId));
		logger.error(token);
		return null;
	}
	
	@Override
	public Result<List<Long>> findAllHplTenant(@RequestHeader("X-AEK56-Token") String token){
		logger.error(token);
		return null;
	}

	@Override
	public Result<List<DeptVo>> getAllDepts(Long tenantId,String token) {
		logger.error("tenantId="+tenantId);
		logger.error(token);
		return null;
	}

	@Override
	public Result<TenantVo> findTenantById(Long tenantId, String token) {
		logger.error("tenantId="+tenantId);
		logger.error(token);
		return null;
	}
	
	
}
