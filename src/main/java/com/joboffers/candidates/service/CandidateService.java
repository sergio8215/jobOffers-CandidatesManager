package com.joboffers.candidates.service;

import com.joboffers.candidates.service.model.Candidate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CandidateService {

    UUID createCandidate(Candidate candidate);

    Optional<Candidate> getCandidate(UUID id);

    List<Candidate> getListOfCandidatesByTechnology(String java);
}
