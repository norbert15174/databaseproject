package com.example.casandra.csv.maper;

import com.example.casandra.model.Driver;
import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverMapper {

    public static Set <Driver> getByCSV(List <String> lines) {
        Set <Driver> drivers = Sets.newHashSet();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            var readValue = line.split(",");
            drivers.add(build(readValue));
        }
        return drivers;
    }

    private static Driver build(String[] line) {
        var driver = new Driver();
        driver.setId(Long.valueOf(line[0]));
        driver.setDriverRef(line[1].replace("\"" , ""));
        driver.setForename(line[4].replace("\"" , ""));
        driver.setSurname(line[5].replace("\"" , ""));
        driver.setDob(line[6].replace("\"" , ""));
        driver.setNationality(line[7].replace("\"" , ""));
        driver.setUrl(line[8].replace("\"" , ""));
        return driver;
    }

}
