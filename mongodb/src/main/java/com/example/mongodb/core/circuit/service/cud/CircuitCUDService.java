package com.example.mongodb.core.circuit.service.cud;

import com.example.mongodb.core.circuit.repository.ICircuitRepository;
import com.example.mongodb.model.Circuit;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


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
