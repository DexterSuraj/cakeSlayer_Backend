package com.cakeslayer.cakeslayer.dto;

import lombok.Data;

@Data

public class ProductDto {
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
