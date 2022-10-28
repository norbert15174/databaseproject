package com.example.postgressqldb.core.driver.repository;

import com.example.postgressqldb.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDriverRepository extends JpaRepository <Driver, Long> {
}
