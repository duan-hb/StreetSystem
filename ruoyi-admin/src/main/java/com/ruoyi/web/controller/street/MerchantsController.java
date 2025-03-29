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
import com.ruoyi.merchants.domain.Merchants;
import com.ruoyi.merchants.service.IMerchantsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 店铺信息管理Controller
 *
 * @author EMANON
 * @date 2025-03-27
 */
@RestController
@RequestMapping("/merchants/merchants")
public class MerchantsController extends BaseController
{
    @Autowired
    private IMerchantsService merchantsService;

    /**
     * 查询店铺信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('merchants:merchants:list')")
    @GetMapping("/list")
    public TableDataInfo list(Merchants merchants)
    {
        startPage();
        List<Merchants> list = merchantsService.selectMerchantsList(merchants);
        return getDataTable(list);
    }

    /**
     * 导出店铺信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('merchants:merchants:export')")
    @Log(title = "店铺信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Merchants merchants)
    {
        List<Merchants> list = merchantsService.selectMerchantsList(merchants);
        ExcelUtil<Merchants> util = new ExcelUtil<Merchants>(Merchants.class);
        util.exportExcel(response, list, "店铺信息管理数据");
    }

    /**
     * 获取店铺信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('merchants:merchants:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(merchantsService.selectMerchantsById(id));
    }

    /**
     * 新增店铺信息管理
     */
    @PreAuthorize("@ss.hasPermi('merchants:merchants:add')")
    @Log(title = "店铺信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Merchants merchants)
    {
        return toAjax(merchantsService.insertMerchants(merchants));
    }

    /**
     * 修改店铺信息管理
     */
    @PreAuthorize("@ss.hasPermi('merchants:merchants:edit')")
    @Log(title = "店铺信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Merchants merchants)
    {
        return toAjax(merchantsService.updateMerchants(merchants));
    }

    /**
     * 删除店铺信息管理
     */
    @PreAuthorize("@ss.hasPermi('merchants:merchants:remove')")
    @Log(title = "店铺信息管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        //修改中间表mid为0，查询时mid为0数据显示空
        return toAjax(merchantsService.deleteMerchantsByIds(ids));
    }
}

