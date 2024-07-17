package com.example.eurovisionapp.entry.controller;

import com.example.eurovisionapp.entry.model.Entry;
import com.example.eurovisionapp.entry.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("entry")
public class EntryController {

    @Autowired
    EntryService entryService;

    @GetMapping
    public ResponseEntity<List<Entry>> getAllEntries() {
        return entryService.getAll();
    }
}
