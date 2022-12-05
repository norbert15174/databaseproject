package com.example.mongodb.core.driver.service;

import com.example.mongodb.core.driver.service.cud.IDriverCudService;
import com.example.mongodb.csv.ICSVReader;
import com.example.mongodb.csv.maper.DriverMapper;
import com.example.mongodb.model.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.mongodb.constants.FileNameConstants.DRIVERS;

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
