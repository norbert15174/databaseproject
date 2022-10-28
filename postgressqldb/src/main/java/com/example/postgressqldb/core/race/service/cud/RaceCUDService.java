package com.example.postgressqldb.core.race.service.cud;

import com.example.postgressqldb.core.race.repository.IRaceRepository;
import com.example.postgressqldb.model.Race;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
class RaceCUDService implements IRaceCUDService {

    private final IRaceRepository repository;

    @Override
    public Race save(Race entity) {
        var saved = repository.save(entity);
        log.info("Race with id {} created" , saved.getId());
        return saved;
    }

}
