package com.cakeslayer.cakeslayer.repository;

import com.cakeslayer.cakeslayer.model.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity,String> {
}
