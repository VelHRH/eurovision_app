package com.example.eurovisionapp.country.service;

import com.example.eurovisionapp.country.model.Country;
import com.example.eurovisionapp.country.repository.CountryRepository;
import com.example.eurovisionapp.csvBatch.EntryCsvBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country getCountryById(String id) {
        return countryRepository.findById(id);
    }

    public void loadCountriesFromCsv(List<EntryCsvBean> entries) {
        if (countryRepository.count() > 0) {
            return;
        }

        Set<String> processedIds = new HashSet<>();
        for (EntryCsvBean entry : entries) {
            String countryId = entry.getCountryId();
            String countryName = entry.getCountryName();

            if (!processedIds.contains(countryId)) {
                Country country = new Country();
                country.setId(countryId);
                country.setName(countryName);
                addCountry(country);

                processedIds.add(countryId);
            }
        }
    }
}
