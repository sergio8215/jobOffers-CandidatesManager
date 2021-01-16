package com.joboffers.candidates.service;

import com.joboffers.candidates.TestObjectFactory;
import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.ProfessionalInformation;
import com.joboffers.candidates.service.model.Technology;
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
    void calculateExperience_givenAnExistingCandidateWithNoPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithEducationalInformation() {
        final Technology technology = new Technology("java");
        final List<Technology> uniTechnologies = new ArrayList<>();
        uniTechnologies.add(technology);

        final EducationalInformation educationalInformation = TestObjectFactory.createEducationalInformation(
                LocalDate.of(2015, 1, 1),
                LocalDate.of(2019, 1, 1),
                uniTechnologies
        );

        final List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation);
        final Candidate candidate = TestObjectFactory.createCandidate(educationalInformationList, Collections.emptyList());

        final Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(48, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidateWithPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithEducationalInformation() {
        final Technology technology = new Technology("java");
        final List<Technology> uniTechnologies = new ArrayList<>();
        uniTechnologies.add(technology);
        final EducationalInformation educationalInformation1 = TestObjectFactory.createEducationalInformation(
                LocalDate.of(2015, 1, 1),
                LocalDate.of(2019, 1, 1),
                uniTechnologies
        );
        final EducationalInformation educationalInformation2 = TestObjectFactory.createEducationalInformation(
                LocalDate.of(2019, 1, 1),
                LocalDate.of(2020, 1, 1),
                uniTechnologies
        );

        final List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation1);
        educationalInformationList.add(educationalInformation2);
        final Candidate candidate = TestObjectFactory.createCandidate(educationalInformationList, Collections.emptyList());

        final Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(60, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidate_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalAndEducationalInformation() {
        final Technology technology = new Technology("Java");
        final List<Technology> technologyList = new ArrayList<>();
        technologyList.add(technology);

        final ProfessionalInformation professionalInformation = TestObjectFactory.createProfessionalInformation(
                LocalDate.of(2010, 1, 1),
                LocalDate.of(2020, 1, 1),
                technologyList
        );

        final EducationalInformation educationalInformation = TestObjectFactory.createEducationalInformation(
                LocalDate.of(2015, 1, 1),
                LocalDate.of(2019, 1, 1),
                technologyList
        );

        final List<EducationalInformation> educationalInformationList = new ArrayList<>();
        educationalInformationList.add(educationalInformation);
        final List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation);

        final Candidate candidate = TestObjectFactory.createCandidate(educationalInformationList, professionalInformationList);

        final Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(168, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidateWithNoPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalInformation() {
        final Technology technology = new Technology("Java");
        final List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);

        final ProfessionalInformation professionalInformation = TestObjectFactory.createProfessionalInformation(
                LocalDate.of(2010, 1, 1),
                LocalDate.of(2020, 1, 1),
                jobTechnologies
        );

        final List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation);
        final Candidate candidate = TestObjectFactory.createCandidate(Collections.emptyList(), professionalInformationList);

        final Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(120, monthsOfExperience.get("java"));
    }

    @Test
    void calculateExperience_givenAnExistingCandidateWithPastExperience_whenCalculateExperienceIsTriggered_thenCalculateItWithProfessionalInformation() {
        final Technology technology = new Technology("Java"); // TODO: Crear test con candidate null
        final List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);
        final ProfessionalInformation professionalInformation1 = TestObjectFactory.createProfessionalInformation(
                LocalDate.of(2010, 1, 1),
                LocalDate.of(2020, 1, 1),
                jobTechnologies
        );

        final ProfessionalInformation professionalInformation2 = TestObjectFactory.createProfessionalInformation(
                LocalDate.of(2020, 1, 1),
                LocalDate.of(2021, 1, 1),
                jobTechnologies
        );

        final List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation1);
        professionalInformationList.add(professionalInformation2);
        final Candidate candidate = TestObjectFactory.createCandidate(Collections.emptyList(), professionalInformationList);

        final Map<String, Integer> monthsOfExperience = underTest.calculateExperience(candidate);
        assertEquals(132, monthsOfExperience.get("java"));
    }

    @Test
    void findCandidatesWithTechnologyExperience_givenAnExistingCandidate_whenFindCandidatesWithTechnologyExperienceIsTriggered_thenCalculateItWithProfessionalInformation() {
        final Technology technology = new Technology("java");
        final List<Technology> jobTechnologies = new ArrayList<>();
        jobTechnologies.add(technology);
        final ProfessionalInformation professionalInformation = TestObjectFactory.createProfessionalInformation(
                LocalDate.of(2010, 1, 1),
                LocalDate.of(2020, 1, 1),
                jobTechnologies
        );

        final List<ProfessionalInformation> professionalInformationList = new ArrayList<>();
        professionalInformationList.add(professionalInformation);

        final Candidate candidate1 = TestObjectFactory.createCandidate(Collections.emptyList(), professionalInformationList);
        final Candidate candidate2 = TestObjectFactory.createCandidate(Collections.emptyList(), professionalInformationList);

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
