package com.joboffers.candidates.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
@Builder
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
/*
    public ProfessionalInformationEntity getProfessionalInformation() {
        return professionalInformation;
    }

    public void setProfessionalInformation(ProfessionalInformationEntity professionalInformation) {
        this.professionalInformation = professionalInformation;
    }*/
}
