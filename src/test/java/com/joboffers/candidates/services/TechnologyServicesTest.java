package com.joboffers.candidates.services;

import com.joboffers.candidates.builders.CandidateBuilder;
import com.joboffers.candidates.builders.EducationalInformationBuilder;
import com.joboffers.candidates.builders.ProfessionalInformationBuilder;
import com.joboffers.candidates.models.Candidate;
import com.joboffers.candidates.models.EducationalInformation;
import com.joboffers.candidates.models.Gender;
import com.joboffers.candidates.models.ProfessionalInformation;
import com.joboffers.candidates.models.Technology;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TechnologyServicesTest {

    @Test
    void calculateExperience_givenAnExistingCandidate_whenCalculateExperienceIsTriggered_thenCalculateItWithEducationalInformation(){
        Technology technology = new Technology("java");
        List<Technology> uniTechnologies = new ArrayList<>();
        uniTechnologies.add(technology);
        EducationalInformation educationalInformation = new EducationalInformationBuilder()
                .setName("Univerity")
                .setDescription("Informatic Engineering")
                .setStartDate(LocalDate.of(2015,1,1))
                .setEndDate(LocalDate.of(2019,1,1))
                .setCourse("Java programming")
                .setPlace("UPC")
                .setTechnologyList(uniTechnologies)
                .build();

        List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation);
        Candidate candidate = CandidateBuilder.aCandidate() // TODO otra forma de hacer el builder, cual es mejor?
                .setName("Patricia")
                .setBirthday(LocalDate.of(1990,10,10))
                .setGender(Gender.WOMAN)
                .setEmail("patricia@candidate.com")
                .setAddress("Valencia 124")
                .setLinkedin("linkedin.com/patricia")
                .setPhoneNumber("6223344")
                .setEducationalInformationList(educationalInformationList)
                .setProfessionalInformationList(Collections.emptyList())
                .build();

        Map<String, Integer> monthsOfExperience = Technology.calculateExperience(candidate);
        assertEquals(48, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidate_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalInformation(){
        Technology technology = new Technology("Java");
        List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);
        ProfessionalInformation professionalInformation = ProfessionalInformationBuilder.aProfessionalInformation()
                .setName("First company job")
                .setDescription("Informatic Engineering at a consultant company")
                .setStartDate(LocalDate.of(2010, 1,1))
                .setEndDate(LocalDate.of(2020,1,1))
                .setNotes("Working as a Java programmer for 10 years")
                .setTechnologyList(jobTechnologies)
                .build();

        List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation);
        Candidate candidate = CandidateBuilder.aCandidate()
                .setName("Jose")
                .setBirthday(LocalDate.of(1990,10,10))
                .setGender(Gender.MAN)
                .setEmail("patricia@candidate.com")
                .setAddress("Valencia 124")
                .setLinkedin("linkedin.com/patricia")
                .setPhoneNumber("6223344")
                .setEducationalInformationList(Collections.emptyList())
                .setProfessionalInformationList(professionalInformationList)
                .build();

        Map<String, Integer> monthsOfExperience = Technology.calculateExperience(candidate);
        assertEquals(120, monthsOfExperience.get("java"));
    }

    // TODO añadir test con los dos casos combinados de educational y professional

    @Test
    void findCandidatesWithTechnologyExperience_givenAnExistingCandidate_whenFindCandidatesWithTechnologyExperienceIsTriggered_thenCalculateItWithProfessionalInformation(){
        Technology technology = new Technology("java");
        List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);

        ProfessionalInformation professionalInformation = ProfessionalInformationBuilder.aProfessionalInformation()
                .setName("First company job")
                .setDescription("Informatic Engineering at a consultant company")
                .setStartDate(LocalDate.of(2010,1,1))
                .setEndDate(LocalDate.of(2020,1,1))
                .setNotes("Working as a Java programmer for 10 years")
                .setTechnologyList(jobTechnologies)
                .build();

        List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation);
        Candidate candidate = CandidateBuilder.aCandidate()
                .setName("Jose")
                .setBirthday(LocalDate.of(1990,10,10))
                .setGender(Gender.MAN)
                .setEmail("jose@candidate.com")
                .setAddress("Valencia 124")
                .setLinkedin("linkedin.com/jose")
                .setPhoneNumber("6223344")
                .setEducationalInformationList(Collections.emptyList())
                .setProfessionalInformationList(professionalInformationList)
                .build();


        List<Candidate> candidates = Technology.findCandidatesWithTechnologyExperience("java");
        assertEquals(0, candidates.size());
    }
}
