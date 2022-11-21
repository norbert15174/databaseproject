package com.example.postgressqldb.core.driverstanding.service;

import com.example.postgressqldb.core.driverstanding.service.cud.IDriverStandingCudService;
import com.example.postgressqldb.csv.ICSVReader;
import com.example.postgressqldb.csv.maper.DriverStandingMapper;
import com.example.postgressqldb.model.Driver;
import com.example.postgressqldb.model.DriverStanding;
import com.example.postgressqldb.model.Race;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.postgressqldb.constant.FileNameConstants.DRIVER_STANDING;

@AllArgsConstructor
@Service
class DriverStandingReadCSVService implements IDriverStandingReadCSVService {

    private final ICSVReader csvReader;
    private final IDriverStandingCudService cudService;

    @Override
    public Set <DriverStanding> readCSVAndSave(Set <Driver> drivers , Set <Race> races) {
        var lines = csvReader.readCSV(DRIVER_STANDING);
        var driversById = drivers.stream().collect(Collectors.toMap(Driver::getId , driver -> driver));
        var racesById = races.stream().collect(Collectors.toMap(Race::getId , race -> race));
        var driverStandings = DriverStandingMapper.getByCSV(lines , driversById , racesById);
        driverStandings.forEach(cudService::save);
        return driverStandings;
    }

}
