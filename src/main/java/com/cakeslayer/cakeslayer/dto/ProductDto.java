package com.cakeslayer.cakeslayer.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data

public class ProductDto {
    @Id
    @Indexed(unique = true)
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
}
