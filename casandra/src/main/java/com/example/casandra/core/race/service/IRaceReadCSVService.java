package com.example.casandra.core.race.service;

import com.example.casandra.model.Race;

import java.util.Set;

public interface IRaceReadCSVService {
    Set <Race> readCSVAndSave();
}
