package com.fzz.api.controller.all;

import com.fzz.bo.ProductForm;
import com.fzz.common.result.GraceJSONResult;
import com.fzz.pojo.Product;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
public interface ProductControllerApi {


    @GetMapping("/pageMyProduct")
    public GraceJSONResult getPage(@RequestParam Integer currentPage,
                                   @RequestParam Integer pageSize,
                                   @RequestParam Integer status,
                                   @RequestParam Long id);

    @GetMapping("/pageProduct")
    public GraceJSONResult pageProduct(@RequestParam Integer currentPage,
                                   @RequestParam Integer pageSize,
                                   @RequestParam String classification,
                                   @RequestParam String sort,
                                   @RequestParam Integer startPrice,
                                   @RequestParam Integer endPrice);


    @PostMapping("/add")
    public GraceJSONResult addProduct(@RequestBody ProductForm productForm);

    @GetMapping("/getDetail")
    public GraceJSONResult getDetail(@RequestParam Long id);

    @GetMapping("/getCollections")
    public GraceJSONResult getCollections(@RequestParam Long id);


    @PostMapping("/updateStatus")
    public GraceJSONResult updateStatus();



    @PostMapping("/del")
    public GraceJSONResult deleteProduct(@RequestParam String ids);



}
