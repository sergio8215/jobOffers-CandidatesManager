package com.joboffers.candidates.domain.entity;

import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.ProfessionalInformation;
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

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(cascade = ALL, mappedBy = "candidates")
    private List<EducationalInformation> educationalInformationList;

    @OneToMany(cascade = ALL, mappedBy = "candidates")
    private List<ProfessionalInformation> professionalInformationList;


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

    public String getLinkedin() {
        return linkedin;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<EducationalInformation> getEducationalInformationList() {
        return educationalInformationList;
    }

    public List<ProfessionalInformation> getProfessionalInformationList() {
        return professionalInformationList;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEducationalInformationList(List<EducationalInformation> educationalInformationList) {
        this.educationalInformationList = educationalInformationList;
    }

    public void setProfessionalInformationList(List<ProfessionalInformation> professionalInformationList) {
        this.professionalInformationList = professionalInformationList;
    }
}
