package com.joboffers.candidates.service.model.builder;

import com.joboffers.candidates.service.model.ProfessionalInformation;
import com.joboffers.candidates.service.model.Technology;

import java.time.LocalDate;
import java.util.List;

public final class ProfessionalInformationBuilder {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String notes;
    private List<Technology> technologyList;

    private ProfessionalInformationBuilder() {
    }

    public static ProfessionalInformationBuilder aProfessionalInformation() {
        return new ProfessionalInformationBuilder();
    }

    public ProfessionalInformationBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProfessionalInformationBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProfessionalInformationBuilder withStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public ProfessionalInformationBuilder withEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public ProfessionalInformationBuilder withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ProfessionalInformationBuilder withTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
        return this;
    }

    public ProfessionalInformation build() {
        return new ProfessionalInformation(name, description, startDate, endDate, notes, technologyList);
    }
}
