package com.example.mongodb.core.circuit.repository;

import com.example.mongodb.model.Circuit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICircuitRepository extends MongoRepository <Circuit, Long> {
}
