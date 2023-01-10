package com.example.postgressqldb.core.lapstime.service.cud;

import com.example.postgressqldb.core.lapstime.repository.ILapTimeRepository;
import com.example.postgressqldb.model.LapTime;
import com.example.postgressqldb.model.LapTimeId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

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
    public LapTime getById(LapTimeId id) {
        return repository.findById(id).get();
    }

}
