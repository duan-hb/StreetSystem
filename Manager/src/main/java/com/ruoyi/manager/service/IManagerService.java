package com.ruoyi.manager.service;

import java.util.List;
import com.ruoyi.manager.domain.Manager;

/**
 * 管理员信息管理Service接口
 *
 * @author D.D.D
 * @date 2025-03-26
 */
public interface IManagerService
{
    /**
     * 查询管理员信息管理
     *
     * @param id 管理员信息管理主键
     * @return 管理员信息管理
     */
    public Manager selectManagerById(Long id);

    /**
     * 查询管理员信息管理列表
     *
     * @param manager 管理员信息管理
     * @return 管理员信息管理集合
     */
    public List<Manager> selectManagerList(Manager manager);

    /**
     * 新增管理员信息管理
     *
     * @param manager 管理员信息管理
     * @return 结果
     */
    public int insertManager(Manager manager);

    /**
     * 修改管理员信息管理
     *
     * @param manager 管理员信息管理
     * @return 结果
     */
    public int updateManager(Manager manager);

    /**
     * 批量删除管理员信息管理
     *
     * @param ids 需要删除的管理员信息管理主键集合
     * @return 结果
     */
    public int deleteManagerByIds(Long[] ids);

    /**
     * 删除管理员信息管理信息
     *
     * @param id 管理员信息管理主键
     * @return 结果
     */
    public int deleteManagerById(Long id);
}
