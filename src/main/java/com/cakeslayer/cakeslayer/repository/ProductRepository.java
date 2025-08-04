package com.cakeslayer.cakeslayer.repository;

import com.cakeslayer.cakeslayer.model.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity,String> {


}
