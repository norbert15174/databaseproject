package com.example.mongodb.core.driver.service;

import com.example.mongodb.core.driver.service.cud.IDriverCudService;
import com.example.mongodb.csv.ICSVReader;
import com.example.mongodb.csv.maper.DriverMapper;
import com.example.mongodb.model.Driver;
import com.example.mongodb.model.DriverStanding;
import com.example.mongodb.model.LapTime;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

import static com.example.mongodb.constants.FileNameConstants.DRIVERS;

@AllArgsConstructor
@Service
class DriverReadCSVService implements IDriverReadCSVService {

    private final ICSVReader csvReader;
    private final IDriverCudService cudService;

    @Override
    public Set <Driver> readCSVAndSave(Set <DriverStanding> driverStandings , Set <LapTime> lapTimes) {
        var lines = csvReader.readCSV(DRIVERS);
        var driverStandingsByDriverId = getDriverStandingsByDriverId(driverStandings);
        var lapTimesByDriverId = getLapTimesByDriverId(lapTimes);
        var circuits = DriverMapper.getByCSV(lines , driverStandingsByDriverId , lapTimesByDriverId);
        circuits.forEach(cudService::save);
        return circuits;
    }

    private Map <Long, Set <DriverStanding>> getDriverStandingsByDriverId(Set <DriverStanding> driverStandings) {
        Map <Long, Set <DriverStanding>> driverStandingsByDriverId = Maps.newHashMap();
        for (var driverStanding : driverStandings) {
            if ( driverStandingsByDriverId.containsKey(driverStanding.getDriverId()) ) {
                driverStandingsByDriverId.get(driverStanding.getDriverId()).add(driverStanding);
                continue;
            }
            driverStandingsByDriverId.put(driverStanding.getDriverId() , Sets.newHashSet(driverStanding));
        }
        return driverStandingsByDriverId;
    }

    private Map <Long, Set <LapTime>> getLapTimesByDriverId(Set <LapTime> lapTimes) {
        Map <Long, Set <LapTime>> lapTimesByDriverId = Maps.newHashMap();
        for (var lapTime : lapTimes) {
            if ( lapTimesByDriverId.containsKey(lapTime.getDriverId()) ) {
                lapTimesByDriverId.get(lapTime.getDriverId()).add(lapTime);
                continue;
            }
            lapTimesByDriverId.put(lapTime.getDriverId() , Sets.newHashSet(lapTime));
        }
        return lapTimesByDriverId;
    }

}
