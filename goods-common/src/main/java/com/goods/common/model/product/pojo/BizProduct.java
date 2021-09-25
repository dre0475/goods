package com.goods.common.model.product.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com.goods.common.model.product.pojo.BizProduct")
@Table(name = "biz_product")
public class BizProduct implements Serializable {

    @Id
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 商品编号
     */
    @Column(name = "p_num")
    @ApiModelProperty(value="pNum商品编号")
    private String pNum;

    /**
     * 商品名称
     */
    @ApiModelProperty(value="name商品名称")
    private String name;

    /**
     * 规格型号
     */
    @ApiModelProperty(value="model规格型号")
    private String model;

    /**
     * 计算单位
     */
    @ApiModelProperty(value="unit计算单位")
    private String unit;

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

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty(value="createTime创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modified_time")
    @ApiModelProperty(value="modifiedTime修改时间")
    private Date modifiedTime;

    /**
     * 1级分类
     */
    @Column(name = "one_category_id")
    @ApiModelProperty(value="oneCategoryId1级分类")
    private Long oneCategoryId;

    /**
     * 2级分类
     */
    @Column(name = "two_category_id")
    @ApiModelProperty(value="twoCategoryId2级分类")
    private Long twoCategoryId;

    /**
     * 3级分类
     */
    @Column(name = "three_category_id")
    @ApiModelProperty(value="threeCategoryId3级分类")
    private Long threeCategoryId;

    /**
     * 是否删除:1物资正常,0:物资回收,2:物资审核中
     */
    @ApiModelProperty(value="status是否删除:1物资正常,0:物资回收,2:物资审核中")
    private Integer status;

    /**
     * 图片
     */
    @Column(name = "image_url")
    @ApiModelProperty(value="imageUrl图片")
    private String imageUrl;

    private static final long serialVersionUID = 1L;

    public BizProduct(Long id, String pNum, String name, String model, String unit, String remark, Integer sort, Date createTime, Date modifiedTime, Long oneCategoryId, Long twoCategoryId, Long threeCategoryId, Integer status) {
        this.id = id;
        this.pNum = pNum;
        this.name = name;
        this.model = model;
        this.unit = unit;
        this.remark = remark;
        this.sort = sort;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.oneCategoryId = oneCategoryId;
        this.twoCategoryId = twoCategoryId;
        this.threeCategoryId = threeCategoryId;
        this.status = status;
    }

    public BizProduct(Long id, String pNum, String name, String model, String unit, String remark, Integer sort, Date createTime, Date modifiedTime, Long oneCategoryId, Long twoCategoryId, Long threeCategoryId, Integer status, String imageUrl) {
        this.id = id;
        this.pNum = pNum;
        this.name = name;
        this.model = model;
        this.unit = unit;
        this.remark = remark;
        this.sort = sort;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.oneCategoryId = oneCategoryId;
        this.twoCategoryId = twoCategoryId;
        this.threeCategoryId = threeCategoryId;
        this.status = status;
        this.imageUrl = imageUrl;
    }

    public BizProduct() {
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
     * 获取商品编号
     *
     * @return p_num - 商品编号
     */
    public String getpNum() {
        return pNum;
    }

    /**
     * 设置商品编号
     *
     * @param pNum 商品编号
     */
    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取规格型号
     *
     * @return model - 规格型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置规格型号
     *
     * @param model 规格型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取计算单位
     *
     * @return unit - 计算单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置计算单位
     *
     * @param unit 计算单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
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
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modified_time - 修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifiedTime 修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * 获取1级分类
     *
     * @return one_category_id - 1级分类
     */
    public Long getOneCategoryId() {
        return oneCategoryId;
    }

    /**
     * 设置1级分类
     *
     * @param oneCategoryId 1级分类
     */
    public void setOneCategoryId(Long oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    /**
     * 获取2级分类
     *
     * @return two_category_id - 2级分类
     */
    public Long getTwoCategoryId() {
        return twoCategoryId;
    }

    /**
     * 设置2级分类
     *
     * @param twoCategoryId 2级分类
     */
    public void setTwoCategoryId(Long twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }

    /**
     * 获取3级分类
     *
     * @return three_category_id - 3级分类
     */
    public Long getThreeCategoryId() {
        return threeCategoryId;
    }

    /**
     * 设置3级分类
     *
     * @param threeCategoryId 3级分类
     */
    public void setThreeCategoryId(Long threeCategoryId) {
        this.threeCategoryId = threeCategoryId;
    }

    /**
     * 获取是否删除:1物资正常,0:物资回收,2:物资审核中
     *
     * @return status - 是否删除:1物资正常,0:物资回收,2:物资审核中
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否删除:1物资正常,0:物资回收,2:物资审核中
     *
     * @param status 是否删除:1物资正常,0:物资回收,2:物资审核中
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取图片
     *
     * @return image_url - 图片
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置图片
     *
     * @param imageUrl 图片
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pNum=").append(pNum);
        sb.append(", name=").append(name);
        sb.append(", model=").append(model);
        sb.append(", unit=").append(unit);
        sb.append(", remark=").append(remark);
        sb.append(", sort=").append(sort);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", oneCategoryId=").append(oneCategoryId);
        sb.append(", twoCategoryId=").append(twoCategoryId);
        sb.append(", threeCategoryId=").append(threeCategoryId);
        sb.append(", status=").append(status);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}