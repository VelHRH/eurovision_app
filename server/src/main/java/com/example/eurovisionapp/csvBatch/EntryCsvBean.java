package com.example.eurovisionapp.csvBatch;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class EntryCsvBean {
    @CsvBindByName()
    private String year;

    @CsvBindByName(column = "to_country_id")
    private String countryId;

    @CsvBindByName(column = "to_country")
    private String countryName;

    @CsvBindByName()
    private String performer;

    @CsvBindByName()
    private String song;

    @CsvBindByName(column = "place_contest")
    private String placeFinal;

    @CsvBindByName(column = "place_sf")
    private String placeSemi;

    @CsvBindByName(column = "sf_num")
    private String semiNumber;

    @CsvBindByName(column = "running_final")
    private String runningFinal;

    @CsvBindByName(column = "running_sf")
    private String runningSemi;

    @CsvBindByName(column = "points_final")
    private String pointsFinal;

    @CsvBindByName(column = "points_sf")
    private String pointsSemi;

    @CsvBindByName(column = "points_tele_final")
    private String pointsFinalTele;

    @CsvBindByName(column = "points_jury_final")
    private String pointsFinalJury;

    @CsvBindByName(column = "points_tele_sf")
    private String pointsSemiTele;

    @CsvBindByName(column = "points_jury_sf")
    private String pointsSemiJury;

    @CsvBindByName()
    private String composers;

    @CsvBindByName()
    private String lyricists;

    @CsvBindByName()
    private String lyrics;

    @CsvBindByName(column = "youtube_url")
    private String url;
}
