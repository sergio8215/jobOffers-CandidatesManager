package com.joboffers.candidates.service;

import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.ProfessionalInformation;
import com.joboffers.candidates.service.model.Technology;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;

@Service
class TechnologyServiceImpl implements TechnologyService {

    private CandidateService candidateService;

    @Override
    public Map<String, Integer> calculateExperience(final Candidate candidate) {

        if (isNull(candidate)) {
            throw new IllegalArgumentException("Candidate can't be null");
        }
        if (isNull(candidate.getEducationalInformationList())) {
            candidate.setEducationalInformationList(emptyList());
        }
        if (isNull(candidate.getProfessionalInformationList())) {
            candidate.setProfessionalInformationList(emptyList());
        }

        final List<EducationalInformation> educationalInformationList = candidate.getEducationalInformationList();
        final List<ProfessionalInformation> professionalInformationList = candidate.getProfessionalInformationList();
        final Map<String, Integer> technologyMap = new HashMap<>();

        educationalInformationList.forEach(educationalInformation -> {
            final List<Technology> educationalTechnologyList = educationalInformation.getTechnologyList();

            educationalTechnologyList.forEach(tech -> {
                final Integer pastMonthExperience = technologyMap.getOrDefault(tech.getName().toLowerCase(), 0);
                final Integer newMonthExperience = Math.toIntExact(ChronoUnit.MONTHS.between(
                        educationalInformation.getStartDate(),
                        educationalInformation.getEndDate()
                ));

                technologyMap.put(tech.getName().toLowerCase(), pastMonthExperience + newMonthExperience);
            });
        });

        professionalInformationList.forEach(professionalInformation -> {
            final List<Technology> professionalTechnologyList =  professionalInformation.getTechnologyList();

            professionalTechnologyList.forEach(tech -> {
                final Integer pastMonthExperience = technologyMap.getOrDefault(tech.getName().toLowerCase(), 0);
                final Integer newMonthExperience = Math.toIntExact(ChronoUnit.MONTHS.between(
                        professionalInformation.getStartDate(),
                        professionalInformation.getEndDate()
                ));

                technologyMap.put(tech.getName().toLowerCase(), pastMonthExperience + newMonthExperience);
            });
        });

        return technologyMap;
    }

    @Override
    public List<Candidate> findCandidatesByTechnologyOrderedByExperience(final String technologyName, final SortOrder sortOrder) {

        return candidateService.getListOfCandidatesByTechnologyOrderedByExperience(technologyName, sortOrder);
    }


}
