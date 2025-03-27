package com.ruoyi.store.service.impl;

import java.util.List;
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
        return storeMapper.selectStoreList(store);
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
        return storeMapper.updateStore(store);
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

