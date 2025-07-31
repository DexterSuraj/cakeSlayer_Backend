package com.cakeslayer.cakeslayer.service.serviceImpl;

import com.cakeslayer.cakeslayer.dto.ProductDto;
import com.cakeslayer.cakeslayer.model.ProductEntity;
import com.cakeslayer.cakeslayer.repository.ProductRepository;
import com.cakeslayer.cakeslayer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl extends ProductService {

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

    @Override
    public Object getProductById(String id) {
        Optional<ProductEntity> optionalProductEntity=productRepository.findById(id);
        if(optionalProductEntity.isEmpty()){
        return ResponseEntity.status(400).build();
        }
        else{
            return ResponseEntity.status(200).body(optionalProductEntity.get());
        }
    }
}
