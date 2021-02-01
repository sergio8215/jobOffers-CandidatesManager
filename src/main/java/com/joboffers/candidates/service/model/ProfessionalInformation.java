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

}
