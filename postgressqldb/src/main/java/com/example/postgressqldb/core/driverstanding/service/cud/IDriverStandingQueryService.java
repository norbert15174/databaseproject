package com.example.postgressqldb.core.driverstanding.service.cud;

import com.example.postgressqldb.model.DriverStanding;

import java.util.Set;

public interface IDriverStandingQueryService {
    Set <DriverStanding> getAll();

    DriverStanding getById(Long id);

    Set <DriverStanding> getAllByNumber(Integer number);
}
