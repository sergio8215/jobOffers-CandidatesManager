package com.joboffers.candidates.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@Builder
@Entity
@Table(name = "candidates")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "linkedin")
    private String linkedIn;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(cascade = ALL, mappedBy = "candidate", orphanRemoval = true)
    private List<EducationalInformationEntity> educationalInformationList;

    @OneToMany(cascade = ALL, mappedBy = "candidate", orphanRemoval = true)
    private List<ProfessionalInformationEntity> professionalInformationList;
}
