package com.example.mongodb.core.driver.service;

import com.example.mongodb.model.Driver;

import java.util.Set;

public interface IDriverReadCSVService {
    Set <Driver> readCSVAndSave();
}
