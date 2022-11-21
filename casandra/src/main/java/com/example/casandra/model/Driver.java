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
public class Driver {

    @PrimaryKey
    private Long id;
    private String driverRef;
    private String forename;
    private String surname;
    private String dob;
    private String nationality;
    private String url;

}
