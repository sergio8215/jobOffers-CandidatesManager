package com.joboffers.candidates.service;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.domain.repository.CandidateRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.isNull;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final ConversionService conversionService;

    CandidateServiceImpl(CandidateRepository candidateRepository, ConversionService conversionService) {
        this.candidateRepository = candidateRepository;
        this.conversionService = conversionService;
    }

    @Override
    public UUID createCandidate(Candidate candidate) {

        if (isNull(candidate)) {
            throw new IllegalArgumentException("Candidate can't be null");
        }

        CandidateEntity candidateEntity = conversionService.convert(candidate, CandidateEntity.class);
        return candidateRepository.save(candidateEntity).getId();
    }

    @Override
    public Optional<Candidate> getCandidate(UUID id) {

        if (isNull(id)) {
            throw new IllegalArgumentException("Candidate id can't be null");
        }

         return candidateRepository.findById(id).map( candidateEntity -> conversionService.convert(candidateEntity, Candidate.class) );
    }
}
