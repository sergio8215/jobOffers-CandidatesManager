package com.joboffers.candidates.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Builder
@Entity
@Table(name = "career_informations")
public class EducationalInformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "school", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "place")
    private String place;

    @Column(name = "notes")
    private String notes;

    @ManyToMany(cascade = ALL, mappedBy = "educationalInformationList")
    private List<TechnologyEntity> technologyList;

    @ManyToOne(optional = false, fetch = LAZY)
    @JoinColumn(name = "candidate_id", nullable = false, updatable = false)
    private CandidateEntity candidate;

}
