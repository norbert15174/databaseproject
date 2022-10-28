package com.example.postgressqldb.core.circuit.repository;

import com.example.postgressqldb.model.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICircuitRepository extends JpaRepository <Circuit, Long> {
}
