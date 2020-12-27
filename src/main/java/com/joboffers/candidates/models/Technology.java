package com.joboffers.candidates.models;

import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Technology {
    private final String technology;

    public Technology(String technology) {
        this.technology = technology;
    }

    public String getTechnology() {
        return technology;
    }

    public static Map<String, Integer> calculateExperience(Candidate candidate) {
        List<EducationalInformation> educationalInformationList  = candidate.getEducationalInformationList();
        List<ProfessionalInformation> professionalInformationList  = candidate.getProfessionalInformationList(); // TODO hay que validar que no sea null si no da error.
        Map<String, Integer> technologyMap = new HashMap();

        educationalInformationList.forEach(educationalInformation -> {
            List<Technology> educationalTechnologyList =  educationalInformation.getTechnologyList();

            educationalTechnologyList.forEach(tech -> {
                Integer pastMonthExperience = technologyMap.get(tech.getTechnology().toLowerCase());
                Integer newMonthExperience = Math.toIntExact(ChronoUnit.MONTHS.between(
                        educationalInformation.getStartDate(),
                        educationalInformation.getEndDate()
                ));

                if (pastMonthExperience == null) {
                    pastMonthExperience = 0;
                }

                technologyMap.put(tech.getTechnology().toLowerCase(), pastMonthExperience + newMonthExperience);
            });
        });

        professionalInformationList.forEach(professionalInformation -> {
            List<Technology> professionalTechnologyList =  professionalInformation.getTechnologyList();

            professionalTechnologyList.forEach(tech -> {
                Integer pastMonthExperience = technologyMap.get(tech.getTechnology().toLowerCase());
                Integer newMonthExperience = Math.toIntExact(ChronoUnit.MONTHS.between(
                        professionalInformation.getStartDate(),
                        professionalInformation.getEndDate()
                ));

                if (pastMonthExperience == null) {
                    pastMonthExperience = 0;
                }

                technologyMap.put(tech.getTechnology().toLowerCase(), pastMonthExperience + newMonthExperience);
            });
        });


        return technologyMap;
    }

    public static List<Candidate> findCandidatesWithTechnologyExperience(String technologyName) {
        return Collections.emptyList();
    }
}
