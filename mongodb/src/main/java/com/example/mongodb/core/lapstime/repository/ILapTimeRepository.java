package com.example.mongodb.core.lapstime.repository;

import com.example.mongodb.model.LapTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ILapTimeRepository extends MongoRepository <LapTime, UUID> {
}
