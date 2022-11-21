package com.example.casandra.core.circuit.service;

import com.example.casandra.core.abstracts.IReadCSV;
import com.example.casandra.model.Circuit;

import java.util.Set;

public interface ICircuitReadCSVService extends IReadCSV <Circuit> {
    Set <Circuit> readCSVAndSave();
}
