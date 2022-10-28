package com.example.postgressqldb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "circuit")
public class Circuit {

    @Id
    private Long id;
    private String name;
    private String location;
    private String country;
    private String url;
    @OneToMany(mappedBy = "circuit")
    private Set <Race> races;

}
