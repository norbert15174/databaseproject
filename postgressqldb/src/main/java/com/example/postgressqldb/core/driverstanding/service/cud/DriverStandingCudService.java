package com.example.postgressqldb.core.driverstanding.service.cud;

import com.example.postgressqldb.core.driverstanding.repository.IDriverStandingRepository;
import com.example.postgressqldb.model.DriverStanding;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
@Slf4j
@Service
@AllArgsConstructor
public class DriverStandingCudService implements IDriverStandingCudService {

    private final IDriverStandingRepository repository;

    @Override
    public DriverStanding save(DriverStanding entity) {
        var saved = repository.save(entity);
        log.info("DriverStanding with id {} created" , saved.getId());
        return saved;
    }

    @Override
    public void save(Set <DriverStanding> entites) {
        repository.saveAll(entites);
    }

}
