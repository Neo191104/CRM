package com.hwua.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Product;
import com.hwua.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService=null;

    @GetMapping("/findProductsBylimit")
    public PageInfo<Product> findProductsByLimit(Integer pageNum, Integer pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productService.queryProducts();
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        System.out.println(pageInfo);
        return pageInfo;
    }

    public Map<String, Object> addProduct(Product product) throws Exception{
        Map<String,Object> map = new HashMap<>();
        Integer res = productService.saveProduct(product);
        if(res>0){
            map.put("info","添加产品成功!");
        }else{
            map.put("info","添加产品失败!");
        }
        return map;
    }

    @PutMapping("/updateProductsByStatus")
    public  Map<String, Object> updateProductsByClose(String [] ids,Integer status) throws Exception{
        Integer res = productService.updateProductsStatus(ids,status);
        Map<String,Object> map = new HashMap<>();
        if(res>0){
            map.put("info","更新成功");
        }else{
            map.put("info","更新失败");
        }
        return map;
    }
}
