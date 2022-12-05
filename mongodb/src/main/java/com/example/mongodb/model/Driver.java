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
public class Driver {

    @Id
    private Long id;
    private String driverRef;
    private String forename;
    private String surname;
    private String dob;
    private String nationality;
    private String url;

}
