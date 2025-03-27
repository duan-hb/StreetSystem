package com.ruoyi.web.controller.street;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.consumer.domain.Consumer;
import com.ruoyi.consumer.service.IConsumerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消费者信息Controller
 *
 * @author EMANON
 * @date 2025-03-27
 */
@RestController
@RequestMapping("/consumer/consumer")
public class ConsumerController extends BaseController
{
    @Autowired
    private IConsumerService consumerService;

    /**
     * 查询消费者信息列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:consumer:list')")
    @GetMapping("/list")
    public TableDataInfo list(Consumer consumer)
    {
        startPage();
        List<Consumer> list = consumerService.selectConsumerList(consumer);
        return getDataTable(list);
    }

    /**
     * 导出消费者信息列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:consumer:export')")
    @Log(title = "消费者信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Consumer consumer)
    {
        List<Consumer> list = consumerService.selectConsumerList(consumer);
        ExcelUtil<Consumer> util = new ExcelUtil<Consumer>(Consumer.class);
        util.exportExcel(response, list, "消费者信息数据");
    }

    /**
     * 获取消费者信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('consumer:consumer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(consumerService.selectConsumerById(id));
    }

    /**
     * 新增消费者信息
     */
    @PreAuthorize("@ss.hasPermi('consumer:consumer:add')")
    @Log(title = "消费者信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Consumer consumer)
    {
        return toAjax(consumerService.insertConsumer(consumer));
    }

    /**
     * 修改消费者信息
     */
    @PreAuthorize("@ss.hasPermi('consumer:consumer:edit')")
    @Log(title = "消费者信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Consumer consumer)
    {
        return toAjax(consumerService.updateConsumer(consumer));
    }

    /**
     * 删除消费者信息
     */
    @PreAuthorize("@ss.hasPermi('consumer:consumer:remove')")
    @Log(title = "消费者信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(consumerService.deleteConsumerByIds(ids));
    }
}
