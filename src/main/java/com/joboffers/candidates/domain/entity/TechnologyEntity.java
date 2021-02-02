package com.joboffers.candidates.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;

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

    @ManyToMany(cascade = ALL)
    @JoinTable(name = "technologies_educationalInfo",
        joinColumns = @JoinColumn(name = "technologyId"),
        inverseJoinColumns = @JoinColumn(name = "educationalInformationId")
    )
    private List<EducationalInformationEntity> educationalInformationList;

    @ManyToMany(cascade = ALL)
    @JoinTable(name = "technologies_professionalInfo",
        joinColumns = @JoinColumn(name = "technologyId"),
        inverseJoinColumns = @JoinColumn(name = "professionalInformationId")
    )
    private List<ProfessionalInformationEntity> professionalInformationList;

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(final String technology) {
        this.technology = technology;
    }

    public List<EducationalInformationEntity> getEducationalInformationList() {
        return educationalInformationList;
    }

    public void setEducationalInformationList(final List<EducationalInformationEntity> educationalInformationList) {
        this.educationalInformationList = educationalInformationList;
    }

    public List<ProfessionalInformationEntity> getProfessionalInformationList() {
        return professionalInformationList;
    }

    public void setProfessionalInformationList(final List<ProfessionalInformationEntity> professionalInformationList) {
        this.professionalInformationList = professionalInformationList;
    }
}
