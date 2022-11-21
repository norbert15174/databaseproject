package com.example.casandra.core.driver.service;

import com.example.casandra.model.Driver;

import java.util.Set;

public interface IDriverReadCSVService {
    Set <Driver> readCSVAndSave();
}
