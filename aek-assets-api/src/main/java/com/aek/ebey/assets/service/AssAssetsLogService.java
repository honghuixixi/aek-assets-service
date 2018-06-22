package com.aek.ebey.assets.service;

import com.aek.ebey.assets.model.AssAssetsLog;
import com.aek.ebey.assets.model.query.AssAssetsLogQuery;
import com.baomidou.mybatisplus.plugins.Page;
import com.aek.ebey.assets.model.AssAssetsLogDetail;
import com.aek.ebey.assets.model.AssetsLog;
import com.aek.ebey.assets.model.AssetsLogDetail;

import java.util.List;
import com.aek.common.core.base.BaseService;
import com.aek.common.core.serurity.model.AuthUser;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyl
 * @since 2017-12-25
 */
public interface AssAssetsLogService extends BaseService<AssAssetsLog> {
	
	public Page<AssetsLog> getLogPage(AssAssetsLogQuery query);
	
	AssetsLogDetail getLogDetail(Long id);
	/**
	 * 保存资产修改日志
	 * @param assAssetsLog
	 * @param assAssetsLogDetailList
	 */
	public void saveAssAssetsLog(AuthUser currentUser,String currentToken,AssAssetsLog assAssetsLog, List<AssAssetsLogDetail> assAssetsLogDetailList,String operateDesc);
}
