package com.joboffers.candidates.service;

import com.joboffers.candidates.service.model.builder.CandidateBuilder;
import com.joboffers.candidates.service.model.builder.EducationalInformationBuilder;
import com.joboffers.candidates.service.model.builder.ProfessionalInformationBuilder;
import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.Gender;
import com.joboffers.candidates.service.model.ProfessionalInformation;
import com.joboffers.candidates.service.model.Technology;
import com.joboffers.candidates.domain.repository.CandidateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TechnologyServicesImplTest {

    @InjectMocks
    private TechnologyServicesImpl underTest;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private ConversionService conversionService;

    @Test
    void calculateExperience_givenAnExistingCandidateWithNoPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithEducationalInformation(){
        Technology technology = new Technology("java");
        List<Technology> uniTechnologies = new ArrayList<>();
        uniTechnologies.add(technology);
        EducationalInformation educationalInformation = EducationalInformationBuilder.anEducationalInformation()
                .withName("University")
                .withDescription("Informatics Engineering")
                .withStartDate(LocalDate.of(2015,1,1))
                .withEndDate(LocalDate.of(2019,1,1))
                .withCourse("Java programming")
                .withPlace("UPC")
                .withTechnologyList(uniTechnologies)
                .build();

        List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation);
        Candidate candidate = CandidateBuilder.aCandidate()
                .withName("Patricia")
                .withBirthday(LocalDate.of(1990,10,10))
                .withGender(Gender.WOMAN)
                .withEmail("patricia@candidate.com")
                .withAddress("Valencia 124")
                .withLinkedin("linkedin.com/patricia")
                .withPhoneNumber("6223344")
                .withEducationalInformationList(educationalInformationList)
                .withProfessionalInformationList(Collections.emptyList())
                .build();

        Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(48, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidateWithPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithEducationalInformation(){
        Technology technology = new Technology("java");
        List<Technology> uniTechnologies = new ArrayList<>();
        uniTechnologies.add(technology);
        EducationalInformation educationalInformation1 = EducationalInformationBuilder.anEducationalInformation()
                .withName("University")
                .withDescription("Informatics Engineering")
                .withStartDate(LocalDate.of(2015,1,1))
                .withEndDate(LocalDate.of(2019,1,1))
                .withCourse("Java programming")
                .withPlace("UPC")
                .withTechnologyList(uniTechnologies)
                .build();

        EducationalInformation educationalInformation2 = EducationalInformationBuilder.anEducationalInformation()
                .withName("University")
                .withDescription("Informatics Engineering")
                .withStartDate(LocalDate.of(2019,1,1))
                .withEndDate(LocalDate.of(2020,1,1))
                .withCourse("Java programming 2")
                .withPlace("UPC")
                .withTechnologyList(uniTechnologies)
                .build();

        List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation1);
        educationalInformationList.add(educationalInformation2);
        Candidate candidate = CandidateBuilder.aCandidate() // TODO otra forma de hacer el builder, cual es mejor?
                .withName("Patricia")
                .withBirthday(LocalDate.of(1990,10,10))
                .withGender(Gender.WOMAN)
                .withEmail("patricia@candidate.com")
                .withAddress("Valencia 124")
                .withLinkedin("linkedin.com/patricia")
                .withPhoneNumber("6223344")
                .withEducationalInformationList(educationalInformationList)
                .withProfessionalInformationList(Collections.emptyList())
                .build();

        Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(60, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidate_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalAndEducationalInformation(){
        Technology technology = new Technology("Java");
        List<Technology> technologyList = new ArrayList<>();
        technologyList.add(technology);
        ProfessionalInformation professionalInformation = ProfessionalInformationBuilder.aProfessionalInformation()
                .withName("First company job")
                .withDescription("Informatics Engineering at a consultant company")
                .withStartDate(LocalDate.of(2010, 1,1))
                .withEndDate(LocalDate.of(2020,1,1))
                .withNotes("Working as a Java programmer for 10 years")
                .withTechnologyList(technologyList)
                .build();

        EducationalInformation educationalInformation = EducationalInformationBuilder.anEducationalInformation()
                .withName("University")
                .withDescription("Informatics Engineering")
                .withStartDate(LocalDate.of(2015,1,1))
                .withEndDate(LocalDate.of(2019,1,1))
                .withCourse("Java programming")
                .withPlace("UPC")
                .withTechnologyList(technologyList)
                .build();

        List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation);
        List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation);
        Candidate candidate = CandidateBuilder.aCandidate()
                .withName("Jose")
                .withBirthday(LocalDate.of(1990,10,10))
                .withGender(Gender.MAN)
                .withEmail("patricia@candidate.com")
                .withAddress("Valencia 124")
                .withLinkedin("linkedin.com/patricia")
                .withPhoneNumber("6223344")
                .withEducationalInformationList(educationalInformationList)
                .withProfessionalInformationList(professionalInformationList)
                .build();

        Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(168, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidateWithNoPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalInformation(){
        Technology technology = new Technology("Java");
        List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);
        ProfessionalInformation professionalInformation = ProfessionalInformationBuilder.aProfessionalInformation()
                .withName("First company job")
                .withDescription("Informatics Engineering at a consultant company")
                .withStartDate(LocalDate.of(2010, 1,1))
                .withEndDate(LocalDate.of(2020,1,1))
                .withNotes("Working as a Java programmer for 10 years")
                .withTechnologyList(jobTechnologies)
                .build();

        List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation);
        Candidate candidate = CandidateBuilder.aCandidate()
                .withName("Jose")
                .withBirthday(LocalDate.of(1990,10,10))
                .withGender(Gender.MAN)
                .withEmail("patricia@candidate.com")
                .withAddress("Valencia 124")
                .withLinkedin("linkedin.com/patricia")
                .withPhoneNumber("6223344")
                .withEducationalInformationList(Collections.emptyList())
                .withProfessionalInformationList(professionalInformationList)
                .build();

        Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(120, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidateWithPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalInformation(){
        Technology technology = new Technology("Java");
        List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);
        ProfessionalInformation professionalInformation1 = ProfessionalInformationBuilder.aProfessionalInformation()
                .withName("First company job")
                .withDescription("Informatics Engineering at a consultant company")
                .withStartDate(LocalDate.of(2010, 1,1))
                .withEndDate(LocalDate.of(2020,1,1))
                .withNotes("Working as a Java programmer for 10 years")
                .withTechnologyList(jobTechnologies)
                .build();

        ProfessionalInformation professionalInformation2 = ProfessionalInformationBuilder.aProfessionalInformation()
                .withName("Second company job")
                .withDescription("Informatics Engineering")
                .withStartDate(LocalDate.of(2020, 1,1))
                .withEndDate(LocalDate.of(2021,1,1))
                .withNotes("Working as a Java programmer")
                .withTechnologyList(jobTechnologies)
                .build();


        List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation1);
        professionalInformationList.add(professionalInformation2);
        Candidate candidate = CandidateBuilder.aCandidate()
                .withName("Jose")
                .withBirthday(LocalDate.of(1990,10,10))
                .withGender(Gender.MAN)
                .withEmail("patricia@candidate.com")
                .withAddress("Valencia 124")
                .withLinkedin("linkedin.com/patricia")
                .withPhoneNumber("6223344")
                .withEducationalInformationList(Collections.emptyList())
                .withProfessionalInformationList(professionalInformationList)
                .build();

        Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(132, monthsOfExperience.get("java"));
    }

    @Test
    void findCandidatesWithTechnologyExperience_givenAnExistingCandidate_whenFindCandidatesWithTechnologyExperienceIsTriggered_thenCalculateItWithProfessionalInformation(){
        Technology technology = new Technology("java");
        List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);

        ProfessionalInformation professionalInformation = ProfessionalInformationBuilder.aProfessionalInformation()
                .withName("First company job")
                .withDescription("Informatics Engineering at a consultant company")
                .withStartDate(LocalDate.of(2010,1,1))
                .withEndDate(LocalDate.of(2020,1,1))
                .withNotes("Working as a Java programmer for 10 years")
                .withTechnologyList(jobTechnologies)
                .build();

        List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation);
        Candidate candidate = CandidateBuilder.aCandidate()
                .withName("Jose")
                .withBirthday(LocalDate.of(1990,10,10))
                .withGender(Gender.MAN)
                .withEmail("jose@candidate.com")
                .withAddress("Valencia 124")
                .withLinkedin("linkedin.com/jose")
                .withPhoneNumber("6223344")
                .withEducationalInformationList(Collections.emptyList())
                .withProfessionalInformationList(professionalInformationList)
                .build();


        List<Candidate> candidates = underTest.findCandidatesWithTechnologyExperience("java");
        assertEquals(0, candidates.size());
    }
}
