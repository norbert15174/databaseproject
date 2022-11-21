//package com.example.casandra.csv.maper;
//
//import com.example.postgressqldb.model.Driver;
//import com.example.postgressqldb.model.DriverStanding;
//import com.example.postgressqldb.model.Race;
//import com.google.common.collect.Sets;
//import lombok.AccessLevel;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//public class DriverStandingMapper {
//
//    public static Set <DriverStanding> getByCSV(List <String> lines , Map <Long, Driver> driversById , Map <Long, Race> racesById) {
//        Set <DriverStanding> driversStandings = Sets.newHashSet();
//        for (int i = 1; i < lines.size(); i++) {
//            String line = lines.get(i);
//            var readValue = line.split(",");
//            driversStandings.add(build(readValue , driversById , racesById));
//        }
//        return driversStandings;
//    }
//
//    private static DriverStanding build(String[] line , Map <Long, Driver> driversById , Map <Long, Race> racesById) {
//        var driverStanding = new DriverStanding();
//        driverStanding.setId(Long.valueOf(line[0]));
//
//        Race race = racesById.get(Long.valueOf(line[1]));
//        driverStanding.setRace(race);
//
//        Driver driver = driversById.get(Long.valueOf(line[2]));
//        driverStanding.setDriver(driver);
//
//        driverStanding.setPoints(Float.valueOf(line[3]));
//        driverStanding.setPosition(Long.valueOf(line[4]));
//        driverStanding.setWins(Long.valueOf(line[6]));
//        return driverStanding;
//    }
//
//
//}
