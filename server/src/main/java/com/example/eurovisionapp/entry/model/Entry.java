package com.example.eurovisionapp.entry.model;

import com.example.eurovisionapp.artist.model.Artist;
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
    private List<Artist> artists;
    private String link;
    @ManyToMany
    private List<Artist> composers;
    @ManyToMany
    private List<Artist> lyricists;
    @Column(columnDefinition="TEXT")
    private String lyrics;
}
