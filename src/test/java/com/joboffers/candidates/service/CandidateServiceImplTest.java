package com.joboffers.candidates.service;

import com.joboffers.candidates.TestObjectFactory;
import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.domain.entity.EducationalInformationEntity;
import com.joboffers.candidates.domain.entity.TechnologyEntity;
import com.joboffers.candidates.domain.repository.CandidateRepository;
import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.Technology;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.List.of;
import static java.util.Optional.empty;
import static javax.swing.SortOrder.UNSORTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CandidateServiceImplTest {

    @InjectMocks
    private CandidateServiceImpl underTest;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private ConversionService conversionService;

    String TECHNOLOGY_NAME = "java";

    @Test
    void createCandidate_givenACandidateData_whenCreateCandidateIsTriggered_thenCreatesANewCandidate() {

        final Candidate candidate = TestObjectFactory.createEmptyCandidate();
        final CandidateEntity candidateEntity = TestObjectFactory.createEmptyCandidateEntity();

        when(conversionService.convert(candidate, CandidateEntity.class))
                .thenReturn(candidateEntity);
        when(candidateRepository.save(candidateEntity))
                .thenReturn(candidateEntity);

        final CandidateEntity candidateId = underTest.createCandidate(candidate);

        verify(conversionService).convert(candidate, CandidateEntity.class);
        verify(candidateRepository).save(candidateEntity);
        verifyNoMoreInteractions(candidateRepository, conversionService);
        //assertThat(candidateId).isEqualTo(candidateEntity.getId());
    }

    @Test
    void createCandidate_givenANullCandidate_whenCreateCandidateIsTriggered_thenReturnEmptyOptional() {

        assertThatThrownBy(() -> underTest.createCandidate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Candidate can't be null");

        verifyNoInteractions(candidateRepository, conversionService);
    }

    @Test
    void getCandidate_givenAnExistingCandidate_whenGetCandidateByIdIsTriggered_thenACandidateIsReturned() {

        final CandidateEntity candidateEntity = TestObjectFactory.createEmptyCandidateEntity();
        final Candidate candidate = TestObjectFactory.createEmptyCandidate();
        final long id = candidateEntity.getId();

        when(candidateRepository.findById(id))
                .thenReturn(Optional.of(candidateEntity));
        when(conversionService.convert(candidateEntity, Candidate.class))
                .thenReturn(candidate);

        assertThat(underTest.getCandidate(id)).hasValue(candidate);
        verify(candidateRepository).findById(id);
        verify(conversionService).convert(candidateEntity, Candidate.class);
        verifyNoMoreInteractions(conversionService, candidateRepository);
    }

    @Test
    void getCandidate_givenANonExistingCandidate_whenGetCandidateByIdIsTriggered_thenReturnEmptyOptional() {

        final long id = 1L;
        when(candidateRepository.findById(id))
                .thenReturn(empty());

        assertThat(underTest.getCandidate(id)).isEmpty();
        verify(candidateRepository).findById(id);
        verifyNoMoreInteractions(candidateRepository);
        verifyNoInteractions(conversionService);
    }

    @Test
    @Disabled("Draft")
    void getListOfCandidatesByTechnology_givenATechnologyName_whenGetListOfCandidatesByTechnologyIsTriggered_thenReturnAListOfCandidatesThatHasExperienceWithTheTechnology() {

        final TechnologyEntity technologyEntity = TechnologyEntity.builder()
                .technology(TECHNOLOGY_NAME)
                .build();

        final EducationalInformationEntity educationalInformationEntity = EducationalInformationEntity.builder()
                .technologyList(of(technologyEntity))
                .build();

        final CandidateEntity candidateEntity = TestObjectFactory.createCandidateEntity(
                of(educationalInformationEntity), emptyList());

        final Technology technology = new Technology(TECHNOLOGY_NAME);

        final EducationalInformation educationalInformation = TestObjectFactory.createEducationalInformation(
                LocalDate.of(2015, 1, 1),
                LocalDate.of(2019, 1, 1),
                of(technology)
        );

        final Candidate candidate = TestObjectFactory.createCandidate(
                of(educationalInformation), emptyList());

        //when(candidateRepository.findByTechnology(TECHNOLOGY_NAME))
        //        .thenReturn(of(candidateEntity));
        when(conversionService.convert(candidateEntity, Candidate.class))
                .thenReturn(candidate);

        final List<Candidate> candidateList = underTest.getListOfCandidatesByTechnologyOrderedByExperience(TECHNOLOGY_NAME, UNSORTED);
        assertThat(candidateList.size()).isEqualTo(1);
        //verify(candidateRepository).findByTechnology(TECHNOLOGY_NAME);
        verify(conversionService).convert(candidateEntity, Candidate.class);
        verifyNoMoreInteractions(candidateRepository, conversionService);
    }

    @Test
    void getListOfCandidatesByTechnology_givenATechnologyName_whenGetListOfCandidatesByTechnologyIsTriggered_thenReturnAnEmptyListOfCandidates() {

        //when(candidateRepository.findByTechnology(TECHNOLOGY_NAME))
        //      .thenReturn(of());

        final List<Candidate> candidateList = underTest.getListOfCandidatesByTechnologyOrderedByExperience(TECHNOLOGY_NAME, UNSORTED);
        assertThat(candidateList.size()).isZero();
        //verify(candidateRepository).findByTechnology(TECHNOLOGY_NAME);
        verifyNoMoreInteractions(conversionService);
    }

    @Test
    @Disabled("Draft")
    void getListOfCandidatesByTechnology_givenAnEmptyName_whenGetListOfCandidatesByTechnologyIsTriggered_thenReturnAnIllegalArgumentException() {

        assertThatThrownBy(() -> underTest.getListOfCandidatesByTechnologyOrderedByExperience(null, UNSORTED))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Technology name can't be null");

        verifyNoInteractions(candidateRepository, conversionService);
    }
}