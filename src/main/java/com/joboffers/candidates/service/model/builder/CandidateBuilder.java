package com.joboffers.candidates.service.model.builder;

import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.ProfessionalInformation;

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

    public CandidateBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CandidateBuilder withBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public CandidateBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public CandidateBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public CandidateBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public CandidateBuilder withLinkedin(String linkedin) {
        this.linkedin = linkedin;
        return this;
    }

    public CandidateBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CandidateBuilder withEducationalInformationList(List<EducationalInformation> educationalInformationList) {
        this.educationalInformationList = educationalInformationList;
        return this;
    }

    public CandidateBuilder withProfessionalInformationList(List<ProfessionalInformation> professionalInformationList) {
        this.professionalInformationList = professionalInformationList;
        return this;
    }

    public Candidate build() {
        return new Candidate(name, birthday, gender, email, address, linkedin, phoneNumber, educationalInformationList, professionalInformationList);
    }
}
