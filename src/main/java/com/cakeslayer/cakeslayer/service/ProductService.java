package com.cakeslayer.cakeslayer.service;

import com.cakeslayer.cakeslayer.dto.ProductDto;
import com.cakeslayer.cakeslayer.dto.RegisterUserDto;
import com.cakeslayer.cakeslayer.model.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
abstract public class ProductService {
    abstract public ProductEntity addProduct(ProductDto productDto) ;
    abstract public List<ProductEntity> getAllProduct();
    abstract public Object getProductById(String id);
}
