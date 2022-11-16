package com.example.postgressqldb.core.lapstime.repository;

import com.example.postgressqldb.model.Lap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILapRepository extends JpaRepository <Lap, Long> {
}
