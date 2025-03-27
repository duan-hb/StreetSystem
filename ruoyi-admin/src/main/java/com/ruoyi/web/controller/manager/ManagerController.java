package com.ruoyi.web.controller.manager;

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
import com.ruoyi.manager.domain.Manager;
import com.ruoyi.manager.service.IManagerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 管理员信息管理Controller
 *
 * @author D.D.D
 * @date 2025-03-26
 */
@RestController
@RequestMapping("/manager/manager")
public class ManagerController extends BaseController
{

    @Autowired
    private IManagerService managerService;

    /**
     * 查询管理员信息管理列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Manager manager)
    {
        startPage();
        List<Manager> list = managerService.selectManagerList(manager);
        return getDataTable(list);
    }

    /**
     * 导出管理员信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('manager:manager:export')")
    @Log(title = "管理员信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Manager manager)
    {
        List<Manager> list = managerService.selectManagerList(manager);
        ExcelUtil<Manager> util = new ExcelUtil<Manager>(Manager.class);
        util.exportExcel(response, list, "管理员信息管理数据");
    }

    /**
     * 获取管理员信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manager:manager:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(managerService.selectManagerById(id));
    }

    /**
     * 新增管理员信息管理
     */
    @PreAuthorize("@ss.hasPermi('manager:manager:add')")
    @Log(title = "管理员信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Manager manager)
    {
        return toAjax(managerService.insertManager(manager));
    }

    /**
     * 修改管理员信息管理
     */
    @PreAuthorize("@ss.hasPermi('manager:manager:edit')")
    @Log(title = "管理员信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Manager manager)
    {
        return toAjax(managerService.updateManager(manager));
    }

    /**
     * 删除管理员信息管理
     */
    @PreAuthorize("@ss.hasPermi('manager:manager:remove')")
    @Log(title = "管理员信息管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(managerService.deleteManagerByIds(ids));
    }
}

