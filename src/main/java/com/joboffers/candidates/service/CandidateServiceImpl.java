package com.joboffers.candidates.service;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.domain.repository.CandidateRepository;
import com.joboffers.candidates.service.model.Candidate;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

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
    public CandidateEntity createCandidate(final Candidate candidate) {

        if (isNull(candidate)) {
            throw new IllegalArgumentException("Candidate can't be null");
        }

        final CandidateEntity candidateEntity = conversionService.convert(candidate, CandidateEntity.class);
        assert candidateEntity != null : "The candidate couldn't be converted";
        return candidateRepository.save(candidateEntity);
    }

    @Override
    public Optional<Candidate> getCandidate(final long id) {

        return candidateRepository.findById(id).map(candidateEntity -> conversionService.convert(candidateEntity, Candidate.class));
    }

    @Override
    public List<Candidate> getListOfCandidatesByTechnologyOrderedByExperience(final String technologyName, final SortOrder sortOrder) {

        /*
        if (isNull(technologyName)) {
            throw new IllegalArgumentException("Technology name can't be null");
        }
        if (isNull(sortOrder)) {
            sortOrder = UNSORTED;
        }

        final List<CandidateEntity> candidateList = candidateRepository.findByTechnology(technologyName);
        switch (sortOrder) {
            case ASCENDING:
                candidateList = candidateRepository.findByTechnologyByOrderAsc(technologyName);
                break;
            case DESCENDING:
                candidateList = candidateRepository.findByTechnologyByOrderDesc(technologyName);
                break;
            default:
                candidateList = candidateRepository.findByTechnology(technologyName);
                break;
        }
        return candidateList
                .stream().map(candidateEntity ->
                        conversionService.convert(candidateEntity, Candidate.class)
                ).collect(Collectors.toList());
    }
*/
        return List.of();
    }
}
