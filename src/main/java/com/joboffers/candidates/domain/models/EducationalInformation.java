package com.joboffers.candidates.domain.models;

import java.time.LocalDate;
import java.util.List;

public class EducationalInformation {
    private final String name;
    private final String description;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String course;
    private final String place;
    private final List<Technology> technologyList;

    public EducationalInformation(String name, String description, LocalDate startDate, LocalDate endDate, String course, String place, List<Technology> technologyList) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.place = place;
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

    public String getCourse() {
        return course;
    }

    public String getPlace() {
        return place;
    }

    public List<Technology> getTechnologyList() {
        return technologyList;
    }
}
