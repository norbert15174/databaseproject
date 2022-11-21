package com.example.casandra.core.driver.service;

import com.example.casandra.core.driver.service.cud.IDriverCudService;
import com.example.casandra.csv.ICSVReader;
import com.example.casandra.csv.maper.DriverMapper;
import com.example.casandra.model.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.casandra.constants.FileNameConstants.DRIVERS;

@AllArgsConstructor
@Service
class DriverReadCSVService implements IDriverReadCSVService {

    private final ICSVReader csvReader;
    private final IDriverCudService cudService;

    @Override
    public Set <Driver> readCSVAndSave() {
        var lines = csvReader.readCSV(DRIVERS);
        var circuits = DriverMapper.getByCSV(lines);
        circuits.forEach(cudService::save);
        return circuits;
    }

}
