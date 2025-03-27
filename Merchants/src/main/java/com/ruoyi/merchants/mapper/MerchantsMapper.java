package com.ruoyi.merchants.mapper;

import java.util.List;
import com.ruoyi.merchants.domain.Merchants;

/**
 * 店铺信息管理Mapper接口
 *
 * @author EMANON
 * @date 2025-03-27
 */
public interface MerchantsMapper
{
    /**
     * 查询店铺信息管理
     *
     * @param id 店铺信息管理主键
     * @return 店铺信息管理
     */
    public Merchants selectMerchantsById(Long id);

    /**
     * 查询店铺信息管理列表
     *
     * @param merchants 店铺信息管理
     * @return 店铺信息管理集合
     */
    public List<Merchants> selectMerchantsList(Merchants merchants);

    /**
     * 新增店铺信息管理
     *
     * @param merchants 店铺信息管理
     * @return 结果
     */
    public int insertMerchants(Merchants merchants);

    /**
     * 修改店铺信息管理
     *
     * @param merchants 店铺信息管理
     * @return 结果
     */
    public int updateMerchants(Merchants merchants);

    /**
     * 删除店铺信息管理
     *
     * @param id 店铺信息管理主键
     * @return 结果
     */
    public int deleteMerchantsById(Long id);

    /**
     * 批量删除店铺信息管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMerchantsByIds(Long[] ids);
}

