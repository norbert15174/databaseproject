package com.example.mongodb.core.service;

import com.example.mongodb.constants.FileNameConstants;
import com.example.mongodb.core.abstracts.IDatabaseTestService;
import com.example.mongodb.core.lapstime.service.cud.ILapTimeCudService;
import com.example.mongodb.core.lapstime.service.cud.ILapTimeQueryService;
import com.example.mongodb.csv.ICSVReader;
import com.example.mongodb.csv.maper.LapTimeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;


@AllArgsConstructor
@Slf4j
@Service
class DatabaseTestService implements IDatabaseTestService {

    private final ICSVReader csvReader;
    private final ILapTimeCudService lapTimeCudService;
    private final ILapTimeQueryService lapTimeQueryService;
    private final UUID UUID_1 = UUID.fromString("52e03850-04be-48af-b0a6-053d28451fd4");
    private final UUID UUID_2 = UUID.fromString("5dfdf89d-98db-4998-b596-88f173d9e142");

    @Override
    public void testPersist(Long number) {
        var lines = csvReader.readCSV(FileNameConstants.LAP_TIMES);
        var lapTimes = LapTimeMapper.getByCSV(lines).stream().limit(number).collect(Collectors.toSet());
        var startTime = System.currentTimeMillis();
        lapTimeCudService.saveAll(lapTimes);
        var endTime = System.currentTimeMillis();

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
