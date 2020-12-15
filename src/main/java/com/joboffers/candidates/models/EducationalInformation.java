package com.joboffers.candidates.models;

import java.time.LocalDate;
import java.util.List;

public class EducationalInformation {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String course;
    private String place;
    private List<Technology> technologies;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    public EducationalInformation(String name, String description, LocalDate startDate, LocalDate endDate, String course, String place, List<Technology> technologies) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.place = place;
        this.technologies = technologies;
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

    public List<Technology> getTechnologies() {
        return technologies;
    }
}
