package com.example.eurovisionapp.person.service;

import com.example.eurovisionapp.csvBatch.EntryCsvBean;
import com.example.eurovisionapp.person.model.Person;
import com.example.eurovisionapp.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person addPersonByName(String name) {
        Person person = new Person();
        person.setName(name);
        return personRepository.save(person);
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public void loadPeopleFromCsv(List<EntryCsvBean> entries) {
        if (personRepository.count() > 0) {
            return;
        }

        Set<String> uniqueNames = new HashSet<>();

        for (EntryCsvBean entry : entries) {
            addPersonToSet(entry.getPerformer(), uniqueNames);
            addPersonToSet(entry.getComposers(), uniqueNames);
            addPersonToSet(entry.getLyricists(), uniqueNames);
        }

        for (String name : uniqueNames) {
            addPersonByName(name);
        }
    }

    private void addPersonToSet(String names, Set<String> set) {
        String[] splitNames = splitNames(names);
        if (splitNames == null) return;
        for (String name : splitNames) {
            set.add(name.trim());
        }
    }

    public List<Person> getPeopleByNames(String names) {
        List<Person> people = new ArrayList<>();
        String[] splitNames = splitNames(names);

        if (splitNames == null) return people;

        for (String name : splitNames) {
            people.add(personRepository.findByName(name));
        }
        return people;
    }

    public String[] splitNames(String names) {
        if (names != null && !names.trim().isEmpty()) {
            return names.split(";");
        }
        return null;
    }
}
