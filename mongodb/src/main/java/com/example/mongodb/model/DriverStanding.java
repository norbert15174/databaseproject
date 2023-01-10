package com.example.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class DriverStanding {

    @Id
    private Long id;
    private Long raceId;
    private Long driverId;
    private Float points;
    private Long position;
    private Long wins;

}
