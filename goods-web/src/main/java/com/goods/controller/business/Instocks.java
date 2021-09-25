package com.goods.controller.business;

import com.goods.business.service.InstocksService;
import com.goods.common.response.ResponseBean;
import com.goods.common.vo.business.SupplierVO;
import com.goods.common.vo.system.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName Instocks
 * Create by Rabbit
 * Date 2021 2021/9/24  19:02
 */
@RestController
@RequestMapping("business/supplier")
public class Instocks {

    @Autowired
    private InstocksService instocksService;

    //打开页面展示的内容 http://www.localhost:8989/business/supplier/findSupplierList?pageNum=1&pageSize=10&name=
    //传过来分页和BizSupplier对象
    @GetMapping("/findSupplierList")
    public ResponseBean findSupplierList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                     @RequestParam(value = "pageSize") Integer pageSize,
                                                     SupplierVO supplierVO){
        PageVO<SupplierVO> supplierList = instocksService.findSupplierList(pageNum, pageSize, supplierVO);
        return ResponseBean.success(supplierList);
    }


    //添加物资来源  http://www.localhost:8989/business/supplier/add
    @PostMapping("/add")
    public ResponseBean add(@RequestBody @Validated SupplierVO supplierVO) {
        instocksService.add(supplierVO);
        return ResponseBean.success();
    }


    // 查询 http://www.localhost:8989/business/supplier/edit/23
    @GetMapping("/edit/{id}")
    public ResponseBean edit(@PathVariable Long id) {
        SupplierVO supplierVO = instocksService.edit(id);
        return ResponseBean.success(supplierVO);
    }

    //根据id修改http://www.localhost:8989/business/supplier/update/23
    @PutMapping("update/{id}")
    public ResponseBean update(@PathVariable Long id,
                               @RequestBody SupplierVO supplierVO){
        instocksService.updata(id,supplierVO);
        return ResponseBean.success();
    }

    //删除 http://www.localhost:8989/business/supplier/delete/23
    @DeleteMapping("delete/{id}")
    public ResponseBean delete(@PathVariable Long id){
        instocksService.delete(id);
        return ResponseBean.success();
    }


}
