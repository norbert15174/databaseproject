package com.example.postgressqldb.core.driverstanding.service.cud;

import com.example.postgressqldb.core.driverstanding.repository.IDriverStandingRepository;
import com.example.postgressqldb.model.DriverStanding;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional(readOnly = true)
@AllArgsConstructor
@Service
public class DriverStandingQueryService implements IDriverStandingQueryService {

    private final IDriverStandingRepository repository;

    @Override
    public Set <DriverStanding> getAll() {
        return new HashSet <>(repository.findAll());
    }

    @Override
    public DriverStanding getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Set <DriverStanding> getAllByNumber(Integer number) {
        return new HashSet <>(repository.findAll(PageRequest.of(0 , number)).getContent());
    }

}
