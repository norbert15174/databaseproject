package com.example.casandra.core.circuit.repository;

import com.example.casandra.model.Circuit;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ICircuitRepository extends CassandraRepository <Circuit, Long> {
}
