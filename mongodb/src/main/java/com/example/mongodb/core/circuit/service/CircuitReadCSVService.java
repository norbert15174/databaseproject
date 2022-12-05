package com.example.mongodb.core.circuit.service;

import com.example.mongodb.core.circuit.service.cud.ICircuitCUDService;
import com.example.mongodb.csv.ICSVReader;
import com.example.mongodb.csv.maper.CircuitMapper;
import com.example.mongodb.model.Circuit;
import com.example.mongodb.model.Race;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

import static com.example.mongodb.constants.FileNameConstants.CIRCUITS;

@AllArgsConstructor
@Service
public class CircuitReadCSVService implements ICircuitReadCSVService {

    private final ICSVReader csvReader;
    private final ICircuitCUDService cudService;

    @Override
    public Set <Circuit> readCSVAndSave(Set <Race> races) {
        var lines = csvReader.readCSV(CIRCUITS);
        Map <Long, Set <Race>> racesByCircuitId = getRacesByCircuitId(races);
        var circuits = CircuitMapper.getByCSV(lines , racesByCircuitId);
        circuits.forEach(cudService::save);
        return circuits;
    }

    private Map <Long, Set <Race>> getRacesByCircuitId(Set <Race> races) {
        Map <Long, Set <Race>> racesByCircuitId = Maps.newHashMap();
        for (Race race : races) {
            if ( racesByCircuitId.containsKey(race.getCircuitId()) ) {
                racesByCircuitId.get(race.getCircuitId()).add(race);
                continue;
            }
            racesByCircuitId.put(race.getCircuitId() , Sets.newHashSet(race));
        }
        return racesByCircuitId;
    }

}
