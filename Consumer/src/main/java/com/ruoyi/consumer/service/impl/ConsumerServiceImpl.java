package com.ruoyi.consumer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.consumer.mapper.ConsumerMapper;
import com.ruoyi.consumer.domain.Consumer;
import com.ruoyi.consumer.service.IConsumerService;

/**
 * 消费者信息Service业务层处理
 *
 * @author EMANON
 * @date 2025-03-27
 */
@Service
public class ConsumerServiceImpl implements IConsumerService
{
    @Autowired
    private ConsumerMapper consumerMapper;

    /**
     * 查询消费者信息
     *
     * @param id 消费者信息主键
     * @return 消费者信息
     */
    @Override
    public Consumer selectConsumerById(Long id)
    {
        return consumerMapper.selectConsumerById(id);
    }

    /**
     * 查询消费者信息列表
     *
     * @param consumer 消费者信息
     * @return 消费者信息
     */
    @Override
    public List<Consumer> selectConsumerList(Consumer consumer)
    {
        return consumerMapper.selectConsumerList(consumer);
    }

    /**
     * 新增消费者信息
     *
     * @param consumer 消费者信息
     * @return 结果
     */
    @Override
    public int insertConsumer(Consumer consumer)
    {
        return consumerMapper.insertConsumer(consumer);
    }

    /**
     * 修改消费者信息
     *
     * @param consumer 消费者信息
     * @return 结果
     */
    @Override
    public int updateConsumer(Consumer consumer)
    {
        return consumerMapper.updateConsumer(consumer);
    }

    /**
     * 批量删除消费者信息
     *
     * @param ids 需要删除的消费者信息主键
     * @return 结果
     */
    @Override
    public int deleteConsumerByIds(Long[] ids)
    {
        return consumerMapper.deleteConsumerByIds(ids);
    }

    /**
     * 删除消费者信息信息
     *
     * @param id 消费者信息主键
     * @return 结果
     */
    @Override
    public int deleteConsumerById(Long id)
    {
        return consumerMapper.deleteConsumerById(id);
    }
}

