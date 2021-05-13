package com.joboffers.candidates.service.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProfessionalInformation extends CareerInformation {

    private String notes;

    @Builder
    public ProfessionalInformation(final String name,
                                   final String description,
                                   final LocalDate startDate,
                                   final LocalDate endDate,
                                   final String notes,
                                   final List<Technology> technologyList) {
        super(name, description, startDate, endDate, CareerType.PROFESSIONAL, technologyList);
        this.notes = notes;
    }

    public ProfessionalInformation() {
    } // necessary for deserialization
}
