package com.joboffers.candidates.service;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.service.model.Candidate;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface CandidateService {

    CandidateEntity createCandidate(Candidate candidate);

    Optional<Candidate> getCandidate(long id);

    List<Candidate> getListOfCandidatesByTechnologyOrderedByExperience(String technologyName, SortOrder sortOrder);
}
