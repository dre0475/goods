package com.goods.business.converter;

import com.goods.common.model.business.pojo.BizProductCategory;
import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName GoodsCategoryConverter
 * Create by Rabbit
 * Date 2021 2021/9/24  16:41
 */

public class GoodsCategoryConverter {
    //创建方法
    public static List<ProductCategoryTreeNodeVO> converterToVOList (List<BizProductCategory> productCategories){
        //把创建返回视图类的集合
        List<ProductCategoryTreeNodeVO> productCategoryVOS = new ArrayList<>();
        //遍历传过来的结果集
        if (!CollectionUtils.isEmpty(productCategories)){
            for (BizProductCategory productCategory : productCategories) {
                //创建对象
                ProductCategoryTreeNodeVO productCategoryTreeNodeVO = new ProductCategoryTreeNodeVO();
                //把查回来的结果放进视图对象
                BeanUtils.copyProperties(productCategory,productCategoryTreeNodeVO);
                //设置层级号
                productCategoryTreeNodeVO.setPid(productCategory.getPid());
                //添加到集合中
                productCategoryVOS.add(productCategoryTreeNodeVO);
            }
        }
        //返回结果
        return productCategoryVOS;
    }
}
