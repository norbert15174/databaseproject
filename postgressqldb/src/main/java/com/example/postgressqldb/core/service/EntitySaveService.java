package com.example.postgressqldb.core.service;

import com.example.postgressqldb.core.abstracts.IEntitySaveService;
import com.example.postgressqldb.core.circuit.service.ICircuitReadCSVService;
import com.example.postgressqldb.core.driver.service.IDriverReadCSVService;
import com.example.postgressqldb.core.driverstanding.service.IDriverStandingReadCSVService;
import com.example.postgressqldb.core.lapstime.repository.ILapRepository;
import com.example.postgressqldb.core.lapstime.service.ILapTimeReadCSVService;
import com.example.postgressqldb.core.race.service.IRaceReadCSVService;
import com.example.postgressqldb.model.Lap;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class EntitySaveService implements IEntitySaveService {

    private final ICircuitReadCSVService circuitReadCSVService;
    private final IRaceReadCSVService raceReadCSVService;
    private final IDriverReadCSVService driverReadCSVService;
    private final ILapTimeReadCSVService lapTimeReadCSVService;
    private final IDriverStandingReadCSVService driverStandingReadCSVService;
    private final ILapRepository lapRepository;


    @Transactional
//    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        var circuits = circuitReadCSVService.readCSVAndSave();
        var races = raceReadCSVService.readCSVAndSave(circuits);
        var drivers = driverReadCSVService.readCSVAndSave();
        initLaps();
//        var driverStandings = driverStandingReadCSVService.readCSVAndSave(drivers , races);
//        var lapTimes = lapTimeReadCSVService.readCSVAndSave(drivers , races);
    }

    private Set <Lap> initLaps() {
        Set <Lap> laps = new HashSet <>();
        for (long i = 1L; i < 100L; i++) {
            laps.add(lapRepository.save(new Lap(i)));
        }
        return laps;
    }

}
