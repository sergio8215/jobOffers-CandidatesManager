package com.joboffers.candidates.domain.entity;

import com.joboffers.candidates.service.model.CareerType;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@Entity
@Table(name = "career_informations")
public class ProfessionalInformationEntity extends CareerInformationEntity {

    @Column(name = "notes", nullable = false)
    private final String notes;

    @ManyToMany(cascade = ALL, mappedBy = "professionalInformationList")
    private List<TechnologyEntity> technologyList = List.of();


    @Builder
    public ProfessionalInformationEntity(final String name,
                                         final String description,
                                         final LocalDate startDate,
                                         final LocalDate endDate,
                                         final String notes,
                                         final List<TechnologyEntity> technologyList,
                                         final CandidateEntity candidate) {
        super(name, description, startDate, endDate, candidate, CareerType.PROFESSIONAL.name());
        this.notes = notes;
        this.technologyList = technologyList;
    }
}
