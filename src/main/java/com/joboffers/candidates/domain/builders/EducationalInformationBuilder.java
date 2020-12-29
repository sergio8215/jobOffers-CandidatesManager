package com.joboffers.candidates.domain.builders;

import com.joboffers.candidates.domain.models.EducationalInformation;
import com.joboffers.candidates.domain.models.Technology;

import java.time.LocalDate;
import java.util.List;

public class EducationalInformationBuilder {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String course;
    private String place;
    private List<Technology> technologyList;

    public EducationalInformationBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EducationalInformationBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public EducationalInformationBuilder setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public EducationalInformationBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public EducationalInformationBuilder setCourse(String course) {
        this.course = course;
        return this;
    }

    public EducationalInformationBuilder setPlace(String place) {
        this.place = place;
        return this;
    }

    public EducationalInformationBuilder setTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
        return this;
    }

    public EducationalInformation build() {
        return new EducationalInformation( name,  description,  startDate,  endDate,  course,  place, technologyList);
    }
}
