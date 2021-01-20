package com.joboffers.candidates.domain.entity;

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


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<EducationalInformationEntity> getEducationalInformationList() {
        return educationalInformationList;
    }

    public List<ProfessionalInformationEntity> getProfessionalInformationList() {
        return professionalInformationList;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setBirthday(final LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setLinkedIn(final String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEducationalInformationList(final List<EducationalInformationEntity> educationalInformationList) {
        this.educationalInformationList = educationalInformationList;
    }

    public void setProfessionalInformationList(final List<ProfessionalInformationEntity> professionalInformationList) {
        this.professionalInformationList = professionalInformationList;
    }
}
