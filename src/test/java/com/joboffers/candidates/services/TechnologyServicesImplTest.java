package com.joboffers.candidates.services;

import com.joboffers.candidates.domain.builders.CandidateBuilder;
import com.joboffers.candidates.domain.builders.EducationalInformationBuilder;
import com.joboffers.candidates.domain.builders.ProfessionalInformationBuilder;
import com.joboffers.candidates.domain.models.Candidate;
import com.joboffers.candidates.domain.models.EducationalInformation;
import com.joboffers.candidates.domain.models.Gender;
import com.joboffers.candidates.domain.models.ProfessionalInformation;
import com.joboffers.candidates.domain.models.Technology;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TechnologyServicesImplTest {


    @Test
    void calculateExperience_givenAnExistingCandidateWithNoPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithEducationalInformation(){
        Technology technology = new Technology("java");
        List<Technology> uniTechnologies = new ArrayList<>();
        uniTechnologies.add(technology);
        EducationalInformation educationalInformation = new EducationalInformationBuilder()
                .setName("University")
                .setDescription("Informatics Engineering")
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
    void calculateExperience_givenAnExistingCandidateWithPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithEducationalInformation(){
        Technology technology = new Technology("java");
        List<Technology> uniTechnologies = new ArrayList<>();
        uniTechnologies.add(technology);
        EducationalInformation educationalInformation1 = new EducationalInformationBuilder()
                .setName("University")
                .setDescription("Informatics Engineering")
                .setStartDate(LocalDate.of(2015,1,1))
                .setEndDate(LocalDate.of(2019,1,1))
                .setCourse("Java programming")
                .setPlace("UPC")
                .setTechnologyList(uniTechnologies)
                .build();

        EducationalInformation educationalInformation2 = new EducationalInformationBuilder()
                .setName("University")
                .setDescription("Informatics Engineering")
                .setStartDate(LocalDate.of(2019,1,1))
                .setEndDate(LocalDate.of(2020,1,1))
                .setCourse("Java programming 2")
                .setPlace("UPC")
                .setTechnologyList(uniTechnologies)
                .build();

        List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation1);
        educationalInformationList.add(educationalInformation2);
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
        assertEquals(60, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidate_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalAndEducationalInformation(){
        Technology technology = new Technology("Java");
        List<Technology> technologyList = new ArrayList<>();
        technologyList.add(technology);
        ProfessionalInformation professionalInformation = ProfessionalInformationBuilder.aProfessionalInformation()
                .setName("First company job")
                .setDescription("Informatics Engineering at a consultant company")
                .setStartDate(LocalDate.of(2010, 1,1))
                .setEndDate(LocalDate.of(2020,1,1))
                .setNotes("Working as a Java programmer for 10 years")
                .setTechnologyList(technologyList)
                .build();

        EducationalInformation educationalInformation = new EducationalInformationBuilder()
                .setName("University")
                .setDescription("Informatics Engineering")
                .setStartDate(LocalDate.of(2015,1,1))
                .setEndDate(LocalDate.of(2019,1,1))
                .setCourse("Java programming")
                .setPlace("UPC")
                .setTechnologyList(technologyList)
                .build();

        List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation);
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
                .setEducationalInformationList(educationalInformationList)
                .setProfessionalInformationList(professionalInformationList)
                .build();

        Map<String, Integer> monthsOfExperience = Technology.calculateExperience(candidate);
        assertEquals(168, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidateWithNoPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalInformation(){
        Technology technology = new Technology("Java");
        List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);
        ProfessionalInformation professionalInformation = ProfessionalInformationBuilder.aProfessionalInformation()
                .setName("First company job")
                .setDescription("Informatics Engineering at a consultant company")
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

    @Test
    void calculateExperience_givenAnExistingCandidateWithPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalInformation(){
        Technology technology = new Technology("Java");
        List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);
        ProfessionalInformation professionalInformation1 = ProfessionalInformationBuilder.aProfessionalInformation()
                .setName("First company job")
                .setDescription("Informatics Engineering at a consultant company")
                .setStartDate(LocalDate.of(2010, 1,1))
                .setEndDate(LocalDate.of(2020,1,1))
                .setNotes("Working as a Java programmer for 10 years")
                .setTechnologyList(jobTechnologies)
                .build();

        ProfessionalInformation professionalInformation2 = ProfessionalInformationBuilder.aProfessionalInformation()
                .setName("Second company job")
                .setDescription("Informatics Engineering")
                .setStartDate(LocalDate.of(2020, 1,1))
                .setEndDate(LocalDate.of(2021,1,1))
                .setNotes("Working as a Java programmer")
                .setTechnologyList(jobTechnologies)
                .build();


        List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation1);
        professionalInformationList.add(professionalInformation2);
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
        assertEquals(132, monthsOfExperience.get("java"));
    }

    @Test
    void findCandidatesWithTechnologyExperience_givenAnExistingCandidate_whenFindCandidatesWithTechnologyExperienceIsTriggered_thenCalculateItWithProfessionalInformation(){
        Technology technology = new Technology("java");
        List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);

        ProfessionalInformation professionalInformation = ProfessionalInformationBuilder.aProfessionalInformation()
                .setName("First company job")
                .setDescription("Informatics Engineering at a consultant company")
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
