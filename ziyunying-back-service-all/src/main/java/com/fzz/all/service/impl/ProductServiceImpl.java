package com.fzz.all.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzz.all.mapper.OrderMapper;
import com.fzz.all.mapper.ProductMapper;
import com.fzz.all.service.ProductService;
import com.fzz.bo.ProductForm;
import com.fzz.pojo.Order;
import com.fzz.pojo.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public boolean saveProduct(ProductForm productForm) {
        Product product=new Product();
        BeanUtils.copyProperties(productForm,product);
        product.setImg("dasda");
        return this.save(product);
    }
}
