package com.goods.business.service;
import com.goods.common.vo.business.SupplierVO;
import com.goods.common.vo.system.PageVO;

/**
 * ClassName InstocksService
 * Create by Rabbit
 * Date 2021 2021/9/24  19:05
 */
public interface InstocksService {

    PageVO<SupplierVO> findSupplierList(Integer pageNum, Integer pageSize, SupplierVO supplierVO);

    void add(SupplierVO supplierVO);

    SupplierVO edit(Long id);

    void updata(Long id,SupplierVO supplierVO);

    void delete(Long id);
}
