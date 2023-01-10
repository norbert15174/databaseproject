package com.example.postgressqldb.core.driverstanding.service.cud;

import com.example.postgressqldb.model.DriverStanding;

import java.util.Set;

public interface IDriverStandingCudService {
    DriverStanding save(DriverStanding driverStanding);

    void save(Set <DriverStanding> entites);
}
