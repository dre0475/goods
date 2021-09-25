package com.goods.controller.business;

import com.goods.business.service.GoodsCategoryService;
import com.goods.common.annotation.ControllerEndpoint;
import com.goods.common.error.SystemException;
import com.goods.common.response.ResponseBean;
import com.goods.common.vo.business.ProductCategoryTreeNodeVO;
import com.goods.common.vo.system.PageVO;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName GoodsCategory
 * Create by Rabbit
 * Date 2021 2021/9/24  11:05
 */

@RestController
@RequestMapping("business/productCategory")
public class GoodsCategory {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    //物资类别  一进来就分页查询所有的三级分类信息 钩子函数
    @GetMapping("/categoryTree")
    public ResponseBean categoryTree(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize){

        PageVO<ProductCategoryTreeNodeVO> productCategoryTreeNodeVOPageVO = goodsCategoryService.CategoryTreeTree(pageNum, pageSize);
        return ResponseBean.success(productCategoryTreeNodeVOPageVO);
    }


    //添加中的父分类
    @GetMapping("/getParentCategoryTree")
    public ResponseBean getParentCategoryTree(){
        List<ProductCategoryTreeNodeVO> productCategoryTreeNodeVOS = goodsCategoryService.CategoryTreeFather();
        return ResponseBean.success(productCategoryTreeNodeVOS);
    }


    //完整的数据添加   http://www.localhost:8989/business/productCategory/add
    //Request Method: POST
    /**
     *
     * @return
     */
    @ControllerEndpoint(exceptionMessage = "添加物资分类失败", operation = "添加物资分类")
    //@RequiresPermissions({"department:add"})
    @ApiOperation(value = "物资类别的完整的数据添加")
    @PostMapping("/add")
    public ResponseBean add(@RequestBody @Validated ProductCategoryTreeNodeVO productCategoryTreeNodeVO) {
        goodsCategoryService.add(productCategoryTreeNodeVO);
        return ResponseBean.success();
    }



    @ApiOperation(value = "根据id查询物资分类信息")
    //@RequiresPermissions({"department:edit"})
    @GetMapping("/edit/{id}")
    public ResponseBean getGoodsCategoryById(@PathVariable Long id) throws SystemException {
        ProductCategoryTreeNodeVO productCategoryTreeNodeVO = goodsCategoryService.getGoodsCategoryById(id);
        return ResponseBean.success(productCategoryTreeNodeVO);
    }


    //编辑物资分类信息  http://www.localhost:8989/business/productCategory/update/33
    @ApiOperation(value = "编辑物资分类信息")
    //@RequiresPermissions({"department:edit"})
    @PutMapping ("/update/{id}")
    public ResponseBean edit(@PathVariable Long id,
                             @RequestBody @Validated ProductCategoryTreeNodeVO PathVariable) throws SystemException {
        goodsCategoryService.update(id,PathVariable);
        return ResponseBean.success();
    }

    //删除物资分类信息 http://www.localhost:8989/business/productCategory/delete/37
    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @ControllerEndpoint(exceptionMessage = "删除物资分类信息失败", operation = "删除物资分类信息")
    //@ApiOperation(value = "删除部门")
    @RequiresPermissions({"department:delete"})
    @DeleteMapping("/delete/{id}")
    public ResponseBean delete(@PathVariable Long id) throws SystemException {
        goodsCategoryService.delete(id);
        return ResponseBean.success();
    }

}
