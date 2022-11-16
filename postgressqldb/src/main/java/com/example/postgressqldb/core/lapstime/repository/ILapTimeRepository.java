package com.example.postgressqldb.core.lapstime.repository;

import com.example.postgressqldb.model.LapTime;
import com.example.postgressqldb.model.LapTimeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILapTimeRepository extends JpaRepository <LapTime, LapTimeId> {
}
