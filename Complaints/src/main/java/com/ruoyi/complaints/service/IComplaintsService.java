package com.ruoyi.complaints.service;

import java.util.List;
import com.ruoyi.complaints.domain.Complaints;

/**
 * 用户投诉Service接口
 *
 * @author EMANON
 * @date 2025-03-27
 */
public interface IComplaintsService
{
    /**
     * 查询用户投诉
     *
     * @param id 用户投诉主键
     * @return 用户投诉
     */
    public Complaints selectComplaintsById(Long id);

    /**
     * 查询用户投诉列表
     *
     * @param complaints 用户投诉
     * @return 用户投诉集合
     */
    public List<Complaints> selectComplaintsList(Complaints complaints);

    /**
     * 新增用户投诉
     *
     * @param complaints 用户投诉
     * @return 结果
     */
    public int insertComplaints(Complaints complaints);

    /**
     * 修改用户投诉
     *
     * @param complaints 用户投诉
     * @return 结果
     */
    public int updateComplaints(Complaints complaints);

    /**
     * 批量删除用户投诉
     *
     * @param ids 需要删除的用户投诉主键集合
     * @return 结果
     */
    public int deleteComplaintsByIds(Long[] ids);

    /**
     * 删除用户投诉信息
     *
     * @param id 用户投诉主键
     * @return 结果
     */
    public int deleteComplaintsById(Long id);
}
