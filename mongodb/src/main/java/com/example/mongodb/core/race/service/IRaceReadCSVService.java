package com.example.mongodb.core.race.service;

import com.example.mongodb.model.Race;

import java.util.Set;

public interface IRaceReadCSVService {
    Set <Race> readCSVAndSave();
}
