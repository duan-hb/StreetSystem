package com.ruoyi.store.service.impl;

import java.util.List;

import com.ruoyi.merchants.domain.Merchants;
import com.ruoyi.merchants.mapper.MerchantsMapper;
import com.ruoyi.merchantsstore.mapper.MerchantsStoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.store.mapper.StoreMapper;
import com.ruoyi.store.domain.Store;
import com.ruoyi.store.service.IStoreService;

/**
 * 店铺管理Service业务层处理
 *
 * @author EMANON
 * @date 2025-03-27
 */
@Service
public class StoreServiceImpl implements IStoreService
{
    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private MerchantsMapper merchantsMapper;
    @Autowired
    private MerchantsStoreMapper merchantsStoreMapper;

    /**
     * 查询店铺管理
     *
     * @param id 店铺管理主键
     * @return 店铺管理
     */
    @Override
    public Store selectStoreById(Long id)
    {
        return storeMapper.selectStoreById(id);
    }

    /**
     * 查询店铺管理列表
     *
     * @param store 店铺管理
     * @return 店铺管理
     */
    @Override
    public List<Store> selectStoreList(Store store)
    {
        List<Store> stores = storeMapper.selectStoreList(store);
        return stores;
    }

    /**
     * 新增店铺管理
     *
     * @param store 店铺管理
     * @return 结果
     */
    @Override
    public int insertStore(Store store)
    {
        return storeMapper.insertStore(store);
    }

    /**
     * 修改店铺管理
     *
     * @param store 店铺管理
     * @return 结果
     */
    @Override
    public int updateStore(Store store)
    {
        Merchants merchants = store.getMerchants();
        Long oldId = merchants.getId(); //改前的持有者id
        String newName = merchants.getName(); //改后的持有者名字
        Long storeId = store.getId(); //店铺id
        //需要获取改后的持有者id
        int newId = merchantsMapper.selectMerchantsByName(newName);
        // 修改中间表
        int i = merchantsStoreMapper.updateMerchantsStore(oldId,newId,storeId);
        int j = storeMapper.updateStore(store);
        //可用自定义错误捕获，待定
        return j;
    }

    /**
     * 批量删除店铺管理
     *
     * @param ids 需要删除的店铺管理主键
     * @return 结果
     */
    @Override
    public int deleteStoreByIds(Long[] ids)
    {
        //删除中间表
        int i = merchantsStoreMapper.deletStore(ids);
        return storeMapper.deleteStoreByIds(ids);
    }

    /**
     * 删除店铺管理信息
     *
     * @param id 店铺管理主键
     * @return 结果
     */
    @Override
    public int deleteStoreById(Long id)
    {

        return storeMapper.deleteStoreById(id);
    }
}

