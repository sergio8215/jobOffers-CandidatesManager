package com.joboffers.candidates.domain.builders;

import com.joboffers.candidates.domain.models.ProfessionalInformation;
import com.joboffers.candidates.domain.models.Technology;

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

    public ProfessionalInformationBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProfessionalInformationBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProfessionalInformationBuilder setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public ProfessionalInformationBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public ProfessionalInformationBuilder setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ProfessionalInformationBuilder setTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
        return this;
    }

    public ProfessionalInformation build() {
        return new ProfessionalInformation(name, description, startDate, endDate, notes, technologyList);
    }
}
