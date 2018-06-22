package com.aek.ebey.assets.model.query;

import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.assets.model.vo.AssetArchiveVo;

public class NewArchiveQuery extends PageHelp<AssetArchiveVo>{

	private String keyword;	
	private Long deptId;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	
}
