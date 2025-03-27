package com.ruoyi.consumer.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消费者信息对象 consumer
 *
 * @author EMANON
 * @date 2025-03-27
 */
public class Consumer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 头像 */
    @Excel(name = "头像")
    private String img;

    /** 用户名 */
    @Excel(name = "用户名")
    private String name;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updataDate;

    /** 用户状态 */
    @Excel(name = "用户状态")
    private Integer status;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phone;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setUpdataDate(Date updataDate)
    {
        this.updataDate = updataDate;
    }

    public Date getUpdataDate()
    {
        return updataDate;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("img", getImg())
                .append("name", getName())
                .append("createDate", getCreateDate())
                .append("updataDate", getUpdataDate())
                .append("status", getStatus())
                .append("phone", getPhone())
                .toString();
    }
}

