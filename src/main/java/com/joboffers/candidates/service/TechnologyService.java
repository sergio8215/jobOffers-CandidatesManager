package com.joboffers.candidates.service;

import com.joboffers.candidates.service.model.Candidate;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public interface TechnologyService {

    Map<String, Integer> calculateExperience(Candidate candidate);

    List<Candidate> findCandidatesByTechnologyOrderedByExperience(String technologyName, SortOrder sortOrder);
}
