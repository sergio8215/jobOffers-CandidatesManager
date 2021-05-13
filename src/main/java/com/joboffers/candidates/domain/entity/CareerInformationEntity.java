package com.joboffers.candidates.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Getter
@AllArgsConstructor
@Table(name = "career_informations")
@MappedSuperclass
public abstract class CareerInformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "school", nullable = false)
    private final String name;

    @Column(name = "description", nullable = false)
    private final String description;

    @Column(name = "start_date", nullable = false)
    private final LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private final LocalDate endDate;

    @Column(name = "career_type", nullable = false)
    private final String careerType;

    @ManyToOne(optional = false, fetch = LAZY)
    @JoinColumn(name = "candidate_id", nullable = false, updatable = false)
    private final CandidateEntity candidate;

    protected CareerInformationEntity(final String name,
                                      final String description,
                                      final LocalDate startDate,
                                      final LocalDate endDate,
                                      final CandidateEntity candidate,
                                      final String careerType) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.careerType = careerType;
        this.candidate = candidate;
    }
}
