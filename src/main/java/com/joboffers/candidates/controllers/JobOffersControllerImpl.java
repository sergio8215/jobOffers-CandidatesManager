package com.joboffers.candidates.controllers;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.service.CandidateService;
import com.joboffers.candidates.service.model.Candidate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobOffersControllerImpl implements JobOffersController {

    private final CandidateService candidateService;

    public JobOffersControllerImpl(final CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @Override
    public CandidateEntity createCandidate(final Candidate request) {
        return candidateService.createCandidate(request);
    }
}
