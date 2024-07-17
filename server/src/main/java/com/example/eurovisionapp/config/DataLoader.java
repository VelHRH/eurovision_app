package com.example.eurovisionapp.config;

import com.example.eurovisionapp.csvBatch.CsvReader;
import com.example.eurovisionapp.csvBatch.EntryCsvBean;
import com.example.eurovisionapp.entry.repository.EntryRepository;
import com.example.eurovisionapp.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private PersonService personService;

    @Autowired
    private EntryRepository entryRepository;

    public void run(String ...args) {
        if (entryRepository.count() > 0) {
            return;
        }
        List<EntryCsvBean> entriesFromCsv = CsvReader.readEntriesFile();
        load(entriesFromCsv);
    }

    public void load(List<EntryCsvBean> entriesFromCsv) {
        personService.loadPeopleFromCsv(entriesFromCsv);
    }
}
