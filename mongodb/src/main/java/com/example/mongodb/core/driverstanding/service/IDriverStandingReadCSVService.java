package com.example.mongodb.core.driverstanding.service;

import com.example.mongodb.model.DriverStanding;

import java.util.Set;

public interface IDriverStandingReadCSVService {
    Set <DriverStanding> readCSVAndSave();
}
