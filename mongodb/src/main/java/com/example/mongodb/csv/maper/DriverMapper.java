package com.example.mongodb.csv.maper;

import com.example.mongodb.model.Driver;
import com.example.mongodb.model.DriverStanding;
import com.example.mongodb.model.LapTime;
import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverMapper {

    public static Set <Driver> getByCSV(List <String> lines , Map <Long, Set <DriverStanding>> driverStandingsByDriverId , Map <Long, Set <LapTime>> lapTimesByDriverId) {
        Set <Driver> drivers = Sets.newHashSet();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            var readValue = line.split(",");
            drivers.add(build(readValue , driverStandingsByDriverId , lapTimesByDriverId));
        }
        return drivers;
    }

    private static Driver build(String[] line , Map <Long, Set <DriverStanding>> driverStandingsByDriverId , Map <Long, Set <LapTime>> lapTimesByDriverId) {
        var driver = new Driver();
        driver.setId(Long.valueOf(line[0]));
        driver.setDriverRef(line[1].replace("\"" , ""));
        driver.setForename(line[4].replace("\"" , ""));
        driver.setSurname(line[5].replace("\"" , ""));
        driver.setDob(line[6].replace("\"" , ""));
        driver.setNationality(line[7].replace("\"" , ""));
        driver.setUrl(line[8].replace("\"" , ""));
        driver.setDriverStandings(driverStandingsByDriverId.get(driver.getId()));
        driver.setLapTimes(lapTimesByDriverId.get(driver.getId()));
        return driver;
    }

}
