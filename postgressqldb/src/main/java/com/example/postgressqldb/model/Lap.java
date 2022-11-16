package com.example.postgressqldb.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "lap")
public class Lap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter(value = AccessLevel.NONE)
    @OneToMany(mappedBy = "lap")
    private Set <LapTime> lapTimes = new HashSet <>();

    public Lap(Long id) {
        this.id = id;
    }

}
