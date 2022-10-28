package com.example.postgressqldb.core.driver.service.cud;

import com.example.postgressqldb.core.driver.repository.IDriverRepository;
import com.example.postgressqldb.model.Driver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Transactional
@AllArgsConstructor
@Service
public class DriverCudService implements IDriverCudService {

    private final IDriverRepository repository;

    @Override
    public Driver save(Driver entity) {
        var saved = repository.save(entity);
        log.info("Driver with id {} created" , saved.getId());
        return saved;
    }

}
