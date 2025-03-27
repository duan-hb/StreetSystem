package com.ruoyi.store.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 店铺管理对象 store
 *
 * @author EMANON
 * @date 2025-03-27
 */
public class Store extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商店id */
    private Long id;

    /** 商店名称 */
    @Excel(name = "商店名称")
    private String name;

    /** 商店地址 */
    @Excel(name = "商店地址")
    private String address;

    /** 店铺类型 */
    @Excel(name = "店铺类型")
    private String type;

    /** 店铺状态 */
    @Excel(name = "店铺状态")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("address", getAddress())
                .append("type", getType())
                .append("status", getStatus())
                .toString();
    }
}

