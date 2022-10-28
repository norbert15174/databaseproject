package com.example.postgressqldb.core.circuit.service;

import com.example.postgressqldb.core.circuit.service.cud.ICircuitCUDService;
import com.example.postgressqldb.csv.ICSVReader;
import com.example.postgressqldb.csv.maper.CircuitMapper;
import com.example.postgressqldb.model.Circuit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.postgressqldb.constant.FileNameConstants.CIRCUITS;

@AllArgsConstructor
@Service
public class CircuitReadCSVService implements ICircuitReadCSVService {

    private final ICSVReader csvReader;
    private final ICircuitCUDService cudService;

    @Override
    public Set <Circuit> readCSVAndSave() {
        var lines = csvReader.readCSV(CIRCUITS);
        var circuits = CircuitMapper.getByCSV(lines);
        circuits.forEach(cudService::save);
        return circuits;
    }

}
