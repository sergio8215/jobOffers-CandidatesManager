package com.joboffers.candidates.builders;

import com.joboffers.candidates.models.Technology;

import java.time.LocalDate;
import java.util.List;


public class ProfessionalInformationBuilder {

    private final String name;
    private final String description;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String notes;
    private final List<Technology> technologyList;

    public ProfessionalInformationBuilder(String name, String description, LocalDate startDate, LocalDate endDate, String notes, List<Technology> technologyList) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
        this.technologyList = technologyList;
    }

}
