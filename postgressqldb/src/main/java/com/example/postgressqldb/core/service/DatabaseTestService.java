package com.example.postgressqldb.core.service;

import com.example.postgressqldb.core.abstracts.IDatabaseTestService;
import com.example.postgressqldb.core.driver.service.cud.IDriverQueryService;
import com.example.postgressqldb.core.lapstime.repository.ILapRepository;
import com.example.postgressqldb.core.lapstime.service.cud.ILapTimeCudService;
import com.example.postgressqldb.core.lapstime.service.cud.ILapTimeQueryService;
import com.example.postgressqldb.core.race.service.cud.IRaceQueryService;
import com.example.postgressqldb.csv.ICSVReader;
import com.example.postgressqldb.csv.maper.LapTimeMapper;
import com.example.postgressqldb.model.Driver;
import com.example.postgressqldb.model.Lap;
import com.example.postgressqldb.model.LapTimeId;
import com.example.postgressqldb.model.Race;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

import static com.example.postgressqldb.constant.FileNameConstants.LAP_TIMES;

@Slf4j
@Service
class DatabaseTestService implements IDatabaseTestService {

    private final ICSVReader csvReader;
    private final IDriverQueryService driverQueryService;
    private final IRaceQueryService raceQueryService;
    private final ILapTimeQueryService lapTimeQueryService;
    private final ILapTimeCudService lapTimeCudService;
    private final ILapRepository lapRepository;
    private LapTimeId ID_TO_CHECK = new LapTimeId(1033L , 840L , 98L);
    private LapTimeId ID_TO_CHECK2 = new LapTimeId(1033L , 840L , 99L);

    @Autowired
    DatabaseTestService(ICSVReader csvReader , IDriverQueryService driverQueryService , IRaceQueryService raceQueryService , ILapTimeQueryService lapTimeQueryService , ILapTimeCudService lapTimeCudService , ILapRepository lapRepository) {
        this.csvReader = csvReader;
        this.driverQueryService = driverQueryService;
        this.raceQueryService = raceQueryService;
        this.lapTimeQueryService = lapTimeQueryService;
        this.lapTimeCudService = lapTimeCudService;
        this.lapRepository = lapRepository;
    }

    @Override
    public void testPersist(Long number) {
        var drivers = driverQueryService.getAll();
        var races = raceQueryService.getAll();

        var lines = csvReader.readCSV(LAP_TIMES);
        var lapsById = lapRepository.findAll().stream().collect(Collectors.toMap(Lap::getId , lap -> lap));
        var driversById = drivers.stream().collect(Collectors.toMap(Driver::getId , driver -> driver));
        var racesById = races.stream().collect(Collectors.toMap(Race::getId , race -> race));
        var lapTimes = LapTimeMapper.getByCSV(lines , driversById , racesById , lapsById).stream().limit(number).collect(Collectors.toSet());

        var startTime = System.currentTimeMillis();
        lapTimeCudService.saveAll(lapTimes);
        var endTime = System.currentTimeMillis();
        var lapTimesToGet = new ArrayList <>(lapTimes);
        ID_TO_CHECK = lapTimesToGet.get(0).getId();
        ID_TO_CHECK2 = lapTimesToGet.get(1).getId();
        var duration = (double) (endTime - startTime) / 1000.0;
        System.out.println("saveAll: " + duration);
    }

    @Override
    public LapTimeId testRead() {
        var startTime = System.currentTimeMillis();
        var lapTimes = lapTimeQueryService.getAll();
        var endTime = System.currentTimeMillis();

        var lapTimesAsList = new ArrayList <>(lapTimes);
        Random rand = new Random();
        int n = rand.nextInt(lapTimesAsList.size());
        var id = lapTimesAsList.get(n).getId();
        var duration = (endTime - startTime);
        System.out.println("readAll: " + duration);
        return id;
    }

    @Override
    public void testReadById() {
        var startTime = System.currentTimeMillis();
        var lapTime = lapTimeQueryService.getById(ID_TO_CHECK);
        var endTime = System.currentTimeMillis();

        var duration = (endTime - startTime);
        System.out.println("readById: " + duration);
    }

    @Override
    public void testSingleUpdate() {
        var lapTime = lapTimeQueryService.getById(ID_TO_CHECK2);
        var startTime = System.currentTimeMillis();
        lapTime.setPosition(25L);
        lapTimeCudService.update(lapTime);
        var endTime = System.currentTimeMillis();
        var duration = (endTime - startTime);
        System.out.println("updateById: " + duration);
    }

    @Override
    public void testDelete() {
        var startTime = System.currentTimeMillis();
        lapTimeCudService.deleteAll();
        var endTime = System.currentTimeMillis();
        var duration = (endTime - startTime);
        System.out.println("deleteAll: " + duration);
    }

}
