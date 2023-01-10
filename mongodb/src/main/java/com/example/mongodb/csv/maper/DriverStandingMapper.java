package com.example.mongodb.csv.maper;

import com.example.mongodb.model.DriverStanding;
import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverStandingMapper {

    public static Set <DriverStanding> getByCSV(List <String> lines) {
        Set <DriverStanding> driversStandings = Sets.newHashSet();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            var readValue = line.split(",");
            driversStandings.add(build(readValue));
        }
        return driversStandings;
    }

    private static DriverStanding build(String[] line) {
        var driverStanding = new DriverStanding();
        driverStanding.setId(Long.valueOf(line[0]));
        driverStanding.setRaceId(Long.valueOf(line[1]));
        driverStanding.setDriverId(Long.valueOf(line[2]));
        driverStanding.setPoints(Float.valueOf(line[3]));
        driverStanding.setPosition(Long.valueOf(line[4]));
        driverStanding.setWins(Long.valueOf(line[6]));
        return driverStanding;
    }


}
