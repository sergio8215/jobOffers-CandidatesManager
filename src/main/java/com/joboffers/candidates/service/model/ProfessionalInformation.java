package com.joboffers.candidates.service.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class ProfessionalInformation {

    private final String name;
    private final String description;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String notes;
    private final List<Technology> technologyList;

    public ProfessionalInformation(final String name, final String description, final LocalDate startDate, final LocalDate endDate, final String notes, final List<Technology> technologyList) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
        this.technologyList = technologyList;
    }

}
