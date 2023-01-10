package com.example.postgressqldb.core.race.service.cud;

import com.example.postgressqldb.core.race.repository.IRaceRepository;
import com.example.postgressqldb.model.Race;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class RaceQueryService implements IRaceQueryService {

    private final IRaceRepository repository;

    @Override
    public Set <Race> getAll() {
        return new HashSet <>(repository.findAll());
    }

    @Override
    public Set <Race> getAllByNumber(Integer number) {
        return new HashSet <>(repository.findAll(PageRequest.of(0 , number)).getContent());
    }

}
