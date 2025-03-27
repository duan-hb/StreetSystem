package com.ruoyi.store.mapper;

import java.util.List;
import com.ruoyi.store.domain.Store;

/**
 * 店铺管理Mapper接口
 *
 * @author EMANON
 * @date 2025-03-27
 */
public interface StoreMapper
{
    /**
     * 查询店铺管理
     *
     * @param id 店铺管理主键
     * @return 店铺管理
     */
    public Store selectStoreById(Long id);

    /**
     * 查询店铺管理列表
     *
     * @param store 店铺管理
     * @return 店铺管理集合
     */
    public List<Store> selectStoreList(Store store);

    /**
     * 新增店铺管理
     *
     * @param store 店铺管理
     * @return 结果
     */
    public int insertStore(Store store);

    /**
     * 修改店铺管理
     *
     * @param store 店铺管理
     * @return 结果
     */
    public int updateStore(Store store);

    /**
     * 删除店铺管理
     *
     * @param id 店铺管理主键
     * @return 结果
     */
    public int deleteStoreById(Long id);

    /**
     * 批量删除店铺管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStoreByIds(Long[] ids);
}

