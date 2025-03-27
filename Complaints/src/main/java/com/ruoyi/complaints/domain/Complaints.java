package com.ruoyi.complaints.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户投诉对象 complaints
 *
 * @author EMANON
 * @date 2025-03-27
 */
public class Complaints extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 投诉ID */
    private Long id;

    /** 被店铺id */
    private Long storeId;

    /** 商铺名称 */
    @Excel(name = "商铺名称")
    private String shopName;

    /** 投诉用户id */
    private Long complaintId;

    /** 投诉人员 */
    @Excel(name = "投诉人员")
    private String complaintName;

    /** 投诉人电话(可选) */
    @Excel(name = "投诉人电话(可选)")
    private String complainantPhone;

    /** 投诉类型 */
    @Excel(name = "投诉类型")
    private String complaintType;

    /** 投诉时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "投诉时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    /** 投诉事由 */
    @Excel(name = "投诉事由")
    private String description;

    /** 投诉状态 */
    @Excel(name = "投诉状态")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setStoreId(Long storeId)
    {
        this.storeId = storeId;
    }

    public Long getStoreId()
    {
        return storeId;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setComplaintId(Long complaintId)
    {
        this.complaintId = complaintId;
    }

    public Long getComplaintId()
    {
        return complaintId;
    }

    public void setComplaintName(String complaintName)
    {
        this.complaintName = complaintName;
    }

    public String getComplaintName()
    {
        return complaintName;
    }

    public void setComplainantPhone(String complainantPhone)
    {
        this.complainantPhone = complainantPhone;
    }

    public String getComplainantPhone()
    {
        return complainantPhone;
    }

    public void setComplaintType(String complaintType)
    {
        this.complaintType = complaintType;
    }

    public String getComplaintType()
    {
        return complaintType;
    }

    public void setCreatTime(Date creatTime)
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime()
    {
        return creatTime;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
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
                .append("storeId", getStoreId())
                .append("shopName", getShopName())
                .append("complaintId", getComplaintId())
                .append("complaintName", getComplaintName())
                .append("complainantPhone", getComplainantPhone())
                .append("complaintType", getComplaintType())
                .append("creatTime", getCreatTime())
                .append("description", getDescription())
                .append("status", getStatus())
                .toString();
    }
}
