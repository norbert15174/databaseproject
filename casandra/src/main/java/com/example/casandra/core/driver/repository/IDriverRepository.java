package com.example.casandra.core.driver.repository;

import com.example.casandra.model.Driver;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface IDriverRepository extends CassandraRepository <Driver, Long> {
}
