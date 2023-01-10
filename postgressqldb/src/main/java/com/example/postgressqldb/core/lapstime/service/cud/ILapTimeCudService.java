package com.example.postgressqldb.core.lapstime.service.cud;

import com.example.postgressqldb.model.LapTime;

import java.util.Set;

public interface ILapTimeCudService {

    LapTime save(LapTime entity);

    void saveAll(Set<LapTime> lapTimes);

    void deleteAll();

    void update(LapTime lapTime);
}
