package com.cakeslayer.cakeslayer.model;

import com.cakeslayer.cakeslayer.dto.ProductDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collation = "product")
@Data
public class ProductEntity {
        @Id
        private String productId;
        private String title;
        private Long price;
        private String flavor;
        private String weight;
        private String shopName;
        private String shopAddress;
        private String type;
        private String description;
        private int rating;


public ProductEntity toEntity(ProductDto productDto){
        ProductEntity productEntity=  new ProductEntity();
        productEntity.setTitle(productDto.getTitle());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setFlavor(productDto.getFlavor());
        productEntity.setWeight(productDto.getWeight());
        productEntity.setShopName(productDto.getShopName());
        productEntity.setShopAddress(productDto.getShopAddress());
        productEntity.setType(productDto.getType());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setRating(productDto.getRating());
    return productEntity;
}}