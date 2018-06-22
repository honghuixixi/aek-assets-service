package com.aek.ebey.assets.model;

import java.io.Serializable;

/**
 * 
 * 用以去其他API 查询 科室名称 和 创建人名称
 * 
 * @author  zhousixiong
 * @version  1.0, 2017年5月23日
 */
public class DeptNameAndUserName implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private Long id;//如果用以查询部门，则这是部门id  如果用以 查询 realname 则是用户id
    private String name;//部门名称
    private String realName;//创建人姓名
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getRealName()
    {
        return realName;
    }
    public void setRealName(String realName)
    {
        this.realName = realName;
    }
    
    
}
