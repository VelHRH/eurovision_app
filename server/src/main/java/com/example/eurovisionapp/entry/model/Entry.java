package com.example.eurovisionapp.entry.model;

import com.example.eurovisionapp.country.model.Country;
import com.example.eurovisionapp.person.model.Person;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer year;
    private String name;
    private String link;
    private Integer finalOrder;
    private Integer semiOrder;
    private Integer semiNumber;
    private Integer placeFinal;
    private Integer placeSemi;
    private Integer pointsFinal;
    private Integer pointsFinalTele;
    private Integer pointsFinalJury;
    private Integer pointsSemi;
    private Integer pointsSemiTele;
    private Integer pointsSemiJury;
    @Column(columnDefinition="TEXT")
    private String lyrics;
    @ManyToOne
    private Country country;
    @ManyToMany
    private List<Person> artists;
    @ManyToMany
    private List<Person> composers;
    @ManyToMany
    private List<Person> lyricists;
}
