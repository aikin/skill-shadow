package com.thoughtworks.shadow.mybatis.mapper;


import com.thoughtworks.shadow.mybatis.model.Product;

public interface ProductMapper {

    Product selectProductById(int productId);
    int countProducts();
}
