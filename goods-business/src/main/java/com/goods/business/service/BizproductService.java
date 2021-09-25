package com.goods.business.service;

import com.goods.common.vo.business.ProductVO;
import com.goods.common.vo.system.PageVO;

/**
 * ClassName biz_productService
 * Create by Rabbit
 * Date 2021 2021/9/24  23:09
 */
public interface BizproductService {
    PageVO<ProductVO> findProductList(Integer pageNum, Integer pageSize, ProductVO productVO,String categorys);

    ProductVO edit(Long id);

    void add(ProductVO productVO);

    void update(Long id, ProductVO productVO);

    void remove(Long id);

    void back(Long id);

    void publish(Long id);

    void delete(Long id);
}
