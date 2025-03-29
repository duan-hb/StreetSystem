package com.ruoyi.web.controller.street;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.merchants.domain.Merchants;
import com.ruoyi.storetype.domain.StoreType;
import com.ruoyi.storetype.service.StoreTypeService;
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
import com.ruoyi.store.domain.Store;
import com.ruoyi.store.service.IStoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;

 /*
 * @author EMANON
 * @date 2025-03-27
 */
@RestController
@RequestMapping("/store/store")
public class StoreController extends BaseController
{
    @Autowired
    private IStoreService storeService;
    @Autowired
    private StoreTypeService storeTypeService;


    /**
     * 查询店铺管理列表
     */
    @PreAuthorize("@ss.hasPermi('store:store:list')")
    @GetMapping("/list")
    public TableDataInfo list(Store store)
    {
        //分页查询商店信息
        startPage();
        List<Store> list = storeService.selectStoreList(store);
        return getDataTable(list);
    }

    @GetMapping("/type")
    public AjaxResult getStoreType(){
        List<StoreType> typeList = storeTypeService.list();
        return success(typeList);
    }

    /**
     * 导出店铺管理列表
     */
    @PreAuthorize("@ss.hasPermi('store:store:export')")
    @Log(title = "店铺管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Store store)
    {
        List<Store> list = storeService.selectStoreList(store);
        ExcelUtil<Store> util = new ExcelUtil<Store>(Store.class);
        util.exportExcel(response, list, "店铺管理数据");
    }

    /**
     * 获取店铺管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('store:store:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(storeService.selectStoreById(id));
    }

    /**
     * 新增店铺管理
     */
    @PreAuthorize("@ss.hasPermi('store:store:add')")
    @Log(title = "店铺管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Store store)
    {
        return toAjax(storeService.insertStore(store));
    }

    /**
     * 修改店铺管理
     */
    @PreAuthorize("@ss.hasPermi('store:store:edit')")
    @Log(title = "店铺管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Store store)
    {
        return toAjax(storeService.updateStore(store));
    }

    /**
     * 删除店铺管理
     */
    @PreAuthorize("@ss.hasPermi('store:store:remove')")
    @Log(title = "店铺管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {

        return toAjax(storeService.deleteStoreByIds(ids));
    }
}
