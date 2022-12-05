package com.example.mongodb.core.service;

import com.example.mongodb.core.abstracts.IEntitySaveService;
import com.example.mongodb.core.circuit.service.ICircuitReadCSVService;
import com.example.mongodb.core.driver.service.IDriverReadCSVService;
import com.example.mongodb.core.race.service.IRaceReadCSVService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EntitySaveService implements IEntitySaveService {

    private final ICircuitReadCSVService circuitReadCSVService;
    private final IRaceReadCSVService raceReadCSVService;
    private final IDriverReadCSVService driverReadCSVService;
//    private final ILapTimeReadCSVService lapTimeReadCSVService;
//    private final IDriverStandingReadCSVService driverStandingReadCSVService;


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        var races = raceReadCSVService.readCSVAndSave();
        var circuits = circuitReadCSVService.readCSVAndSave(races);
        var drivers = driverReadCSVService.readCSVAndSave();
//        var lapTimes = lapTimeReadCSVService.readCSVAndSave();
//        var driverStandings = driverStandingReadCSVService.readCSVAndSave();
    }

}
