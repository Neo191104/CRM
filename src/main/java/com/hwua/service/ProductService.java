package com.hwua.service;

import com.hwua.pojo.Product;

import java.util.List;

public interface ProductService {
    public List<Product> queryProducts() throws Exception;
    public Integer saveProduct(Product product) throws Exception;
    //更新产品状态
    public Integer updateProductsStatus(String [] ids,Integer status) throws Exception;

}
