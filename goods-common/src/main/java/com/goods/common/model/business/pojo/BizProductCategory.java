package com.goods.common.model.business.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com.cyb.pojo.BizProductCategory")
@Table(name = "biz_product_category")
public class BizProductCategory implements Serializable {
    /**
     * 类别id
     */
    @Id
    @ApiModelProperty(value="id类别id")
    private Long id;

    /**
     * 类别名称
     */
    @ApiModelProperty(value="name类别名称")
    private String name;

    /**
     * 备注
     */
    @ApiModelProperty(value="remark备注")
    private String remark;

    /**
     * 排序
     */
    @ApiModelProperty(value="sort排序")
    private Integer sort;

    @Column(name = "create_time")
    @ApiModelProperty(value="createTime")
    private Date createTime;

    @Column(name = "modified_time")
    @ApiModelProperty(value="modifiedTime")
    private Date modifiedTime;

    /**
     * 父级分类id
     */
    @ApiModelProperty(value="pid父级分类id")
    private Long pid;

    private static final long serialVersionUID = 1L;

    public BizProductCategory(Long id, String name, String remark, Integer sort, Date createTime, Date modifiedTime, Long pid) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.sort = sort;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.pid = pid;
    }

    public BizProductCategory() {
        super();
    }

    /**
     * 获取类别id
     *
     * @return id - 类别id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置类别id
     *
     * @param id 类别id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取类别名称
     *
     * @return name - 类别名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类别名称
     *
     * @param name 类别名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * 获取父级分类id
     *
     * @return pid - 父级分类id
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父级分类id
     *
     * @param pid 父级分类id
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", remark=").append(remark);
        sb.append(", sort=").append(sort);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", pid=").append(pid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}