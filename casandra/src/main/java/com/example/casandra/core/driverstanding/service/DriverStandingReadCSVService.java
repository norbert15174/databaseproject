package com.example.casandra.core.driverstanding.service;

import com.example.casandra.core.driverstanding.service.cud.IDriverStandingCudService;
import com.example.casandra.csv.ICSVReader;
import com.example.casandra.csv.maper.DriverStandingMapper;
import com.example.casandra.model.DriverStanding;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.casandra.constants.FileNameConstants.DRIVER_STANDING;

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
