package com.ruoyi.store.domain;

import com.ruoyi.merchants.domain.Merchants;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Objects;

/**
 * 店铺管理对象 store
 *
 * @author EMANON
 * @date 2025-03-27
 */

@Data
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

    //商户信息，可不存在
    private Merchants merchants;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("address", getAddress())
                .append("type", getType())
                .append("status", getStatus())
                .append("merchants",getMerchants())
                .toString();
    }
}

