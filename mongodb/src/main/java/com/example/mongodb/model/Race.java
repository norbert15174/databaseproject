package com.example.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class Race {

    @Id
    private Long id;
    private Long year;
    private Long round;
    private Long circuitId;
    private String name;
    private String date;
    private String url;
    @DBRef
    private Set <LapTime> lapTimes = new HashSet <>();
    @DBRef
    private Set <DriverStanding> driverStandings = new HashSet <>();

}
