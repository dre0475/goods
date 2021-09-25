package com.goods.business.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.business.mapper.BizProductMapper;
import com.goods.business.service.BizproductService;
import com.goods.common.model.product.pojo.BizProduct;
import com.goods.common.vo.business.ProductVO;
import com.goods.common.vo.system.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName BizproductServiceImpl
 * Create by Rabbit
 * Date 2021 2021/9/24  23:11
 */
@Service
public class BizproductServiceImpl implements BizproductService {
    @Autowired
    private BizProductMapper bizProductMapper;


    @Override
    public PageVO<ProductVO> findProductList(Integer pageNum, Integer pageSize, ProductVO productVO,String categorys) {


        //分页插件
        PageHelper.startPage(pageNum,pageSize);
        //创建条件对象
        Example example = new Example(BizProduct.class);
        //创建条件对象
        Example.Criteria criteria = example.createCriteria();
        if(categorys!=null){
            String[] split = categorys.split(",");
            if(split.length==1){
                long one_category = Long.parseLong(split[0]);
                criteria.andEqualTo("oneCategoryId",one_category);
            }
            if(split.length==2){
                long one_category = Long.parseLong(split[0]);
                long two_category = Long.parseLong(split[1]);
                criteria.andEqualTo("oneCategoryId",one_category);
                criteria.andEqualTo("twoCategoryId",two_category);
            }
            if(split.length==3){
                long one_category = Long.parseLong(split[0]);
                long two_category = Long.parseLong(split[1]);
                long three_category = Long.parseLong(split[2]);
                criteria.andEqualTo("oneCategoryId",one_category);
                criteria.andEqualTo("twoCategoryId",two_category);
                criteria.andEqualTo("threeCategoryId",three_category);
            }

        }
        if(productVO.getName()!=null && !"".equals(productVO.getName())){
            criteria.andLike("name","%"+productVO.getName());
        }
        if(productVO.getStatus()!=null) {
            criteria.andEqualTo("status", productVO.getStatus());
        }
        //根据条件查回来实体类的集合
        List<BizProduct> bizProductsList = bizProductMapper.selectByExample(example);

        //实体类的集合转换成vo集合才能返回
        ArrayList<ProductVO> productVOS = new ArrayList<>();

        //挨个放进去
        for (BizProduct bizProduct : bizProductsList) {
            ProductVO productVO1 = new ProductVO();
            BeanUtils.copyProperties(bizProduct,productVO1);
            productVOS.add(productVO1);
        }
        //创建分页的VO信息
        PageInfo<ProductVO> productVOPageInfo = new PageInfo<>();
        //返回一个分页的vo信息 一个集合
        return new PageVO<>(productVOPageInfo.getTotal(),productVOS);
    }

    //编辑查询回显
    @Override
    public ProductVO edit(Long id) {
        ProductVO productVO = new ProductVO();
        BizProduct bizProduct = bizProductMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(bizProduct,productVO);
        return productVO;
    }

    //添加信息
    @Override
    public void add(ProductVO productVO) {
        BizProduct bizProduct = new BizProduct();
        bizProduct.setCreateTime(new Date());
        bizProduct.setModifiedTime(new Date());
        bizProduct.setStatus(productVO.getStatus());
        bizProduct.setSort(productVO.getSort());
        bizProduct.setpNum(productVO.getImageUrl());
        BeanUtils.copyProperties(productVO,bizProduct);
        bizProductMapper.insert(bizProduct);
    }

    //更新
    @Override
    public void update(Long id, ProductVO productVO) {
        BizProduct bizProduct = new BizProduct();
        bizProduct.setName(productVO.getName());//名字
        bizProduct.setSort(productVO.getSort());//排序
        bizProduct.setImageUrl(productVO.getImageUrl());//图片
        bizProduct.setUnit(productVO.getUnit());//单位
        bizProduct.setModel(productVO.getModel());//规格
        if (productVO.getOneCategoryId()!=null){
            if(productVO.getTwoCategoryId()!=null){
                if(productVO.getTwoCategoryId()!=null){
                    bizProduct.setOneCategoryId(productVO.getOneCategoryId());
                    bizProduct.setTwoCategoryId(productVO.getTwoCategoryId());
                    bizProduct.setThreeCategoryId(productVO.getThreeCategoryId());
                }
                bizProduct.setOneCategoryId(productVO.getOneCategoryId());
                bizProduct.setTwoCategoryId(productVO.getTwoCategoryId());
            }
            bizProduct.setOneCategoryId(productVO.getOneCategoryId());
        }
        BeanUtils.copyProperties(productVO,bizProduct);
        bizProductMapper.updateByPrimaryKeySelective(bizProduct);
    }

    @Override
    public void remove(Long id) {
        BizProduct bizProduct = bizProductMapper.selectByPrimaryKey(id);
        bizProduct.setStatus(1);
        bizProductMapper.updateByPrimaryKey(bizProduct);
    }

    @Override
    public void back(Long id) {
        BizProduct bizProduct = bizProductMapper.selectByPrimaryKey(id);
        bizProduct.setStatus(0);
        bizProductMapper.updateByPrimaryKey(bizProduct);
    }

    @Override
    public void publish(Long id) {
        BizProduct bizProduct = bizProductMapper.selectByPrimaryKey(id);
        bizProduct.setStatus(3);
        bizProductMapper.updateByPrimaryKey(bizProduct);
    }

    @Override
    public void delete(Long id) {
        BizProduct bizProduct = bizProductMapper.selectByPrimaryKey(id);
        bizProductMapper.deleteByPrimaryKey(bizProduct);
    }
}
