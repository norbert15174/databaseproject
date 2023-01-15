package com.example.mongodb.core.lapstime.service.cud;

import com.example.mongodb.model.LapTime;

import java.util.Set;
import java.util.UUID;

public interface ILapTimeQueryService {
    Set <LapTime> getAll();

    LapTime getById(UUID id);

}
