package com.example.mongodb.core.circuit.service;

import com.example.mongodb.model.Circuit;
import com.example.mongodb.model.Race;

import java.util.Set;

public interface ICircuitReadCSVService {

    Set <Circuit> readCSVAndSave(Set <Race> races);
}
