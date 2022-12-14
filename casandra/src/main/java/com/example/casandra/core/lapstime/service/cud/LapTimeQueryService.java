package com.example.casandra.core.lapstime.service.cud;

import com.example.casandra.core.lapstime.repository.ILapTimeRepository;
import com.example.casandra.model.LapTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Transactional(readOnly = true)
@Service
class LapTimeQueryService implements ILapTimeQueryService {

    private final ILapTimeRepository repository;

    @Override
    public Set <LapTime> getAll() {
        return new HashSet <>(repository.findAll());
    }

    @Override
    public LapTime getById(UUID id) {
        return repository.findById(id).get();
    }

}
