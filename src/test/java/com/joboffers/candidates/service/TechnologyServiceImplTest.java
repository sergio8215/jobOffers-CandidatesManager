package com.joboffers.candidates.service;

import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.Gender;
import com.joboffers.candidates.service.model.ProfessionalInformation;
import com.joboffers.candidates.service.model.Technology;
import com.joboffers.candidates.service.model.builder.CandidateBuilder;
import com.joboffers.candidates.service.model.builder.EducationalInformationBuilder;
import com.joboffers.candidates.service.model.builder.ProfessionalInformationBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TechnologyServiceImplTest {

    @InjectMocks
    private TechnologyServiceImpl underTest;

    @Mock
    private CandidateService candidateService;

    @Test
        // TODO crear testObjectFactory, clase final con contructor privado y todos los metodos static.
    void calculateExperience_givenAnExistingCandidateWithNoPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithEducationalInformation() {
        final Technology technology = new Technology("java");
        final List<Technology> uniTechnologies = new ArrayList<>();
        uniTechnologies.add(technology);
        final EducationalInformation educationalInformation = EducationalInformationBuilder.anEducationalInformation()
                .withName("University")
                .withDescription("Informatics Engineering")
                .withStartDate(LocalDate.of(2015, 1, 1))
                .withEndDate(LocalDate.of(2019, 1, 1))
                .withCourse("Java programming")
                .withPlace("UPC")
                .withTechnologyList(uniTechnologies)
                .build();

        final List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation);
        final Candidate candidate = CandidateBuilder.aCandidate()
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

        final Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(48, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidateWithPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithEducationalInformation(){
        final Technology technology = new Technology("java");
        final List<Technology> uniTechnologies = new ArrayList<>();
        uniTechnologies.add(technology);
        final EducationalInformation educationalInformation1 = EducationalInformationBuilder.anEducationalInformation()
                .withName("University")
                .withDescription("Informatics Engineering")
                .withStartDate(LocalDate.of(2015,1,1))
                .withEndDate(LocalDate.of(2019,1,1))
                .withCourse("Java programming")
                .withPlace("UPC")
                .withTechnologyList(uniTechnologies)
                .build();

        final EducationalInformation educationalInformation2 = EducationalInformationBuilder.anEducationalInformation()
                .withName("University")
                .withDescription("Informatics Engineering")
                .withStartDate(LocalDate.of(2019,1,1))
                .withEndDate(LocalDate.of(2020,1,1))
                .withCourse("Java programming 2")
                .withPlace("UPC")
                .withTechnologyList(uniTechnologies)
                .build();

        final List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation1);
        educationalInformationList.add(educationalInformation2);
        final Candidate candidate = CandidateBuilder.aCandidate() // TODO otra forma de hacer el builder, cual es mejor?
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

        final Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(60, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidate_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalAndEducationalInformation(){
        final Technology technology = new Technology("Java");
        final List<Technology> technologyList = new ArrayList<>();
        technologyList.add(technology);
        final ProfessionalInformation professionalInformation = ProfessionalInformationBuilder.aProfessionalInformation()
                .withName("First company job")
                .withDescription("Informatics Engineering at a consultant company")
                .withStartDate(LocalDate.of(2010, 1,1))
                .withEndDate(LocalDate.of(2020,1,1))
                .withNotes("Working as a Java programmer for 10 years")
                .withTechnologyList(technologyList)
                .build();

        final EducationalInformation educationalInformation = EducationalInformationBuilder.anEducationalInformation()
                .withName("University")
                .withDescription("Informatics Engineering")
                .withStartDate(LocalDate.of(2015,1,1))
                .withEndDate(LocalDate.of(2019,1,1))
                .withCourse("Java programming")
                .withPlace("UPC")
                .withTechnologyList(technologyList)
                .build();

        final List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation);
        final List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation);
        final Candidate candidate = CandidateBuilder.aCandidate()
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

        final Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(168, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidateWithNoPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalInformation(){
        final Technology technology = new Technology("Java");
        final List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);
        final ProfessionalInformation professionalInformation = ProfessionalInformationBuilder.aProfessionalInformation()
                .withName("First company job")
                .withDescription("Informatics Engineering at a consultant company")
                .withStartDate(LocalDate.of(2010, 1,1))
                .withEndDate(LocalDate.of(2020,1,1))
                .withNotes("Working as a Java programmer for 10 years")
                .withTechnologyList(jobTechnologies)
                .build();

        final List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation);
        final Candidate candidate = CandidateBuilder.aCandidate()
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

        final Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(120, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidateWithPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalInformation(){
        final Technology technology = new Technology("Java"); // TODO: Crear test con candidate null
        final List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);
        final ProfessionalInformation professionalInformation1 = ProfessionalInformationBuilder.aProfessionalInformation()
                .withName("First company job")
                .withDescription("Informatics Engineering at a consultant company")
                .withStartDate(LocalDate.of(2010, 1,1))
                .withEndDate(LocalDate.of(2020,1,1))
                .withNotes("Working as a Java programmer for 10 years")
                .withTechnologyList(jobTechnologies)
                .build();

        final ProfessionalInformation professionalInformation2 = ProfessionalInformationBuilder.aProfessionalInformation()
                .withName("Second company job")
                .withDescription("Informatics Engineering")
                .withStartDate(LocalDate.of(2020, 1,1))
                .withEndDate(LocalDate.of(2021,1,1))
                .withNotes("Working as a Java programmer")
                .withTechnologyList(jobTechnologies)
                .build();


        final List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation1);
        professionalInformationList.add(professionalInformation2);
        final Candidate candidate = CandidateBuilder.aCandidate()
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

        final Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(132, monthsOfExperience.get("java"));
    }

    @Test
    void findCandidatesWithTechnologyExperience_givenAnExistingCandidate_whenFindCandidatesWithTechnologyExperienceIsTriggered_thenCalculateItWithProfessionalInformation(){
        final Technology technology = new Technology("java");
        final List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);

        final ProfessionalInformation professionalInformation = ProfessionalInformationBuilder.aProfessionalInformation()
                .withName("First company job")
                .withDescription("Informatics Engineering at a consultant company")
                .withStartDate(LocalDate.of(2010, 1, 1))
                .withEndDate(LocalDate.of(2020, 1, 1))
                .withNotes("Working as a Java programmer for 10 years")
                .withTechnologyList(jobTechnologies)
                .build();

        final List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation);
        final Candidate candidate1 = CandidateBuilder.aCandidate()
                .withName("Jose")
                .withProfessionalInformationList(professionalInformationList)
                .build();

        final Candidate candidate2 = CandidateBuilder.aCandidate()
                .withName("Maria")
                .withProfessionalInformationList(professionalInformationList)
                .build();

        final List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate1);
        candidateList.add(candidate2);

        when(candidateService.getListOfCandidatesByTechnology("java"))
                .thenReturn(candidateList);

        final List<Candidate> candidates = underTest.findCandidatesWithTechnologyExperience("java");
        assertEquals(2, candidates.size());
        verify(candidateService).getListOfCandidatesByTechnology("java");
        verifyNoMoreInteractions(candidateService);
    }
}
