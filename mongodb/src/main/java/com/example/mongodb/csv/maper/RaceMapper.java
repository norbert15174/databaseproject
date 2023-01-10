package com.example.mongodb.csv.maper;

import com.example.mongodb.model.DriverStanding;
import com.example.mongodb.model.LapTime;
import com.example.mongodb.model.Race;
import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RaceMapper {

    public static Set <Race> getByCSV(List <String> lines , Map <Long, Set <DriverStanding>> driverStandingsByRaceId , Map <Long, Set <LapTime>> lapTimesByRaceId) {
        Set <Race> races = Sets.newHashSet();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            var readValue = line.split(",");
            races.add(build(readValue , driverStandingsByRaceId , lapTimesByRaceId));
        }
        return races;
    }

    private static Race build(String[] value , Map <Long, Set <DriverStanding>> driverStandingsByRaceId , Map <Long, Set <LapTime>> lapTimesByRaceId) {
        var race = new Race();
        race.setId(Long.valueOf(value[0]));
        race.setYear(Long.valueOf(value[1]));
        race.setRound(Long.valueOf(value[2]));
        race.setCircuitId(Long.valueOf(value[3]));
        race.setName(value[4].replace("\"" , ""));
        race.setDate(value[5].replace("\"" , ""));
        race.setUrl(value[7].replace("\"" , ""));
        race.setDriverStandings(driverStandingsByRaceId.get(race.getId()));
        race.setLapTimes(lapTimesByRaceId.get(race.getId()));
        return race;
    }

}
