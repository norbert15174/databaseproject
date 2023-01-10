package com.example.postgressqldb.core.driver.service.cud;

import com.example.postgressqldb.core.driver.repository.IDriverRepository;
import com.example.postgressqldb.model.Driver;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
class DriverQueryService implements IDriverQueryService {

    private final IDriverRepository repository;

    @Override
    public Set <Driver> getAll() {
        return new HashSet <>(repository.findAll());
    }

    @Override
    public Set <Driver> getAllByNumber(Integer number) {
        return new HashSet <>(repository.findAll(PageRequest.of(0 , number)).getContent());
    }

}
