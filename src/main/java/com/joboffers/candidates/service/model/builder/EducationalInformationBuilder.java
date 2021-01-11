package com.joboffers.candidates.service.model.builder;

import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.Technology;

import java.time.LocalDate;
import java.util.List;

public final class EducationalInformationBuilder {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String course;
    private String place;
    private List<Technology> technologyList;

    private EducationalInformationBuilder() {
    }

    public static EducationalInformationBuilder anEducationalInformation() {
        return new EducationalInformationBuilder();
    }

    public EducationalInformationBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public EducationalInformationBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public EducationalInformationBuilder withStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public EducationalInformationBuilder withEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public EducationalInformationBuilder withCourse(String course) {
        this.course = course;
        return this;
    }

    public EducationalInformationBuilder withPlace(String place) {
        this.place = place;
        return this;
    }

    public EducationalInformationBuilder withTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
        return this;
    }

    public EducationalInformation build() {
        return new EducationalInformation(name, description, startDate, endDate, course, place, technologyList);
    }
}
