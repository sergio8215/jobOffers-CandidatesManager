package com.joboffers.candidates.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@Builder
public class CandidateEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

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

    @Column(name = "linkedIn")
    private String linkedIn;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(cascade = ALL, mappedBy = "candidates")
    private List<EducationalInformationEntity> educationalInformationList;

    @OneToMany(cascade = ALL, mappedBy = "candidates")
    private List<ProfessionalInformationEntity> professionalInformationList;

}
