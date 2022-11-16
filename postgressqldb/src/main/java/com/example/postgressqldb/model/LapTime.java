package com.example.postgressqldb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "laptime")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LapTime implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "race", column = @Column(name = "race_id")) ,
            @AttributeOverride(name = "driver", column = @Column(name = "driver_id")) ,
            @AttributeOverride(name = "lapId", column = @Column(name = "lap_id"))
    })
    private LapTimeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("race_id")
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("driver_id")
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("lap_id")
    @JoinColumn(name = "lap_id", nullable = false)
    private Lap lap;

    private Long position;
    private String time;
    private Long milliseconds;

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        LapTime lapTime = (LapTime) o;
        return Objects.equals(id , lapTime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void initId() {
        this.id = new LapTimeId(race.getId() , driver.getId() , lap.getId());
    }

}
