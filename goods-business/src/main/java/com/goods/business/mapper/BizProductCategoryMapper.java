package com.goods.business.mapper;

import com.goods.common.model.business.pojo.BizProductCategory;
import com.goods.common.model.business.pojo.BizProductCategoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BizProductCategoryMapper extends Mapper<BizProductCategory> {

    long countByExample(BizProductCategoryExample example);

    int deleteByExample(BizProductCategoryExample example);

    List<BizProductCategory> selectByExample(BizProductCategoryExample example);

    int updateByExampleSelective(@Param("record") BizProductCategory record, @Param("example") BizProductCategoryExample example);

    int updateByExample(@Param("record") BizProductCategory record, @Param("example") BizProductCategoryExample example);
}