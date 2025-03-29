package com.ruoyi.merchants.service.impl;

import java.util.List;

import com.ruoyi.merchantsstore.mapper.MerchantsStoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.merchants.mapper.MerchantsMapper;
import com.ruoyi.merchants.domain.Merchants;
import com.ruoyi.merchants.service.IMerchantsService;

/**
 * 店铺信息管理Service业务层处理
 *
 * @author EMANON
 * @date 2025-03-27
 */
@Service
public class MerchantsServiceImpl implements IMerchantsService
{
    @Autowired
    private MerchantsMapper merchantsMapper;
    @Autowired
    private MerchantsStoreMapper merchantsStoreMapper;

    /**
     * 查询店铺信息管理
     *
     * @param id 店铺信息管理主键
     * @return 店铺信息管理
     */
    @Override
    public Merchants selectMerchantsById(Long id)
    {
        return merchantsMapper.selectMerchantsById(id);
    }

    /**
     * 查询店铺信息管理列表
     *
     * @param merchants 店铺信息管理
     * @return 店铺信息管理
     */
    @Override
    public List<Merchants> selectMerchantsList(Merchants merchants)
    {
        return merchantsMapper.selectMerchantsList(merchants);
    }

    /**
     * 新增店铺信息管理
     *
     * @param merchants 店铺信息管理
     * @return 结果
     */
    @Override
    public int insertMerchants(Merchants merchants)
    {
        return merchantsMapper.insertMerchants(merchants);
    }

    /**
     * 修改店铺信息管理
     *
     * @param merchants 店铺信息管理
     * @return 结果
     */
    @Override
    public int updateMerchants(Merchants merchants)
    {
        return merchantsMapper.updateMerchants(merchants);
    }

    /**
     * 批量删除店铺信息管理
     *
     * @param ids 需要删除的店铺信息管理主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsByIds(Long[] ids)
    {
        //中间表mid设为0
        int i = merchantsStoreMapper.updateMerchantsIdToZero(ids);
        return merchantsMapper.deleteMerchantsByIds(ids);
    }

    /**
     * 删除店铺信息管理信息
     *
     * @param id 店铺信息管理主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsById(Long id)
    {
        return merchantsMapper.deleteMerchantsById(id);
    }
}

