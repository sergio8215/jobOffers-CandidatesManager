package com.joboffers.candidates.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joboffers.candidates.service.model.CareerType;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

    @JsonIgnore
    @ManyToMany(cascade = ALL)
    @JoinTable(name = "technologies_candidates",
            joinColumns = @JoinColumn(name = "career_information_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private final List<TechnologyEntity> technologyList;


    @Builder
    public ProfessionalInformationEntity(final String name,
                                         final String description,
                                         final LocalDate startDate,
                                         final LocalDate endDate,
                                         final String notes,
                                         final List<TechnologyEntity> technologyList) {
        super(name, description, startDate, endDate, CareerType.PROFESSIONAL.name());
        this.notes = notes;
        this.technologyList = technologyList;
    }
}
