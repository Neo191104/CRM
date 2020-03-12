package com.hwua.service.impl;

import com.hwua.mapper.ProductMapper;
import com.hwua.pojo.Product;
import com.hwua.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper=null;
    @Override
    public List<Product> queryProducts() throws Exception {
        return productMapper.queryProducts();
    }

    @Override
    public Integer saveProduct(Product product) throws Exception {
        return productMapper.saveProduct(product);
    }


    @Override
    public Integer updateProductsStatus(String [] ids,Integer status) throws Exception {
        return productMapper.updateProductsStatus(ids,status);
    }



}
