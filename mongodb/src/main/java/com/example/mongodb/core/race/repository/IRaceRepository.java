package com.example.mongodb.core.race.repository;

import com.example.mongodb.model.Race;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRaceRepository extends MongoRepository <Race, Long> {
}
