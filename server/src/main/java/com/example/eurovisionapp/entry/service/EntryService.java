package com.example.eurovisionapp.entry.service;

import com.example.eurovisionapp.csvBatch.EntryCsvBean;
import com.example.eurovisionapp.entry.model.Entry;
import com.example.eurovisionapp.entry.repository.EntryRepository;
import com.example.eurovisionapp.person.model.Person;
import com.example.eurovisionapp.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EntryService {
    @Autowired
    EntryRepository entryRepository;

    @Autowired
    PersonService personService;

    public List<Entry> getAll() {
        return entryRepository.findAll();
    }

    public Entry findByNameAndArtist(String name, String artist) {
        return entryRepository.findByNameAndArtist(name, artist).getFirst();
    }

    public void loadEntriesFromCsv(List<EntryCsvBean> entries) {
        Set<String> processedEntries = new HashSet<>();
        for (EntryCsvBean entryCsv : entries) {
            String performer = entryCsv.getPerformer();
            String songName = entryCsv.getSong();

            String uniqueKey = songName + "-" + performer;

            if (!processedEntries.contains(uniqueKey)) {
                Entry entry = new Entry();
                fillEntry(entry, entryCsv);
                entryRepository.save(entry);
                processedEntries.add(uniqueKey);
            } else {
                Entry entry = findByNameAndArtist(songName, performer);
                fillEntry(entry, entryCsv);
            }
        }
    }

    private void fillEntry(Entry entry, EntryCsvBean entryCsv) {
        String semiNumber = entryCsv.getSemiNumber();
        String runningFinal = entryCsv.getRunningFinal();
        String runningSemi = entryCsv.getRunningSemi();
        String pointsSemiJury = entryCsv.getPointsSemiJury();
        String pointsSemiTele = entryCsv.getPointsSemiTele();
        String pointsSemi = entryCsv.getPointsSemi();
        String pointsFinalJury = entryCsv.getPointsFinalJury();
        String pointsFinalTele = entryCsv.getPointsFinalTele();
        String pointsFinal = entryCsv.getPointsFinal();
        String placeFinal = entryCsv.getPlaceFinal();
        String placeSemi = entryCsv.getPlaceSemi();
        String year = entryCsv.getYear();
        String performer = entryCsv.getPerformer();
        String lyricists = entryCsv.getLyricists();
        String composers = entryCsv.getComposers();
        String songName = entryCsv.getSong();
        String lyrics = entryCsv.getLyrics();
        String url = entryCsv.getUrl();
        // TODO: fill entry with data from csv
        if (entry.getArtists().isEmpty()) entry.setArtists(personService.getPeopleByNames(performer));
        if (entry.getLyricists().isEmpty()) entry.setLyricists(personService.getPeopleByNames(lyricists));
        if (entry.getComposers().isEmpty()) entry.setComposers(personService.getPeopleByNames(composers));
        if (entry.getYear().equals(0)) entry.setYear(Integer.parseInt(year));
        if (entry.getName().isEmpty()) entry.setName(songName);
        if (entry.getLyrics().isEmpty()) entry.setLyrics(lyrics);
    }
}
