package com.aek.ebey.assets.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 资产资金来源表
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@TableName("ass_assets_fund_sources")
public class AssetsFundSources extends BaseModel
{
    
    private static final long serialVersionUID = 1L;
      
    /**
     * 资产ID
     */
    @TableField(value = "assets_id")
    private Long assetsId;
    
    /**
     * 经费来源ID
     */
    @TableField(value = "fund_sources_id")
    private Integer fundSourcesId;
    
    /**
     * 经费比例
     */
    @TableField(value = "fund_percent")
    private String fundPercent;
    
    
    /**
     * 经费来源金额
     */
    @TableField(value = "fund_source_money")
    private Long fundSourceMoney;
    
    /**
     * 经费来源金额
     */
    @TableField(exist=false)
    private String fundSourceMoneyStr;
      
    /**
     * 经费来源文字说明
     */
    @TableField(value = "fund_sources_text")
    private String fundSourcesText;
       
    public Long getAssetsId()
    {
        return assetsId;
    }
    
    public void setAssetsId(Long assetsId)
    {
        this.assetsId = assetsId;
    }
    
    public Integer getFundSourcesId()
    {
        return fundSourcesId;
    }
    
    public void setFundSourcesId(Integer fundSourcesId)
    {
        this.fundSourcesId = fundSourcesId;
    }
    
    public String getFundSourcesText()
    {
        return fundSourcesText;
    }
    
    public void setFundSourcesText(String fundSourcesText)
    {
        this.fundSourcesText = fundSourcesText;
    }
    
    public Long getFundSourceMoney()
    {
        return fundSourceMoney;
    }
    
    public void setFundSourceMoney(Long fundSourceMoney)
    {
        this.fundSourceMoney = fundSourceMoney;
    }
    

    public String getFundPercent()
    {
        return fundPercent;
    }

    public void setFundPercent(String fundPercent)
    {
        this.fundPercent = fundPercent;
    }

	public String getFundSourceMoneyStr() {
		return fundSourceMoneyStr;
	}

	public void setFundSourceMoneyStr(String fundSourceMoneyStr) {
		this.fundSourceMoneyStr = fundSourceMoneyStr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetsId == null) ? 0 : assetsId.hashCode());
		result = prime * result + ((fundPercent == null) ? 0 : fundPercent.hashCode());
		result = prime * result + ((fundSourceMoney == null) ? 0 : fundSourceMoney.hashCode());
		result = prime * result + ((fundSourceMoneyStr == null) ? 0 : fundSourceMoneyStr.hashCode());
		result = prime * result + ((fundSourcesId == null) ? 0 : fundSourcesId.hashCode());
		result = prime * result + ((fundSourcesText == null) ? 0 : fundSourcesText.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetsFundSources other = (AssetsFundSources) obj;
		if (assetsId == null) {
			if (other.assetsId != null)
				return false;
		} else if (!assetsId.equals(other.assetsId))
			return false;
		if (fundPercent == null) {
			if (other.fundPercent != null)
				return false;
		} else if (!fundPercent.equals(other.fundPercent))
			return false;
		if (fundSourceMoney == null) {
			if (other.fundSourceMoney != null)
				return false;
		} else if (!fundSourceMoney.equals(other.fundSourceMoney))
			return false;
		if (fundSourcesId == null) {
			if (other.fundSourcesId != null)
				return false;
		} else if (!fundSourcesId.equals(other.fundSourcesId))
			return false;
		if (fundSourcesText == null) {
			if (other.fundSourcesText != null)
				return false;
		} else if (!fundSourcesText.equals(other.fundSourcesText))
			return false;
		return true;
	}
    
}
