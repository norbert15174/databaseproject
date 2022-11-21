package com.example.casandra.core.race.service;

import com.example.casandra.core.race.service.cud.IRaceCUDService;
import com.example.casandra.csv.ICSVReader;
import com.example.casandra.csv.maper.RaceMapper;
import com.example.casandra.model.Race;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.casandra.constants.FileNameConstants.RACES;

@AllArgsConstructor
@Service
class RaceReadCSVService implements IRaceReadCSVService {

    private final ICSVReader csvReader;
    private final IRaceCUDService cudService;

    @Override
    public Set <Race> readCSVAndSave() {
        var lines = csvReader.readCSV(RACES);
        var races = RaceMapper.getByCSV(lines);
        races.forEach(cudService::save);
        return races;
    }

}
