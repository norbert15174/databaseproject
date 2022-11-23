package com.example.casandra.core.driverstanding.service;

import com.example.casandra.model.DriverStanding;

import java.util.Set;

public interface IDriverStandingReadCSVService {
    Set <DriverStanding> readCSVAndSave();
}
