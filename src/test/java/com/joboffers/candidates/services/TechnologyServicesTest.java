package com.joboffers.candidates.services;

import com.joboffers.candidates.builders.EducationalInformationBuilder;
import com.joboffers.candidates.models.Candidate;
import com.joboffers.candidates.models.EducationalInformation;
import com.joboffers.candidates.models.Gender;
import com.joboffers.candidates.models.ProfessionalInformation;
import com.joboffers.candidates.models.Technology;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TechnologyServicesTest {

    @Test
    public void calculateExperience_givenACandidate_whenWeNeedHisExperience_thenCalculateItWithEducationalInformation(){
        Technology technology = new Technology("Java");
        List<Technology> uniTechnologies = new ArrayList<>();
        uniTechnologies.add(technology);
        EducationalInformation educationalInformation = new EducationalInformationBuilder()
                .setName("Univerity")
                .setDescription("Informatic Engineering")
                .setStartDate(LocalDate.of(2015,01,01))
                .setEndDate(LocalDate.of(2019,01,01))
                .setCourse("Java programming")
                .setPlace("UPC")
                .setTechnologyList(uniTechnologies)
                .build();

        List<EducationalInformation> educationalInformations = new ArrayList<>();
        educationalInformations.add(educationalInformation);
        Candidate candidate = new Candidate(
                "Patricia",
                LocalDate.of(1990,10,10),
                Gender.WOMAN,
                "patricia@candidate.com",
                "Valencia 124",
                "linkedin.com/patricia",
                "6223344",
                educationalInformations,
                null
        );

        int monthsOfExperience = Technology.calculateExperience(candidate);
        assertEquals(0, monthsOfExperience);
    }

    @Test
    public void calculateExperience_givenACandidate_whenWeNeedHisExperience_thenCalculateItWithProfessionalInformation(){
        Technology technology = new Technology("Java");
        List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);
        ProfessionalInformation professionalInformation = new ProfessionalInformation(
                "First company job",
                "Informatic Engineering at a consultant company",
                LocalDate.of(2010,01,01),
                LocalDate.of(2020,01,01),
                "Working as a Java programmer for 10 years",
                jobTechnologies
        );

        List<ProfessionalInformation> professionalInformations = new ArrayList<>();
        professionalInformations.add(professionalInformation);

        Candidate candidate = new Candidate(
                "Jose",
                LocalDate.of(1990,10,10),
                Gender.MAN,
                "patricia@candidate.com",
                "Valencia 124",
                "linkedin.com/patricia",
                "6223344",
                null,
                professionalInformations
        );

        int monthsOfExperience = Technology.calculateExperience(candidate);
        assertEquals(0, monthsOfExperience);
    }

    @Test
    public void findCandidatesWithTechnologyExperience_givenACandidate_whenWeNeedHisExperience_thenCalculateItWithProfessionalInformation(){
        Technology technology = new Technology("Java");
        List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);
        ProfessionalInformation professionalInformation = new ProfessionalInformation(
                "First company job",
                "Informatic Engineering at a consultant company",
                LocalDate.of(2010,01,01),
                LocalDate.of(2020,01,01),
                "Working as a Java programmer for 10 years",
                jobTechnologies
        );

        List<ProfessionalInformation> professionalInformations = new ArrayList<>();
        professionalInformations.add(professionalInformation);
        Candidate candidate = new Candidate(
                "Jose",
                LocalDate.of(1990,10,10),
                Gender.MAN,
                "patricia@candidate.com",
                "Valencia 124",
                "linkedin.com/patricia",
                "6223344",
                null,
                professionalInformations
        );

        List<Candidate> candidates = Technology.findCandidatesWithTechnologyExperience("Java");
        assertEquals(0, candidates.size());
    }
}
