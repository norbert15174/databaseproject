package com.example.postgressqldb.core.driver.service.cud;

import com.example.postgressqldb.model.Driver;

import java.util.Set;

public interface IDriverQueryService {
    Set <Driver> getAll();

    Set <Driver> getAllByNumber(Integer number);
}
