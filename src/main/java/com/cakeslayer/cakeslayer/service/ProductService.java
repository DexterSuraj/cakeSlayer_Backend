package com.cakeslayer.cakeslayer.service;

import com.cakeslayer.cakeslayer.dto.ProductDto;
import com.cakeslayer.cakeslayer.model.ProductEntity;

import java.util.List;

public interface ProductService {
    abstract public ProductEntity addProduct(ProductDto productDto) ;
    abstract public List<ProductEntity> getAllProduct();

}
