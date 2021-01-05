package com.joboffers.candidates.services;

import com.joboffers.candidates.domain.models.Candidate;
import com.joboffers.candidates.domain.models.EducationalInformation;
import com.joboffers.candidates.domain.models.ProfessionalInformation;
import com.joboffers.candidates.domain.models.Technology;

import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TechnologyServicesImpl {

    public Map<String, Integer> calculateExperience(Candidate candidate) {
        List<EducationalInformation> educationalInformationList  = candidate.getEducationalInformationList();
        List<ProfessionalInformation> professionalInformationList  = candidate.getProfessionalInformationList(); // TODO hay que validar que no sea null si no da error.
        Map<String, Integer> technologyMap = new HashMap();

        educationalInformationList.forEach(educationalInformation -> {
            List<Technology> educationalTechnologyList =  educationalInformation.getTechnologyList();

            educationalTechnologyList.forEach(tech -> {
                Integer pastMonthExperience = technologyMap.getOrDefault(tech.getTechnology().toLowerCase(), 0);
                Integer newMonthExperience = Math.toIntExact(ChronoUnit.MONTHS.between(
                        educationalInformation.getStartDate(),
                        educationalInformation.getEndDate()
                ));

                technologyMap.put(tech.getTechnology().toLowerCase(), pastMonthExperience + newMonthExperience);
            });
        });

        professionalInformationList.forEach(professionalInformation -> {
            List<Technology> professionalTechnologyList =  professionalInformation.getTechnologyList();

            professionalTechnologyList.forEach(tech -> {
                Integer pastMonthExperience = technologyMap.getOrDefault(tech.getTechnology().toLowerCase(), 0);
                Integer newMonthExperience = Math.toIntExact(ChronoUnit.MONTHS.between(
                        professionalInformation.getStartDate(),
                        professionalInformation.getEndDate()
                ));

                technologyMap.put(tech.getTechnology().toLowerCase(), pastMonthExperience + newMonthExperience);
            });
        });

        return technologyMap;
    }

    public List<Candidate> findCandidatesWithTechnologyExperience(String technologyName) {
        return Collections.emptyList();
    }
}
