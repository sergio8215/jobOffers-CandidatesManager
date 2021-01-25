package com.joboffers.candidates.service.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class EducationalInformation {
    private final String name;
    private final String description;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String course;
    private final String place;
    private final List<Technology> technologyList;

    public EducationalInformation(final String name, final String description, final LocalDate startDate, final LocalDate endDate, final String course, final String place, final List<Technology> technologyList) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.place = place;
        this.technologyList = technologyList;
    }

}
