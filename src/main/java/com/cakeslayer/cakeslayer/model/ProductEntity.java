package com.cakeslayer.cakeslayer.model;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collation = "product")
@Data
public class ProductEntity {
    @Id
    private Long productId;
    private String title;
    private Long price;
    private String flavor;
    private String weight;
    private String shopName;
    private String shopAddress;
    private String type;
    private String description;
    private int rating;



}
