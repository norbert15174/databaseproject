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
public class Circuit {

    @Id
    private Long id;
    private String name;
    private String location;
    private String country;
    private String url;
    @DBRef
    private Set <Race> races = new HashSet <>();

    public void addRaces(Set <Race> races) {
        this.races.addAll(races);
    }
}
