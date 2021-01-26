package com.joboffers.candidates.service.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class Candidate {

    private final String name;
    private final LocalDate birthday;
    private final String gender;
    private final String email;
    private final String address;
    private final String linkedIn;
    private final String phoneNumber;
    private final List<EducationalInformation> educationalInformationList;
    private final List<ProfessionalInformation> professionalInformationList;

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
