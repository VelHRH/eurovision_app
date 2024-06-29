package com.example.eurovisionapp.entry.service;

import com.example.eurovisionapp.csvBatch.CsvReader;
import com.example.eurovisionapp.csvBatch.EntryCsvBean;
import com.example.eurovisionapp.entry.model.Entry;
import com.example.eurovisionapp.entry.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryService {

    @Autowired
    EntryRepository entryRepository;

    public ResponseEntity<List<Entry>> getAll() {
        try {
            return new ResponseEntity<>(entryRepository.findAll(), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> load() {
        List<EntryCsvBean> entries = CsvReader.readEntriesFile();
        for (EntryCsvBean entry : entries) {
            System.out.println(entry.getSong() + "      " + entry.getPerformer());
        }
        return new ResponseEntity<>("Loaded", HttpStatus.OK);
    }
}
