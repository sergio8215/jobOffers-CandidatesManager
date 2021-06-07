package com.joboffers.candidates.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@Builder
@Entity
@Table(name = "Technologies")
public class TechnologyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String technology;

    @ManyToMany(cascade = ALL, mappedBy = "technologyList")
    private List<EducationalInformationEntity> educationalInformationList;

    @ManyToMany(cascade = ALL, mappedBy = "technologyList")
    private List<ProfessionalInformationEntity> professionalInformationList;

}
