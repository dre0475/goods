package com.goods.business.service.imp;

import com.goods.business.converter.GoodsCategoryConverter;
import com.goods.business.converter.Vo2Object;
import com.goods.business.mapper.BizProductCategoryMapper;
import com.goods.business.service.GoodsCategoryService;
import com.goods.common.model.business.pojo.BizProductCategory;
import com.goods.common.utils.CategoryTreeBuilder;
import com.goods.common.utils.ListPageUtils;
import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import com.goods.common.vo.system.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    private BizProductCategoryMapper bizProductCategoryMapper;
    //查树结构
    @Override
    public PageVO<ProductCategoryTreeNodeVO> CategoryTreeTree(Integer pageNum, Integer pageSize) {
        //转化成视图对象集合
        List<ProductCategoryTreeNodeVO> productCategoryVOS = GoodsCategoryConverter.converterToVOList(bizProductCategoryMapper.selectAll());
        //构建成所需的集合
        List<ProductCategoryTreeNodeVO> build = CategoryTreeBuilder.build(productCategoryVOS);
        List<ProductCategoryTreeNodeVO> page = ListPageUtils.page(build, pageSize, pageNum);
        return new PageVO<>(page.size(),build);
    }


    //查询父分类
    @Override
    public List<ProductCategoryTreeNodeVO> CategoryTreeFather() {
        //查询全部并转化成视图对象集合
        List<ProductCategoryTreeNodeVO> productCategoryTreeNodeVOS = GoodsCategoryConverter.converterToVOList(bizProductCategoryMapper.selectAll());
        //视图对象集合构建成父分类集合
        List<ProductCategoryTreeNodeVO> buildParent = CategoryTreeBuilder.buildParent(productCategoryTreeNodeVOS);
        return buildParent;
    }


    //完整的物资分类添加
    @Override
    public void add(ProductCategoryTreeNodeVO productCategoryTreeNodeVO) {
        BizProductCategory bizProductCategory = Vo2Object.Vo2Object(productCategoryTreeNodeVO);
        bizProductCategoryMapper.insert(bizProductCategory);
    }
}
