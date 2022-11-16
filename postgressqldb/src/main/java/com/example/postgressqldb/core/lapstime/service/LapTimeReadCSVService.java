package com.example.postgressqldb.core.lapstime.service;

import com.example.postgressqldb.core.lapstime.repository.ILapRepository;
import com.example.postgressqldb.core.lapstime.service.cud.ILapTimeCudService;
import com.example.postgressqldb.csv.ICSVReader;
import com.example.postgressqldb.csv.maper.LapTimeMapper;
import com.example.postgressqldb.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.postgressqldb.constant.FileNameConstants.LAP_TIMES;

@AllArgsConstructor
@Service
class LapTimeReadCSVService implements ILapTimeReadCSVService {

    private final ICSVReader csvReader;
    private final ILapRepository lapRepository;
    private final ILapTimeCudService cudService;

    @Override
    public Set <LapTime> readCSVAndSave(Set <Driver> drivers , Set <Race> races) {
        var lines = csvReader.readCSV(LAP_TIMES);
        var lapsById = initLaps().stream().collect(Collectors.toMap(Lap::getId , lap -> lap));
        var driversById = drivers.stream().collect(Collectors.toMap(Driver::getId , driver -> driver));
        var racesById = races.stream().collect(Collectors.toMap(Race::getId , race -> race));
        var lapTimes = LapTimeMapper.getByCSV(lines , driversById , racesById , lapsById);
        lapTimes.forEach(cudService::save);
        return lapTimes;
    }

    private Set <Lap> initLaps() {
        Set <Lap> laps = new HashSet <>();
        for (long i = 1L; i < 100L; i++) {
            laps.add(lapRepository.save(new Lap(i)));
        }
        return laps;
    }

}
