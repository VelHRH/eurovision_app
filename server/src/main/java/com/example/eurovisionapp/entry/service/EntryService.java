package com.example.eurovisionapp.entry.service;

import com.example.eurovisionapp.country.service.CountryService;
import com.example.eurovisionapp.csvBatch.EntryCsvBean;
import com.example.eurovisionapp.entry.model.Entry;
import com.example.eurovisionapp.entry.repository.EntryRepository;
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

    @Autowired
    CountryService countryService;

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
                entryRepository.save(entry);
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
        String countryId = entryCsv.getCountryId();
        if (entry.getArtists() == null) entry.setArtists(personService.getPeopleByNames(performer));
        if (entry.getLyricists() == null) entry.setLyricists(personService.getPeopleByNames(lyricists));
        if (entry.getComposers() == null) entry.setComposers(personService.getPeopleByNames(composers));
        if (entry.getYear() == null) entry.setYear(Integer.parseInt(year));
        if (entry.getName() == null) entry.setName(songName);
        if (entry.getLyrics() == null) entry.setLyrics(lyrics);
        if (entry.getLink() == null) entry.setLink(url);
        if (entry.getSemiNumber() == null) entry.setSemiNumber(convertToInteger(semiNumber));
        if (entry.getFinalOrder() == null) entry.setFinalOrder(convertToInteger(runningFinal));
        if (entry.getSemiOrder() == null) entry.setSemiOrder(convertToInteger(runningSemi));
        if (entry.getPointsFinal() == null) entry.setPointsFinal(convertToInteger(pointsFinal));
        if (entry.getPointsSemi() == null) entry.setPointsSemi(convertToInteger(pointsSemi));
        if (entry.getPointsFinalTele() == null) entry.setPointsFinalTele(convertToInteger(pointsFinalTele));
        if (entry.getPointsFinalJury() == null) entry.setPointsFinalJury(convertToInteger(pointsFinalJury));
        if (entry.getPointsSemiTele() == null) entry.setPointsSemiTele(convertToInteger(pointsSemiTele));
        if (entry.getPointsSemiJury() == null) entry.setPointsSemiJury(convertToInteger(pointsSemiJury));
        if (entry.getPlaceFinal() == null) entry.setPlaceFinal(convertToInteger(placeFinal));
        if (entry.getPlaceSemi() == null) entry.setPlaceSemi(convertToInteger(placeSemi));
        if (entry.getCountry() == null) entry.setCountry(countryService.getCountryById(countryId));
        System.out.println(entry.getPlaceSemi());
    }

    private static Integer convertToInteger(String str) {
        if (str != null && !str.trim().isEmpty()) {
            String trimmedStr = str.trim();
            if (trimmedStr.endsWith(".0")) {
                trimmedStr = trimmedStr.substring(0, trimmedStr.length() - 2);
            }
            try {
                return Integer.parseInt(trimmedStr);
            } catch (NumberFormatException e) {
                System.err.println("Error string to int: " + e.getMessage()); //TODO: improve errors
            }
        }
        return null;
    }
}
