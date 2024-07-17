package com.example.eurovisionapp.entry.repository;

import com.example.eurovisionapp.entry.model.Entry;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Integer> {
    @Query("SELECT e FROM Entry e JOIN e.artists a WHERE e.name = :name AND a.name = :artistName")
    List<Entry> findByNameAndArtist(@Param("name") String name, @Param("artistName") String artistName);
}
