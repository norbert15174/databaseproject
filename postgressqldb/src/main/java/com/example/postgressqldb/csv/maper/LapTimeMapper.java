package com.example.postgressqldb.csv.maper;

import com.example.postgressqldb.model.Driver;
import com.example.postgressqldb.model.Lap;
import com.example.postgressqldb.model.LapTime;
import com.example.postgressqldb.model.Race;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LapTimeMapper {

    public static Set <LapTime> getByCSV(List <String> lines , Map <Long, Driver> driversById , Map <Long, Race> racesById , Map <Long, Lap> lapsById) {
        Set <LapTime> lapTimes = Sets.newHashSet();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            var readValue = line.split(",");
            lapTimes.add(build(readValue , driversById , racesById , lapsById));
        }
        return lapTimes;
    }

    private static LapTime build(String[] readValue , Map <Long, Driver> driversById , Map <Long, Race> racesById , Map <Long, Lap> lapsById) {
        var lapTime = new LapTime();
        var race = racesById.get(Long.valueOf(readValue[0]));
        var driver = driversById.get(Long.valueOf(readValue[1]));
        var lap = lapsById.get(Long.valueOf(readValue[2]));
        lapTime.setLap(lap);
        lapTime.setDriver(driver);
        lapTime.setRace(race);
        lapTime.initId();
        lapTime.setPosition(Long.valueOf(readValue[3]));
        lapTime.setTime(readValue[4]);
        lapTime.setMilliseconds(Long.valueOf(readValue[5]));
        return lapTime;
    }

}
