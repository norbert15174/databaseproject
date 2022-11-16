package com.example.postgressqldb.core.lapstime.service;

import com.example.postgressqldb.model.Driver;
import com.example.postgressqldb.model.LapTime;
import com.example.postgressqldb.model.Race;

import java.util.Set;

public interface ILapTimeReadCSVService {

    Set <LapTime> readCSVAndSave(Set <Driver> drivers , Set <Race> races);
}
