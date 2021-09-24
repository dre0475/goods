package com.goods.business.mapper;


import com.goods.common.model.supplier.pojo.BizSupplier;
import com.goods.common.model.supplier.pojo.BizSupplierExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface BizSupplierMapper extends Mapper<BizSupplier> {
    long countByExample(BizSupplierExample example);

    int deleteByExample(BizSupplierExample example);

    List<BizSupplier> selectByExample(BizSupplierExample example);

    int updateByExampleSelective(@Param("record") BizSupplier record, @Param("example") BizSupplierExample example);

    int updateByExample(@Param("record") BizSupplier record, @Param("example") BizSupplierExample example);
}