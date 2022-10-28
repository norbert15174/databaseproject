package com.example.postgressqldb.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "driver")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Driver {

    @Id
    private Long id;
    private String driverRef;
    private String forename;
    private String surname;
    private String dob;
    private String nationality;
    private String url;
    @Setter(value = AccessLevel.NONE)
    @OneToMany(mappedBy = "driver")
    private Set <LapTime> lapTimes;

}
