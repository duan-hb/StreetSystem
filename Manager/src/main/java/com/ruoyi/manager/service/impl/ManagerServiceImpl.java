package com.ruoyi.manager.service.impl;

import java.util.List;

import com.ruoyi.manager.domain.Manager;
import com.ruoyi.manager.mapper.ManagerMapper;
import com.ruoyi.manager.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员信息管理Service业务层处理
 *
 * @author D.D.D
 * @date 2025-03-26
 */
@Service
public class ManagerServiceImpl implements IManagerService
{
    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 查询管理员信息管理
     *
     * @param id 管理员信息管理主键
     * @return 管理员信息管理
     */
    @Override
    public Manager selectManagerById(Long id)
    {
        return managerMapper.selectManagerById(id);
    }

    /**
     * 查询管理员信息管理列表
     *
     * @param manager 管理员信息管理
     * @return 管理员信息管理
     */
    @Override
    public List<Manager> selectManagerList(Manager manager)
    {
        return managerMapper.selectManagerList(manager);
    }

    /**
     * 新增管理员信息管理
     *
     * @param manager 管理员信息管理
     * @return 结果
     */
    @Override
    public int insertManager(Manager manager)
    {
        return managerMapper.insertManager(manager);
    }

    /**
     * 修改管理员信息管理
     *
     * @param manager 管理员信息管理
     * @return 结果
     */
    @Override
    public int updateManager(Manager manager)
    {
        return managerMapper.updateManager(manager);
    }

    /**
     * 批量删除管理员信息管理
     *
     * @param ids 需要删除的管理员信息管理主键
     * @return 结果
     */
    @Override
    public int deleteManagerByIds(Long[] ids)
    {
        return managerMapper.deleteManagerByIds(ids);
    }

    /**
     * 删除管理员信息管理信息
     *
     * @param id 管理员信息管理主键
     * @return 结果
     */
    @Override
    public int deleteManagerById(Long id)
    {
        return managerMapper.deleteManagerById(id);
    }
}
