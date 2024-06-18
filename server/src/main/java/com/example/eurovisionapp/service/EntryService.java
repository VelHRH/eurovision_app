package com.example.eurovisionapp.service;

import com.example.eurovisionapp.model.Entry;
import com.example.eurovisionapp.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {

    @Autowired
    EntryRepository entryRepository;

    public List<Entry> getAll() {
        return entryRepository.findAll();
    }
}
