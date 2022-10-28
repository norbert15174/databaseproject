package com.example.postgressqldb.core.race.repository;

import com.example.postgressqldb.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRaceRepository extends JpaRepository <Race, Long> {
}
