package com.joboffers.candidates.domain.models;

import java.time.LocalDate;
import java.util.List;


public class ProfessionalInformation {

    private final String name;
    private final String description;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String notes;
    private final List<Technology> technologyList;

    public ProfessionalInformation( String name,  String description,  LocalDate startDate,  LocalDate endDate,  String notes,  List<Technology> technologyList) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
        this.technologyList = technologyList;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getNotes() {
        return notes;
    }

    public List<Technology> getTechnologyList() {
        return technologyList;
    }
}
