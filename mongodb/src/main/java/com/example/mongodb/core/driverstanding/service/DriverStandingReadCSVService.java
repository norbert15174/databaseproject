package com.example.mongodb.core.driverstanding.service;

import com.example.mongodb.core.driverstanding.service.cud.IDriverStandingCudService;
import com.example.mongodb.csv.ICSVReader;
import com.example.mongodb.csv.maper.DriverStandingMapper;
import com.example.mongodb.model.DriverStanding;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.mongodb.constants.FileNameConstants.DRIVER_STANDING;

@AllArgsConstructor
@Service
class DriverStandingReadCSVService implements IDriverStandingReadCSVService {

    private final ICSVReader csvReader;
    private final IDriverStandingCudService cudService;

    @Override
    public Set <DriverStanding> readCSVAndSave() {
        var lines = csvReader.readCSV(DRIVER_STANDING);
        var driverStandings = DriverStandingMapper.getByCSV(lines);
        driverStandings.forEach(cudService::save);
        return driverStandings;
    }

}
