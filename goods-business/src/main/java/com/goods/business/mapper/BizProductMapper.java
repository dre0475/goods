package com.goods.business.mapper;


import com.goods.common.model.product.pojo.BizProduct;
import com.goods.common.model.product.pojo.BizProductExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface BizProductMapper extends Mapper<BizProduct> {
    long countByExample(BizProductExample example);

    int deleteByExample(BizProductExample example);

    List<BizProduct> selectByExampleWithBLOBs(BizProductExample example);

    List<BizProduct> selectByExample(BizProductExample example);

    int updateByExampleSelective(@Param("record") BizProduct record, @Param("example") BizProductExample example);

    int updateByExampleWithBLOBs(@Param("record") BizProduct record, @Param("example") BizProductExample example);

    int updateByExample(@Param("record") BizProduct record, @Param("example") BizProductExample example);
}