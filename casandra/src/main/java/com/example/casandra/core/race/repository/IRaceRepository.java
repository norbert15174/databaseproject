package com.example.casandra.core.race.repository;

import com.example.casandra.model.Race;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface IRaceRepository extends CassandraRepository <Race, Long> {
}
