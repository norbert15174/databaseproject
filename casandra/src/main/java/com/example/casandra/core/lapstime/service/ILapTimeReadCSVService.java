package com.example.casandra.core.lapstime.service;

import com.example.casandra.model.LapTime;

import java.util.Set;

public interface ILapTimeReadCSVService {

    Set <LapTime> readCSVAndSave();
}
