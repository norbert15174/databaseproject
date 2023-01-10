package com.example.mongodb.core.lapstime.repository;

import com.example.mongodb.model.LapTime;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILapTimeRepository extends MongoRepository <LapTime, Long> {
}
