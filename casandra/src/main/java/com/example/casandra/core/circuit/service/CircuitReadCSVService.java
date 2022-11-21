package com.example.casandra.core.circuit.service;

import com.example.casandra.core.circuit.service.cud.ICircuitCUDService;
import com.example.casandra.csv.ICSVReader;
import com.example.casandra.csv.maper.CircuitMapper;
import com.example.casandra.model.Circuit;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.casandra.constants.FileNameConstants.CIRCUITS;

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
