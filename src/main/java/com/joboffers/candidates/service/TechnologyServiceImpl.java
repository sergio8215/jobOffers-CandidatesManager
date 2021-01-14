package com.joboffers.candidates.service;

import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.ProfessionalInformation;
import com.joboffers.candidates.service.model.Technology;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
class TechnologyServiceImpl implements TechnologyService {

    private CandidateService candidateService;

    @Override
    public Map<String, Integer> calculateExperience(final Candidate candidate) {
        final List<EducationalInformation> educationalInformationList = candidate.getEducationalInformationList();
        final List<ProfessionalInformation> professionalInformationList = candidate.getProfessionalInformationList(); // TODO hay que validar que no sea null si no da error.
        final Map<String, Integer> technologyMap = new HashMap();

        educationalInformationList.forEach(educationalInformation -> { // TODO private method que recibe una lista
            final List<Technology> educationalTechnologyList = educationalInformation.getTechnologyList();

            educationalTechnologyList.forEach(tech -> {
                final Integer pastMonthExperience = technologyMap.getOrDefault(tech.getTechnology().toLowerCase(), 0);
                final Integer newMonthExperience = Math.toIntExact(ChronoUnit.MONTHS.between(
                        educationalInformation.getStartDate(),
                        educationalInformation.getEndDate()
                ));

                technologyMap.put(tech.getTechnology().toLowerCase(), pastMonthExperience + newMonthExperience);
            });
        });

        professionalInformationList.forEach(professionalInformation -> {
            final List<Technology> professionalTechnologyList =  professionalInformation.getTechnologyList();

            professionalTechnologyList.forEach(tech -> {
                final Integer pastMonthExperience = technologyMap.getOrDefault(tech.getTechnology().toLowerCase(), 0);
                final Integer newMonthExperience = Math.toIntExact(ChronoUnit.MONTHS.between(
                        professionalInformation.getStartDate(),
                        professionalInformation.getEndDate()
                ));

                technologyMap.put(tech.getTechnology().toLowerCase(), pastMonthExperience + newMonthExperience);
            });
        });

        return technologyMap;
    }

    @Override
    public List<Candidate> findCandidatesWithTechnologyExperience(final String technologyName) {
        return candidateService.getListOfCandidatesByTechnology(technologyName);
    }
}
