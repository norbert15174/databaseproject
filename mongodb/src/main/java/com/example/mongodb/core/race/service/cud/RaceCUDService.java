package com.example.mongodb.core.race.service.cud;

import com.example.mongodb.core.race.repository.IRaceRepository;
import com.example.mongodb.model.Race;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
class RaceCUDService implements IRaceCUDService {

    private final IRaceRepository repository;

    @Override
    public Race save(Race entity) {
        var saved = repository.save(entity);
        log.info("Race with id {} created" , saved.getId());
        return saved;
    }

}
