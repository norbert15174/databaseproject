package com.example.postgressqldb.core.service;

import com.example.postgressqldb.core.abstracts.IEntitySaveService;
import com.example.postgressqldb.core.circuit.service.ICircuitReadCSVService;
import com.example.postgressqldb.core.driver.service.IDriverReadCSVService;
import com.example.postgressqldb.core.lapstime.service.ILapTimeReadCSVService;
import com.example.postgressqldb.core.race.service.IRaceReadCSVService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class EntitySaveService implements IEntitySaveService {

    private final ICircuitReadCSVService circuitReadCSVService;
    private final IRaceReadCSVService raceReadCSVService;
    private final IDriverReadCSVService driverReadCSVService;
    private final ILapTimeReadCSVService lapTimeReadCSVService;


    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        var circuits = circuitReadCSVService.readCSVAndSave();
        var races = raceReadCSVService.readCSVAndSave(circuits);
        var drivers = driverReadCSVService.readCSVAndSave();
        var lapTimes = lapTimeReadCSVService.readCSVAndSave(drivers , races);
    }

}
