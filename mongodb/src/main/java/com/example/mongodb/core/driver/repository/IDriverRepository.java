package com.example.mongodb.core.driver.repository;

import com.example.mongodb.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDriverRepository extends MongoRepository <Driver, Long> {
}
