package com.cakeslayer.cakeslayer.controller;

import com.cakeslayer.cakeslayer.dto.ProductDto;
import com.cakeslayer.cakeslayer.model.ProductEntity;
import com.cakeslayer.cakeslayer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping("add")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductDto productDto){


       return ResponseEntity.status(200).body(productService.addProduct(productDto));
    }

    @GetMapping("/prods")
    public ResponseEntity<List<ProductEntity>> getAllProducts(){

        return ResponseEntity.status(200).body(productService.getAllProduct());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ProductEntity> getById(@RequestParam String id){
//        return ResponseEntity.status(200).body(productService.getProductById(id));
//    }


}
