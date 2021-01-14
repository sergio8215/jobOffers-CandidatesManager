package com.joboffers.candidates.domain.entity;

import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.ProfessionalInformation;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.UUID;

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

    @ManyToMany
    @JoinTable(name = "technologies_candidates")
    private EducationalInformationEntity educationalInformation;

    /*@ManyToMany(optional = false, fetch = LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false)
    private ProfessionalInformationEntity professionalInformation;
*/
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

    public EducationalInformationEntity getEducationalInformation() {
        return educationalInformation;
    }

    public void setEducationalInformation(EducationalInformationEntity educationalInformation) {
        this.educationalInformation = educationalInformation;
    }
/*
    public ProfessionalInformationEntity getProfessionalInformation() {
        return professionalInformation;
    }

    public void setProfessionalInformation(ProfessionalInformationEntity professionalInformation) {
        this.professionalInformation = professionalInformation;
    }*/
}
