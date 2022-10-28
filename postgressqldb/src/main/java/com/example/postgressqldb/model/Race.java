package com.example.postgressqldb.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "race")
public class Race {

    @Id
    private Long id;
    private Long year;
    private Long round;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "circuit_id", nullable = false)
    private Circuit circuit;
    private String name;
    private String date;
    private String url;
    @Setter(value = AccessLevel.NONE)
    @OneToMany(mappedBy = "race")
    private Set <LapTime> lapTimes;

}
