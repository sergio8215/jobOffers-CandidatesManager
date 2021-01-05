package com.joboffers.candidates.domain.entity;

import com.joboffers.candidates.domain.models.Candidate;
import com.joboffers.candidates.domain.models.EducationalInformation;
import com.joboffers.candidates.domain.models.ProfessionalInformation;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "Technologies")
public class TechnologyEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "technology", nullable = false)
    private String technology;

    @ManyToOne(optional = false, fetch = LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false)
    private EducationalInformation educationalInformation;

    @ManyToOne(optional = false, fetch = LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false)
    private ProfessionalInformation professionalInformation;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public EducationalInformation getEducationalInformation() {
        return educationalInformation;
    }

    public void setEducationalInformation(EducationalInformation educationalInformation) {
        this.educationalInformation = educationalInformation;
    }

    public ProfessionalInformation getProfessionalInformation() {
        return professionalInformation;
    }

    public void setProfessionalInformation(ProfessionalInformation professionalInformation) {
        this.professionalInformation = professionalInformation;
    }
}
