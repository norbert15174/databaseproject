package com.example.postgressqldb.core.driverstanding.repository;

import com.example.postgressqldb.model.DriverStanding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDriverStandingRepository extends JpaRepository <DriverStanding, Long> {



}
