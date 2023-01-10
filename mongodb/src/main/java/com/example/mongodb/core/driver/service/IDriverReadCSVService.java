package com.example.mongodb.core.driver.service;

import com.example.mongodb.model.Driver;
import com.example.mongodb.model.DriverStanding;
import com.example.mongodb.model.LapTime;

import java.util.Set;

public interface IDriverReadCSVService {
    Set <Driver> readCSVAndSave(Set <DriverStanding> driverStandings , Set <LapTime> lapTimes);
}
