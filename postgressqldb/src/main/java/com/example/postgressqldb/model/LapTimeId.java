package com.example.postgressqldb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LapTimeId implements Serializable {

    @Column(name = "race_id")
    private Long raceId;
    @Column(name = "driver_id")
    private Long driverId;
    @Column(name = "lap_id")
    private Long lapId;

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        LapTimeId lapTimeId = (LapTimeId) o;
        return Objects.equals(lapTimeId.getRaceId() , getRaceId())
                && Objects.equals(lapTimeId.getDriverId() , getDriverId())
                && Objects.equals(lapTimeId.getLapId() , getLapId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceId , driverId , lapId);
    }

}
