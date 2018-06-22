package com.aek.ebey.assets.service.utils;

import com.aek.common.core.serurity.model.AuthUser;

public class AuthUserUtil {

	/**
	 * 
	 * @param deptId
	 * @param authUser
	 * @return
	 * 是否有权限
	 */
	public static boolean hasPower(Integer deptId, AuthUser authUser) {
		
		if(authUser!=null&&deptId!=null){
			
			if(authUser.getDataScope()!=null){
				
				if(authUser.getDataScope().intValue()==2){
					if(authUser.getDeptIds()!=null&&authUser.getDeptIds().contains(Long.parseLong(deptId+""))){
						return true;
					}else{
						return false;
					}
				}
				if(authUser.getDataScope().intValue()==4){
					if(authUser.getDefinedDeptIds()!=null&&authUser.getDefinedDeptIds().contains(Long.parseLong(deptId+""))){
						return true;
					}else{
						return false;
					}
				}
				if(authUser.getDataScope().intValue()==1||authUser.getDataScope().intValue()==3){
					if(authUser.getDeptId()!=null){
						if(authUser.getDeptId().longValue()!=Long.parseLong(deptId+"")){
							return false;
						}else{
							return true;
						}
					}else{
						return false;
					}
				}
				
			}else{
				if(authUser.getDeptId()!=null){
					
					if(authUser.getDeptId().longValue()!=Long.parseLong(deptId+"")){
						return false;
					}else{
						return true;
					}
				}else{
					return false;
				}
			}
		}
		return false;
	}

}
