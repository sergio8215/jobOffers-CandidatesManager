package com.joboffers.candidates.service.model;

import java.time.LocalDate;
import java.util.List;

public class Candidate {

    private final String name;
    private final LocalDate birthday;
    private final String gender;
    private final String email;
    private final String address;
    private final String linkedin;
    private final String phoneNumber;
    private final List<EducationalInformation> educationalInformationList;
    private final List<ProfessionalInformation> professionalInformationList;

    public Candidate(String name, LocalDate birthday, String gender, String email, String address, String linkedin, String phoneNumber, List<EducationalInformation> educationalInformationList, List<ProfessionalInformation> professionalInformationList) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.linkedin = linkedin;
        this.phoneNumber = phoneNumber;
        this.educationalInformationList = educationalInformationList;
        this.professionalInformationList = professionalInformationList;
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
}
