package com.example.casandra.core.lapstime.service.cud;

import com.example.casandra.core.lapstime.repository.ILapTimeRepository;
import com.example.casandra.model.LapTime;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
class LapTimeCudService implements ILapTimeCudService {

    private final ILapTimeRepository repository;

    @Override
    public LapTime save(LapTime entity) {
        var saved = repository.save(entity);
        log.info("LapTime with id {} created" , saved.getId());
        return saved;
    }

}
