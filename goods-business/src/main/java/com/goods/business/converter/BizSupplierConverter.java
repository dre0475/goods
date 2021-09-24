package com.goods.business.converter;

import com.goods.common.model.supplier.pojo.BizSupplier;
import com.goods.common.vo.business.SupplierVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName BizSupplierConverter
 * Create by Rabbit
 * Date 2021 2021/9/24  19:59
 */
public class BizSupplierConverter {
    //创建方法
    public static List<SupplierVO> converterToVOList (List<BizSupplier> bizSuppliers){
        //把创建返回视图类的集合
        List<SupplierVO> supplierVO = new ArrayList<>();
        //遍历传过来的结果集
        if (!CollectionUtils.isEmpty(bizSuppliers)){
            for (BizSupplier bizSupplier : bizSuppliers) {
                //创建对象
                SupplierVO supplierVO1 = new SupplierVO();
                //把查回来的结果放进视图对象
                BeanUtils.copyProperties(bizSupplier,supplierVO1);
                supplierVO.add(supplierVO1);
            }
        }
        //返回结果
        return supplierVO;
    }
}
