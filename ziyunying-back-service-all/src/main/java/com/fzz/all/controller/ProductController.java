package com.fzz.all.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzz.all.service.MyCollectionsService;
import com.fzz.all.service.ProductService;
import com.fzz.api.BaseController;
import com.fzz.api.controller.all.ProductControllerApi;
import com.fzz.bo.ProductForm;
import com.fzz.common.enums.ResponseStatusEnum;
import com.fzz.common.result.GraceJSONResult;
import com.fzz.pojo.Article;
import com.fzz.pojo.MyCollections;
import com.fzz.pojo.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController extends BaseController implements ProductControllerApi {

    @Autowired
    private ProductService productService;

    @Autowired
    private MyCollectionsService myCollectionsService;

    @Override
    public GraceJSONResult getPage(Integer currentPage,Integer pageSize,Integer status, Long id) {
        if(id==null){
            return GraceJSONResult.errorMsg("没有用户id");
        }
        if(currentPage==null){
            currentPage=COMMON_START_PAGE;
        }
        if(pageSize==null){
            pageSize=COMMON_PAGE_SIZE;
        }
        Page<Product> pageInfo=new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Product> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Product::getPublisherId,id);
        if(status==1||status==2){
            queryWrapper.eq(Product::getStatus,status);
        }
        productService.page(pageInfo,queryWrapper);
        return GraceJSONResult.ok(pageInfo);
    }

    @Override
    public GraceJSONResult pageProduct(Integer currentPage, Integer pageSize,
                                       String classification, String sort, Integer startPrice, Integer endPrice) {
        if(currentPage==null){
            currentPage=COMMON_START_PAGE;
        }
        if(pageSize==null){
            pageSize=COMMON_PAGE_SIZE;
        }
        Page<Product> pageInfo=new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Product> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(classification)&&!classification.equals("全部"),
                Product::getClassification,classification);
        queryWrapper.ge(startPrice!=null&&startPrice!=0,Product::getPrice,startPrice);
        queryWrapper.le(endPrice!=null&&endPrice!=0,Product::getPrice,endPrice);

        if(sort.equals("销量")){
            queryWrapper.orderByAsc(Product::getSalesVolume);
        }else if(sort.equals("评价")){
            queryWrapper.orderByAsc(Product::getCommentCount);
        }else if(sort.equals("价格")){
            queryWrapper.orderByAsc(Product::getPrice);
        }

        productService.page(pageInfo,queryWrapper);
        return GraceJSONResult.ok(pageInfo);

    }

    @Override
    public GraceJSONResult addProduct(ProductForm productForm) {
        boolean res = productService.saveProduct(productForm);
        if(!res){
            return GraceJSONResult.errorMsg("添加商品失败");
        }
        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult getDetail(Long id) {
        Product product = productService.getById(id);
        return GraceJSONResult.ok(product);
    }

    @Override
    public GraceJSONResult getCollections(Long id) {
        LambdaQueryWrapper<MyCollections> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(MyCollections::getUserId,id);
        List<MyCollections> list = myCollectionsService.list(queryWrapper);
        return GraceJSONResult.ok(list);
    }

    @Override
    public GraceJSONResult updateStatus() {
        return null;
    }

    @Override
    public GraceJSONResult deleteProduct(String ids) {
        return null;
    }
}
