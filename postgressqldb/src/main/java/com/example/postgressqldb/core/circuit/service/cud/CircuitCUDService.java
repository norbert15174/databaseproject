package com.example.postgressqldb.core.circuit.service.cud;

import com.example.postgressqldb.core.circuit.repository.ICircuitRepository;
import com.example.postgressqldb.model.Circuit;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Slf4j
@AllArgsConstructor
@Service
class CircuitCUDService implements ICircuitCUDService {

    private final ICircuitRepository repository;

    @Override
    public Circuit save(Circuit entity) {
        var saved = repository.save(entity);
        log.info("Circuit with id {} created" , saved.getId());
        return saved;
    }

}
