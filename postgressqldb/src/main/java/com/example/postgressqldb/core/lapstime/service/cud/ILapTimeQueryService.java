package com.example.postgressqldb.core.lapstime.service.cud;

import com.example.postgressqldb.model.LapTime;
import com.example.postgressqldb.model.LapTimeId;

import java.util.Set;

public interface ILapTimeQueryService {
    Set <LapTime> getAll();

    LapTime getById(LapTimeId id);

}
