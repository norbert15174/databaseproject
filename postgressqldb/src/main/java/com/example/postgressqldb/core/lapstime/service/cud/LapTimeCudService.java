package com.example.postgressqldb.core.lapstime.service.cud;

import com.example.postgressqldb.core.lapstime.repository.ILapTimeRepository;
import com.example.postgressqldb.model.LapTime;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
@Slf4j
@Service
@AllArgsConstructor
class LapTimeCudService implements ILapTimeCudService {

    private final ILapTimeRepository repository;

    @Override
    public LapTime save(LapTime entity) {
        return repository.save(entity);
    }

    @Override
    public void saveAll(Set <LapTime> lapTimes) {
        repository.saveAll(lapTimes);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void update(LapTime lapTime) {
        repository.save(lapTime);
    }

}
