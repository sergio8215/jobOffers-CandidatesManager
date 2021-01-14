package com.joboffers.candidates.service;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.domain.repository.CandidateRepository;
import com.joboffers.candidates.service.model.Candidate;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final ConversionService conversionService;

    CandidateServiceImpl(final CandidateRepository candidateRepository, final ConversionService conversionService) {
        this.candidateRepository = candidateRepository;
        this.conversionService = conversionService;
    }

    @Override
    public UUID createCandidate(final Candidate candidate) {

        if (isNull(candidate)) {
            throw new IllegalArgumentException("Candidate can't be null");
        }

        final CandidateEntity candidateEntity = conversionService.convert(candidate, CandidateEntity.class);
        return candidateRepository.save(candidateEntity).getId();
    }

    @Override
    public Optional<Candidate> getCandidate(final UUID id) {

        if (isNull(id)) {
            throw new IllegalArgumentException("Candidate id can't be null");
        }

        return candidateRepository.findById(id).map(candidateEntity -> conversionService.convert(candidateEntity, Candidate.class));
    }

    @Override
    public List<Candidate> getListOfCandidatesByTechnology(final String technologyName) {

        if (isNull(technologyName)) {
            throw new IllegalArgumentException("Technology name can't be null");
        }

        return candidateRepository.findByTechnology(technologyName)
                .stream().map(candidateEntity ->
                        conversionService.convert(candidateEntity, Candidate.class)
                ).collect(Collectors.toList());
    }
}