package com.ruoyi.complaints.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.complaints.mapper.ComplaintsMapper;
import com.ruoyi.complaints.domain.Complaints;
import com.ruoyi.complaints.service.IComplaintsService;

/**
 * 用户投诉Service业务层处理
 *
 * @author EMANON
 * @date 2025-03-27
 */
@Service
public class ComplaintsServiceImpl implements IComplaintsService
{
    @Autowired
    private ComplaintsMapper complaintsMapper;

    /**
     * 查询用户投诉
     *
     * @param id 用户投诉主键
     * @return 用户投诉
     */
    @Override
    public Complaints selectComplaintsById(Long id)
    {
        return complaintsMapper.selectComplaintsById(id);
    }

    /**
     * 查询用户投诉列表
     *
     * @param complaints 用户投诉
     * @return 用户投诉
     */
    @Override
    public List<Complaints> selectComplaintsList(Complaints complaints)
    {
        return complaintsMapper.selectComplaintsList(complaints);
    }

    /**
     * 新增用户投诉
     *
     * @param complaints 用户投诉
     * @return 结果
     */
    @Override
    public int insertComplaints(Complaints complaints)
    {
        return complaintsMapper.insertComplaints(complaints);
    }

    /**
     * 修改用户投诉
     *
     * @param complaints 用户投诉
     * @return 结果
     */
    @Override
    public int updateComplaints(Complaints complaints)
    {
        return complaintsMapper.updateComplaints(complaints);
    }

    /**
     * 批量删除用户投诉
     *
     * @param ids 需要删除的用户投诉主键
     * @return 结果
     */
    @Override
    public int deleteComplaintsByIds(Long[] ids)
    {
        return complaintsMapper.deleteComplaintsByIds(ids);
    }

    /**
     * 删除用户投诉信息
     *
     * @param id 用户投诉主键
     * @return 结果
     */
    @Override
    public int deleteComplaintsById(Long id)
    {
        return complaintsMapper.deleteComplaintsById(id);
    }
}

