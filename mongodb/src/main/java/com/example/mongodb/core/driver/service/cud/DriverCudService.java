package com.example.mongodb.core.driver.service.cud;

import com.example.mongodb.core.driver.repository.IDriverRepository;
import com.example.mongodb.model.Driver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
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
