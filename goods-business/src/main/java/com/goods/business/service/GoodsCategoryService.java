package com.goods.business.service;

import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import com.goods.common.vo.system.PageVO;

import java.util.List;

public interface GoodsCategoryService {
    //物资类别  查询父分类
    List<ProductCategoryTreeNodeVO> CategoryTreeFather();

    //分类树结构
    PageVO<ProductCategoryTreeNodeVO> CategoryTreeTree(Integer pageNum, Integer pageSize);

    void add(ProductCategoryTreeNodeVO productCategoryTreeNodeVO);

    ProductCategoryTreeNodeVO getGoodsCategoryById(Long id);

    void update(Long id,ProductCategoryTreeNodeVO productCategoryTreeNodeVO);

    void delete(Long id);
}
