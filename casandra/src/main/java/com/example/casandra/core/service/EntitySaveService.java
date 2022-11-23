package com.example.casandra.core.service;

import com.example.casandra.core.abstracts.IEntitySaveService;
import com.example.casandra.core.circuit.service.ICircuitReadCSVService;
import com.example.casandra.core.driver.service.IDriverReadCSVService;
import com.example.casandra.core.driverstanding.service.IDriverStandingReadCSVService;
import com.example.casandra.core.lapstime.service.ILapTimeReadCSVService;
import com.example.casandra.core.race.service.IRaceReadCSVService;
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
    private final ILapTimeReadCSVService lapTimeReadCSVService;
    private final IDriverStandingReadCSVService driverStandingReadCSVService;


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        var circuits = circuitReadCSVService.readCSVAndSave();
        var races = raceReadCSVService.readCSVAndSave();
        var drivers = driverReadCSVService.readCSVAndSave();
        var lapTimes = lapTimeReadCSVService.readCSVAndSave();
        var driverStandings = driverStandingReadCSVService.readCSVAndSave();
    }

}
