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
public class EducationalInformationEntity extends CareerInformationEntity {

    @Column(name = "course", nullable = false)
    private final String course;

    @Column(name = "place")
    private final String place;

    @Column(name = "notes")
    private final String notes;

    @ManyToMany(cascade = ALL, mappedBy = "educationalInformationList")
    private final List<TechnologyEntity> technologyList;

    @Builder
    public EducationalInformationEntity(final String name,
                                        final String description,
                                        final LocalDate startDate,
                                        final LocalDate endDate,
                                        final String course,
                                        final String place,
                                        final String notes,
                                        final List<TechnologyEntity> technologyList) {
        super(name, description, startDate, endDate, CareerType.EDUCATIONAL.name());
        this.course = course;
        this.place = place;
        this.notes = notes;
        this.technologyList = technologyList;
    }
}
