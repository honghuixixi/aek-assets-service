package com.aek.ebey.assets.model;

import java.io.Serializable;

import com.aek.common.core.base.BaseModel;

import io.swagger.annotations.ApiModelProperty;

/**
 * SysUser实体类
 *
 * @author ShenHuaJie
 * @version 2016-08-27 22:39:42
 */
public class SysUser extends BaseModel implements Serializable
{
    
    private static final long serialVersionUID = -3545227437609682989L;
    
    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String realName;
    
    public String getRealName()
    {
        return realName;
    }
    
    public void setRealName(String realName)
    {
        this.realName = realName;
    }
    
}
