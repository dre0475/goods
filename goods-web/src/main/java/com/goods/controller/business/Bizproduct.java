package com.goods.controller.business;

import com.goods.business.service.BizproductService;
import com.goods.common.response.ResponseBean;
import com.goods.common.vo.business.ProductVO;
import com.goods.common.vo.system.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName biz_product
 * Create by Rabbit
 * Date 2021 2021/9/24  23:07
 */
@RestController
@RequestMapping("/business/product")
public class Bizproduct {
    @Autowired
    private BizproductService bizproductService;
    //http://www.localhost:8989/business/product/findProductList?pageNum=1&pageSize=6&name=&categoryId=&supplier=&status=0

    @GetMapping("/findProductList")
    public ResponseBean findProductList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        ProductVO productVO,
                                        String categorys){

        PageVO<ProductVO> productList = bizproductService.findProductList(pageNum, pageSize, productVO,categorys);
        return ResponseBean.success(productList);

    }


    //编辑的查询 http://www.localhost:8989/business/product/edit/37
    @GetMapping("/edit/{id}")
    public ResponseBean edit(@PathVariable Long id){
        ProductVO productVO = bizproductService.edit(id);
        return ResponseBean.success(productVO);
    }


    //添加 http://www.localhost:8989/business/product/add
    @PostMapping("/add")
    public ResponseBean add(@RequestBody @Validated ProductVO productVO){
        bizproductService.add(productVO);
        return ResponseBean.success();
    }

    //更新信息 http://www.localhost:8989/business/product/update/
    @PutMapping("/update/{id}")
    public ResponseBean update(@PathVariable Long id,
                            @RequestBody @Validated ProductVO productVO){
        bizproductService.update(id, productVO);
        return ResponseBean.success();
    }


    //移入回收站 business/product/remove/   0正常 1 回收 2待审核
    @PutMapping("/remove/{id}")
    public ResponseBean remove(@PathVariable Long id){
        bizproductService.remove(id);
        return ResponseBean.success();
    }

    //移入回收站 business/product/remove/   0正常 1 回收 2待审核
    @PutMapping("/back/{id}")
    public ResponseBean back(@PathVariable Long id){
        bizproductService.back(id);
        return ResponseBean.success();
    }

    //移入回收站 business/product/remove/   0正常 1 回收 2待审核
    @PutMapping("/publish/{id}")
    public ResponseBean publish(@PathVariable Long id){
        bizproductService.publish(id);
        return ResponseBean.success();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseBean delete(@PathVariable Long id){
        bizproductService.delete(id);
        return ResponseBean.success();
    }
}
