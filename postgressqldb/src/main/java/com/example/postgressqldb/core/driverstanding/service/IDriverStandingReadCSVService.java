package com.example.postgressqldb.core.driverstanding.service;

import com.example.postgressqldb.model.Driver;
import com.example.postgressqldb.model.DriverStanding;
import com.example.postgressqldb.model.Race;

import java.util.Set;

public interface IDriverStandingReadCSVService {
    Set <DriverStanding> readCSVAndSave(Set <Driver> drivers , Set <Race> races);
}
