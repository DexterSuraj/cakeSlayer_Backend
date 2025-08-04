package com.cakeslayer.cakeslayer.service.serviceImpl;

import com.cakeslayer.cakeslayer.dto.ProductDto;
import com.cakeslayer.cakeslayer.model.ProductEntity;
import com.cakeslayer.cakeslayer.repository.ProductRepository;
import com.cakeslayer.cakeslayer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public ProductEntity addProduct(ProductDto productDto) {

            ProductEntity productEntity=new ProductEntity();
            productEntity=productEntity.toEntity(productDto);
            return  productRepository.save(productEntity);

    }

    @Override
    public List<ProductEntity> getAllProduct() {

        return productRepository.findAll();
    }


}
