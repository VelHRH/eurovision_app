package com.example.eurovisionapp.csvBatch;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvReader {
    public static List<EntryCsvBean> readEntriesFile() {
        try {
            FileReader reader = new FileReader("/home/valentin/Downloads/eurovision-dataset/contestants.csv");
            CsvToBean<EntryCsvBean> csvtobean = new CsvToBeanBuilder<EntryCsvBean>(reader)
                    .withType(EntryCsvBean.class)
                    .build();
            return csvtobean.parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
