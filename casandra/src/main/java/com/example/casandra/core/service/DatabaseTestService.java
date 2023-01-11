package com.example.casandra.core.service;

import com.example.casandra.constants.FileNameConstants;
import com.example.casandra.core.abstracts.IDatabaseTestService;
import com.example.casandra.core.lapstime.service.cud.ILapTimeCudService;
import com.example.casandra.core.lapstime.service.cud.ILapTimeQueryService;
import com.example.casandra.csv.ICSVReader;
import com.example.casandra.csv.maper.LapTimeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@Service
class DatabaseTestService implements IDatabaseTestService {

    private final ICSVReader csvReader;
    private final ILapTimeCudService lapTimeCudService;
    private final ILapTimeQueryService lapTimeQueryService;
    private UUID UUID_1 = UUID.fromString("fbf6bffc-2916-446c-9a37-f99078f19b09");
    private UUID UUID_2 = UUID.fromString("cb41f22d-a92a-47ec-9fef-b6994147282b");

    DatabaseTestService(ICSVReader csvReader , ILapTimeCudService lapTimeCudService , ILapTimeQueryService lapTimeQueryService) {
        this.csvReader = csvReader;
        this.lapTimeCudService = lapTimeCudService;
        this.lapTimeQueryService = lapTimeQueryService;
    }

    @Override
    public void testPersist(Long number) {
        var lines = csvReader.readCSV(FileNameConstants.LAP_TIMES);
        var lapTimes = LapTimeMapper.getByCSV(lines).stream().limit(number).collect(Collectors.toSet());
        var startTime = System.currentTimeMillis();
        lapTimeCudService.saveAll(lapTimes);
        var endTime = System.currentTimeMillis();
        var lapTimeAsList = new ArrayList <>(lapTimes);
        UUID_1 = lapTimeAsList.get(0).getId();
        UUID_2 = lapTimeAsList.get(1).getId();

        var duration = (double) (endTime - startTime) / 1000.0;
        System.out.println("saveAll: " + duration);
    }

    @Override
    public UUID testRead() {
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
        var lapTime = lapTimeQueryService.getById(UUID_1);
        var endTime = System.currentTimeMillis();

        var duration = (endTime - startTime);
        System.out.println("readById: " + duration);
    }

    @Override
    public void testSingleUpdate() {
        var lapTime = lapTimeQueryService.getById(UUID_2);
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
