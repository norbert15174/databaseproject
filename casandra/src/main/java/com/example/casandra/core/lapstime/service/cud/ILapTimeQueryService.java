package com.example.casandra.core.lapstime.service.cud;

import com.example.casandra.model.LapTime;

import java.util.Set;
import java.util.UUID;

public interface ILapTimeQueryService {
    Set <LapTime> getAll();

    LapTime getById(UUID id);

}
