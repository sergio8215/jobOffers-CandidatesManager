package com.joboffers.candidates.domain.builders;

import com.joboffers.candidates.domain.models.Candidate;
import com.joboffers.candidates.domain.models.EducationalInformation;
import com.joboffers.candidates.domain.models.ProfessionalInformation;

import java.time.LocalDate;
import java.util.List;

public final class CandidateBuilder {
    private String name;
    private LocalDate birthday;
    private String gender;
    private String email;
    private String address;
    private String linkedin;
    private String phoneNumber;
    private List<EducationalInformation> educationalInformationList;
    private List<ProfessionalInformation> professionalInformationList;

    private CandidateBuilder() {
    }

    public static CandidateBuilder aCandidate() {
        return new CandidateBuilder();
    }

    public CandidateBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CandidateBuilder setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public CandidateBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public CandidateBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CandidateBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public CandidateBuilder setLinkedin(String linkedin) {
        this.linkedin = linkedin;
        return this;
    }

    public CandidateBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CandidateBuilder setEducationalInformationList(List<EducationalInformation> educationalInformationList) {
        this.educationalInformationList = educationalInformationList;
        return this;
    }

    public CandidateBuilder setProfessionalInformationList(List<ProfessionalInformation> professionalInformationList) {
        this.professionalInformationList = professionalInformationList;
        return this;
    }

    public Candidate build() {
        return new Candidate(name, birthday, gender, email, address, linkedin, phoneNumber, educationalInformationList, professionalInformationList);
    }
}
