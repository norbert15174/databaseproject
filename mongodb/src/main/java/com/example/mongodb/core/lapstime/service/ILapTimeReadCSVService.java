package com.example.mongodb.core.lapstime.service;

import com.example.mongodb.model.LapTime;

import java.util.Set;

public interface ILapTimeReadCSVService {

    Set <LapTime> readCSVAndSave();
}
