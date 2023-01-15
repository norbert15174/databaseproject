package com.example.mongodb.core.lapstime.service.cud;

import com.example.mongodb.model.LapTime;

import java.util.Set;

public interface ILapTimeCudService {

    LapTime save(LapTime entity);

    void saveAll(Set<LapTime> lapTimes);

    void update(LapTime lapTime);

    void deleteAll();
}
