package com.joboffers.candidates.service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class Candidate {

    private String name;
    private LocalDate birthday;
    private String gender;
    private String email;
    private String address;
    private String linkedIn;
    private String phoneNumber;
    private List<EducationalInformation> educationalInformationList;
    private List<ProfessionalInformation> professionalInformationList;

    public Candidate(final String name, final LocalDate birthday, final String gender, final String email, final String address, final String linkedIn, final String phoneNumber, final List<EducationalInformation> educationalInformationList, final List<ProfessionalInformation> professionalInformationList) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.linkedIn = linkedIn;
        this.phoneNumber = phoneNumber;
        this.educationalInformationList = educationalInformationList;
        this.professionalInformationList = professionalInformationList;
    }

}
