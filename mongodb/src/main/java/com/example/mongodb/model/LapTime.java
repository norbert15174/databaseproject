package com.example.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class LapTime {

    @Id
    private UUID id;
    private Long raceId;
    private Long driverId;
    private Long lap;
    private Long position;
    private String time;
    private Long milliseconds;

}
