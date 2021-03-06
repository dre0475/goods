package com.goods.business.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.business.converter.BizSupplierConverter;
import com.goods.business.mapper.BizSupplierMapper;
import com.goods.business.service.InstocksService;
import com.goods.common.model.supplier.pojo.BizSupplier;
import com.goods.common.vo.business.SupplierVO;
import com.goods.common.vo.system.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * ClassName InstocksServiceImpl
 * Create by Rabbit
 * Date 2021 2021/9/24  19:05
 */

@Service
public class InstocksServiceImpl implements InstocksService {
    @Autowired
    private BizSupplierMapper bizSupplierMapper;

    @Override
    public PageVO<SupplierVO> findSupplierList(Integer pageNum, Integer pageSize, SupplierVO supplierVO) {
        PageHelper.startPage(pageNum, pageSize);
        Example o = new Example(BizSupplier.class);
        Example.Criteria criteria = o.createCriteria();

        if (supplierVO.getAddress() != null && !"".equals(supplierVO.getAddress())) {
            criteria.andLike("name", "%" + supplierVO.getAddress() + "%");
        }

        if (supplierVO.getContact() != null && !"".equals(supplierVO.getContact())) {
            criteria.andLike("contact", "%" + supplierVO.getContact() + "%");
        }

        if (supplierVO.getName() != null && !"".equals(supplierVO.getName())) {
            criteria.andLike("address", "%" + supplierVO.getName() + "%");
        }
        //模糊
        List<BizSupplier> bizSuppliers = bizSupplierMapper.selectByExample(o);

        //转vo
        List<SupplierVO> supplierVOS = BizSupplierConverter.converterToVOList(bizSuppliers);
        PageInfo<BizSupplier> info = new PageInfo<>(bizSuppliers);
        return new PageVO<>(info.getTotal(), supplierVOS);
    }



    //添加物资来源
    @Override
    public void add(SupplierVO supplierVO) {
        BizSupplier bizSupplier = new BizSupplier();
        bizSupplier.setCreateTime(new Date());
        BeanUtils.copyProperties(supplierVO,bizSupplier);
        bizSupplierMapper.insert(bizSupplier);
    }


    //根据id查询
    @Override
    public SupplierVO edit(Long id) {
        SupplierVO supplierVO = new SupplierVO();
        BizSupplier bizSupplier = bizSupplierMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(bizSupplier,supplierVO);
        return supplierVO;
    }

    //更新物资来源
    @Override
    public void updata(Long id,SupplierVO supplierVO) {
        BizSupplier bizSupplier = new BizSupplier();
        bizSupplier.setEmail(supplierVO.getEmail());
        bizSupplier.setName(supplierVO.getName());
        bizSupplier.setPhone(supplierVO.getPhone());
        bizSupplier.setAddress(supplierVO.getAddress());
        bizSupplier.setSort(supplierVO.getSort());
        BeanUtils.copyProperties(supplierVO,bizSupplier);
        bizSupplierMapper.updateByPrimaryKeySelective(bizSupplier);
    }

    //删除物资来源
    @Override
    public void delete(Long id) {
        bizSupplierMapper.deleteByPrimaryKey(id);
    }

}
