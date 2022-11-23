package com.example.casandra.core.driverstanding.repository;

import com.example.casandra.model.DriverStanding;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface IDriverStandingRepository extends CassandraRepository <DriverStanding, Long> {


}
