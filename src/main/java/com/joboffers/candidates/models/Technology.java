package com.joboffers.candidates.models;

import java.util.Collections;
import java.util.List;

public class Technology {
    private final String technology;

    public Technology(String technology) {
        this.technology = technology;
    }

    public String getTechnology() {
        return technology;
    }

    public static int calculateExperience(Candidate candidate) {
        return 0;
    }

    public static List<Candidate> findCandidatesWithTechnologyExperience(String technologyName) {
        return Collections.emptyList();
    }
}
