package com.aek.ebey.assets.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 基本代码表
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_code_info")
public class CodeInfo extends BaseModel
{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 基础数据ID。主键
     */
    private Long id;
    
    /**
     * 区域id
     */
    @TableField(value = "area_id")
    private Integer areaId;
    
    /**
     * 系统ID。用于区分不同医院
     */
    @TableField(value = "sys_id")
    private Long sysId;
    
    /**
     * 基础数据分类ID
     */
    @TableField(value = "type_id")
    private Long typeId;
    
    /**
     * 父代码类型ID
     */
    @TableField(value = "parent_type_id")
    private Long parentTypeId;
    
    /**
     * 同一分类下代码顺序。从1开始编号
     */
    @TableField(value = "code_index")
    private Long codeIndex;
    
    /**
     * 基础数据文字
     */
    @TableField(value = "code_text")
    private String codeText;
    
    /**
     * 基本数据拼音输入码
     */
    @TableField(value = "code_text_py")
    private String codeTextPy;
    
    /**
     * 基础数据值
     */
    @TableField(value = "code_value")
    private String codeValue;
    
    /**
     * 基础数据描述/备注
     */
    @TableField(value = "code_desc")
    private String codeDesc;
    
    /**
     * 父代码ID
     */
    @TableField(value = "parent_code_id")
    private Long parentCodeId;
    
    /**
     * 添加人
     */
    @TableField(value = "create_by")
    private Long createBy;
    
    /**
     * 添加时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 最后修改人
     */
    @TableField(value = "update_by")
    private Long updateBy;
    
    /**
     * 最后修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
    
    /**
     * 作废标记
     */
    @TableField(value = "del_flag")
    private Boolean delFlag; 
    
    @Override
    public Long getId()
    {
        return id;
    }
    
    @Override
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Integer getAreaId()
    {
        return areaId;
    }
    
    public void setAreaId(Integer areaId)
    {
        this.areaId = areaId;
    }
    
    public Long getSysId()
    {
        return sysId;
    }
    
    public void setSysId(Long sysId)
    {
        this.sysId = sysId;
    }
    
    public Long getTypeId()
    {
        return typeId;
    }
    
    public void setTypeId(Long typeId)
    {
        this.typeId = typeId;
    }
    
    public Long getParentTypeId()
    {
        return parentTypeId;
    }
    
    public void setParentTypeId(Long parentTypeId)
    {
        this.parentTypeId = parentTypeId;
    }
    
    public Long getCodeIndex()
    {
        return codeIndex;
    }
    
    public void setCodeIndex(Long codeIndex)
    {
        this.codeIndex = codeIndex;
    }
    
    public String getCodeText()
    {
        return codeText;
    }
    
    public void setCodeText(String codeText)
    {
        this.codeText = codeText;
    }
    
    public String getCodeTextPy()
    {
        return codeTextPy;
    }
    
    public void setCodeTextPy(String codeTextPy)
    {
        this.codeTextPy = codeTextPy;
    }
    
    public String getCodeValue()
    {
        return codeValue;
    }
    
    public void setCodeValue(String codeValue)
    {
        this.codeValue = codeValue;
    }
    
    public String getCodeDesc()
    {
        return codeDesc;
    }
    
    public void setCodeDesc(String codeDesc)
    {
        this.codeDesc = codeDesc;
    }
    
    public Long getParentCodeId()
    {
        return parentCodeId;
    }
    
    public void setParentCodeId(Long parentCodeId)
    {
        this.parentCodeId = parentCodeId;
    }

    public Long getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(Long createBy)
    {
        this.createBy = createBy;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Long getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy)
    {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public Boolean getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag)
    {
        this.delFlag = delFlag;
    }
    
}
