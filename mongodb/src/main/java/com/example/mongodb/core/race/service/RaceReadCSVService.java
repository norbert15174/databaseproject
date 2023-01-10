package com.example.mongodb.core.race.service;

import com.example.mongodb.core.race.service.cud.IRaceCUDService;
import com.example.mongodb.csv.ICSVReader;
import com.example.mongodb.csv.maper.RaceMapper;
import com.example.mongodb.model.DriverStanding;
import com.example.mongodb.model.LapTime;
import com.example.mongodb.model.Race;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

import static com.example.mongodb.constants.FileNameConstants.RACES;

@AllArgsConstructor
@Service
class RaceReadCSVService implements IRaceReadCSVService {

    private final ICSVReader csvReader;
    private final IRaceCUDService cudService;

    @Override
    public Set <Race> readCSVAndSave(Set <DriverStanding> driverStandings , Set <LapTime> lapTimes) {
        var lines = csvReader.readCSV(RACES);
        var driverStandingsByRaceId = getDriverStandingsByRaceId(driverStandings);
        var lapTimesByRaceId = getLapTimesByRaceId(lapTimes);
        var races = RaceMapper.getByCSV(lines, driverStandingsByRaceId, lapTimesByRaceId);
        races.forEach(cudService::save);
        return races;
    }

    private Map <Long, Set <DriverStanding>> getDriverStandingsByRaceId(Set <DriverStanding> driverStandings) {
        Map <Long, Set <DriverStanding>> driverStandingsByRaceId = Maps.newHashMap();
        for (var driverStanding : driverStandings) {
            if ( driverStandingsByRaceId.containsKey(driverStanding.getRaceId()) ) {
                driverStandingsByRaceId.get(driverStanding.getRaceId()).add(driverStanding);
                continue;
            }
            driverStandingsByRaceId.put(driverStanding.getRaceId() , Sets.newHashSet(driverStanding));
        }
        return driverStandingsByRaceId;
    }

    private Map <Long, Set <LapTime>> getLapTimesByRaceId(Set <LapTime> lapTimes) {
        Map <Long, Set <LapTime>> lapTimesByRaceId = Maps.newHashMap();
        for (var lapTime : lapTimes) {
            if ( lapTimesByRaceId.containsKey(lapTime.getRaceId()) ) {
                lapTimesByRaceId.get(lapTime.getRaceId()).add(lapTime);
                continue;
            }
            lapTimesByRaceId.put(lapTime.getRaceId() , Sets.newHashSet(lapTime));
        }
        return lapTimesByRaceId;
    }

}
