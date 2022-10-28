package com.example.postgressqldb.core.driver.service.cud;

import com.example.postgressqldb.model.Driver;

public interface IDriverCudService {
    Driver save(Driver entity);
}
