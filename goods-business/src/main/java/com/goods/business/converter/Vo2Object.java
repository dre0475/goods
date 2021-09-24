package com.goods.business.converter;

import com.goods.common.model.business.pojo.BizProductCategory;
import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import org.springframework.beans.BeanUtils;

/**
 * ClassName Vo2Object
 * Create by Rabbit
 * Date 2021 2021/9/24  18:00
 */
public class Vo2Object {
   public static BizProductCategory Vo2Object(ProductCategoryTreeNodeVO productCategoryTreeNodeVO){
      BizProductCategory bizProductCategory = new BizProductCategory();
      BeanUtils.copyProperties(productCategoryTreeNodeVO,bizProductCategory);
      return bizProductCategory;
   }
}
