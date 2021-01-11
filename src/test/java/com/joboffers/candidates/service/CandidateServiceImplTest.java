package com.joboffers.candidates.service;

import com.joboffers.candidates.service.model.builder.CandidateBuilder;
import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.Gender;
import com.joboffers.candidates.domain.repository.CandidateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.empty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    void createCandidate_givenACandidateData_whenCreateCandidateIsTriggered_thenCreatesANewCandidate() {

        Candidate candidate = CandidateBuilder.aCandidate()
                .build();

        CandidateEntity candidateEntity = new CandidateEntity();
        candidateEntity.setId(UUID.randomUUID());

        when(conversionService.convert(candidate, CandidateEntity.class))
                .thenReturn(candidateEntity);
        when(candidateRepository.save(candidateEntity))
                .thenReturn(candidateEntity);

        UUID candidateId = underTest.createCandidate(candidate);

        verify(conversionService).convert(candidate, CandidateEntity.class);
        verify(candidateRepository).save(candidateEntity);
        verifyNoMoreInteractions(candidateRepository, conversionService);
        assertThat(candidateId).isEqualTo(candidateEntity.getId());
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

        UUID id = UUID.randomUUID();
        CandidateEntity candidateEntity = new CandidateEntity();
        Candidate candidate = CandidateBuilder.aCandidate()
                .build();

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

        UUID id = UUID.randomUUID();
        when(candidateRepository.findById(id))
                .thenReturn(empty());

        assertThat(underTest.getCandidate(id)).isEmpty();
        verify(candidateRepository).findById(id);
        verifyNoMoreInteractions(candidateRepository);
        verifyNoInteractions(conversionService);
    }

    @Test
    void getCandidate_givenANullId_whenGetCandidateByIdIsTriggered_thenThrowIllegalArgumentException() {

        assertThatThrownBy(() -> underTest.getCandidate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Candidate id can't be null");

        verifyNoInteractions(candidateRepository, conversionService);
    }

}