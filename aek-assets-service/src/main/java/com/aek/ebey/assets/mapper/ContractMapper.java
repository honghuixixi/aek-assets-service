package com.aek.ebey.assets.mapper;

import com.aek.common.core.base.BaseMapper;
import com.aek.ebey.assets.model.Contract;

/**
 * <p>
  * 设备合同信息 Mapper 接口
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
public interface ContractMapper extends BaseMapper<Contract>
{
    
    /**
     * <一句话功能简述>根据资产id修改合同
     * <功能详细描述>
     * @param amContract [参数说明]
     * 
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    void updateByAssetsId(Contract amContract);

	void updateContractAsset(Contract contract);
    
}