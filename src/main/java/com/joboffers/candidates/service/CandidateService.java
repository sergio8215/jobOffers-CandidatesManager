package com.joboffers.candidates.service;

import com.joboffers.candidates.service.model.Candidate;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface CandidateService {

    long createCandidate(Candidate candidate);

    Optional<Candidate> getCandidate(long id);

    List<Candidate> getListOfCandidatesByTechnologyOrderedByExperience(String technologyName, SortOrder sortOrder);
}
