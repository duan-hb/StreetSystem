package com.ruoyi.consumer.service;

import java.util.List;
import com.ruoyi.consumer.domain.Consumer;

/**
 * 消费者信息Service接口
 *
 * @author EMANON
 * @date 2025-03-27
 */
public interface IConsumerService
{
    /**
     * 查询消费者信息
     *
     * @param id 消费者信息主键
     * @return 消费者信息
     */
    public Consumer selectConsumerById(Long id);

    /**
     * 查询消费者信息列表
     *
     * @param consumer 消费者信息
     * @return 消费者信息集合
     */
    public List<Consumer> selectConsumerList(Consumer consumer);

    /**
     * 新增消费者信息
     *
     * @param consumer 消费者信息
     * @return 结果
     */
    public int insertConsumer(Consumer consumer);

    /**
     * 修改消费者信息
     *
     * @param consumer 消费者信息
     * @return 结果
     */
    public int updateConsumer(Consumer consumer);

    /**
     * 批量删除消费者信息
     *
     * @param ids 需要删除的消费者信息主键集合
     * @return 结果
     */
    public int deleteConsumerByIds(Long[] ids);

    /**
     * 删除消费者信息信息
     *
     * @param id 消费者信息主键
     * @return 结果
     */
    public int deleteConsumerById(Long id);
}

