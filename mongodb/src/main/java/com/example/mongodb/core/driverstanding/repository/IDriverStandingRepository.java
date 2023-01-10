package com.example.mongodb.core.driverstanding.repository;

import com.example.mongodb.model.DriverStanding;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDriverStandingRepository extends MongoRepository <DriverStanding, Long> {


}
