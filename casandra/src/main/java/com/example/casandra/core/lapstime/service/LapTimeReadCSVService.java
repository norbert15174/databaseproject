package com.example.casandra.core.lapstime.service;

import com.example.casandra.core.lapstime.service.cud.ILapTimeCudService;
import com.example.casandra.csv.ICSVReader;
import com.example.casandra.csv.maper.LapTimeMapper;
import com.example.casandra.model.LapTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.casandra.constants.FileNameConstants.LAP_TIMES;

@AllArgsConstructor
@Service
class LapTimeReadCSVService implements ILapTimeReadCSVService {

    private final ICSVReader csvReader;
    private final ILapTimeCudService cudService;

    @Override
    public Set <LapTime> readCSVAndSave() {
        var lines = csvReader.readCSV(LAP_TIMES);
        var lapTimes = LapTimeMapper.getByCSV(lines);
        lapTimes.forEach(cudService::save);
        return lapTimes;
    }

}
