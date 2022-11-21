package com.example.casandra.core.race.service.cud;

import com.example.casandra.core.race.repository.IRaceRepository;
import com.example.casandra.model.Race;
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
