package com.goods.common.model.supplier.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com.goods.common.model.supplier.pojo.BizSupplier")
@Table(name = "biz_supplier")
public class BizSupplier implements Serializable {
    @Id
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 供应商名称
     */
    @ApiModelProperty(value="name供应商名称")
    private String name;

    /**
     * 供应商地址
     */
    @ApiModelProperty(value="address供应商地址")
    private String address;

    /**
     * 供应商邮箱
     */
    @ApiModelProperty(value="email供应商邮箱")
    private String email;

    /**
     * 供应商电话
     */
    @ApiModelProperty(value="phone供应商电话")
    private String phone;

    @Column(name = "create_time")
    @ApiModelProperty(value="createTime")
    private Date createTime;

    @Column(name = "modified_time")
    @ApiModelProperty(value="modifiedTime")
    private Date modifiedTime;

    /**
     * 排序
     */
    @ApiModelProperty(value="sort排序")
    private Integer sort;

    /**
     * 联系人
     */
    @ApiModelProperty(value="contact联系人")
    private String contact;

    private static final long serialVersionUID = 1L;

    public BizSupplier(Long id, String name, String address, String email, String phone, Date createTime, Date modifiedTime, Integer sort, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.sort = sort;
        this.contact = contact;
    }

    public BizSupplier() {
        super();
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取供应商名称
     *
     * @return name - 供应商名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置供应商名称
     *
     * @param name 供应商名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取供应商地址
     *
     * @return address - 供应商地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置供应商地址
     *
     * @param address 供应商地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取供应商邮箱
     *
     * @return email - 供应商邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置供应商邮箱
     *
     * @param email 供应商邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取供应商电话
     *
     * @return phone - 供应商电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置供应商电话
     *
     * @param phone 供应商电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return modified_time
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取联系人
     *
     * @return contact - 联系人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系人
     *
     * @param contact 联系人
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", sort=").append(sort);
        sb.append(", contact=").append(contact);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}