package com.example.postgressqldb.core.race.service.cud;

import com.example.postgressqldb.model.Race;

import java.util.Set;

public interface IRaceQueryService {
    Set <Race> getAll();

    Set <Race> getAllByNumber(Integer number);
}
