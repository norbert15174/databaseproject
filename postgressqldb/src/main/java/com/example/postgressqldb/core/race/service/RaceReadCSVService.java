package com.example.postgressqldb.core.race.service;

import com.example.postgressqldb.core.race.service.cud.IRaceCUDService;
import com.example.postgressqldb.csv.ICSVReader;
import com.example.postgressqldb.csv.maper.RaceMapper;
import com.example.postgressqldb.model.Circuit;
import com.example.postgressqldb.model.Race;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.postgressqldb.constant.FileNameConstants.RACES;

@AllArgsConstructor
@Service
class RaceReadCSVService implements IRaceReadCSVService {

    private final ICSVReader csvReader;
    private final IRaceCUDService cudService;

    @Transactional
    @Override
    public Set <Race> readCSVAndSave(Set <Circuit> circuits) {
        var lines = csvReader.readCSV(RACES);
        var races = RaceMapper.getByCSV(lines , circuits.stream().collect(Collectors.toMap(Circuit::getId , circuit -> circuit)));
        races.forEach(cudService::save);
        return races;
    }

}
