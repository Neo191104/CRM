package com.hwua.mapper;

import com.hwua.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Component
public interface ProductMapper {
    public List<Product> queryProducts() throws Exception;
    public Integer saveProduct(Product product) throws Exception;
    //更新产品状态
    public Integer updateProductsStatus(@Param("ids") String [] ids, @Param("status") Integer status) throws Exception;

}
