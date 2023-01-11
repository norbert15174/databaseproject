package com.example.casandra.core.lapstime.repository;

import com.example.casandra.model.LapTime;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ILapTimeRepository extends CassandraRepository <LapTime, UUID> {
}
