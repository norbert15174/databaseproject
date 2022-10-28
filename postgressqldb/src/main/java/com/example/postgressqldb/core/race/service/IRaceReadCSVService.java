package com.example.postgressqldb.core.race.service;

import com.example.postgressqldb.model.Circuit;
import com.example.postgressqldb.model.Race;

import java.util.Set;

public interface IRaceReadCSVService {
    Set <Race> readCSVAndSave(Set <Circuit> circuits);
}
