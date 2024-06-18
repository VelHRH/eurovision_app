package com.example.eurovisionapp.controller;

import com.example.eurovisionapp.model.Entry;
import com.example.eurovisionapp.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Entry> getAllEntries() {
        return entryService.getAll();
    }
}
