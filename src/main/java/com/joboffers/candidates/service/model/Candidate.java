package com.joboffers.candidates.service.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Candidate {

    private String name;
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate birthday;
    private String gender;
    private String email;
    private String address;
    private String linkedin;
    private String phoneNumber;
    private List<EducationalInformation> educationalInformationList = List.of();
    private List<ProfessionalInformation> professionalInformationList = List.of();

    public Candidate() {
    }

    public Candidate(final String name,
                     final LocalDate birthday,
                     final String gender,
                     final String email,
                     final String address,
                     final String linkedin,
                     final String phoneNumber,
                     final List<EducationalInformation> educationalInformationList,
                     final List<ProfessionalInformation> professionalInformationList
    ) {
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
}
