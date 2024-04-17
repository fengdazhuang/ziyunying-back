package com.fzz.all.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzz.bo.ProductForm;
import com.fzz.pojo.AppUser;
import com.fzz.pojo.Product;

public interface ProductService extends IService<Product> {

    boolean saveProduct(ProductForm productForm);
}
