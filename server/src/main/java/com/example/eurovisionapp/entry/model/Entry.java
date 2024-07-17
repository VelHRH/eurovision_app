package com.example.eurovisionapp.entry.model;

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
    private String country_id;
    private String name;
    @ManyToMany
    private List<Person> artists;
    private String link;
    @ManyToMany
    private List<Person> composers;
    @ManyToMany
    private List<Person> lyricists;
    @Column(columnDefinition="TEXT")
    private String lyrics;
}
