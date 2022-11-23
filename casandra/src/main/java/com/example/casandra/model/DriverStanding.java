package com.example.casandra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
public class DriverStanding {

    @PrimaryKey
    private Long id;
    private Long raceId;
    private Long driverId;
    private Float points;
    private Long position;
    private Long wins;

}
