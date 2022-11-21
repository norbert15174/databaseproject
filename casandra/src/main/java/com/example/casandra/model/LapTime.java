package com.example.casandra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
public class LapTime {

    @PrimaryKey
    private UUID id;
    private Long raceId;
    private Long driverId;
    private Long lap;
    private Long position;
    private String time;
    private Long milliseconds;

}
