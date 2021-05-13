package com.joboffers.candidates.service.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EducationalInformation extends CareerInformation {

    private String course;
    @NotBlank(message = "place can't be empty or null")
    private String place;

    @Builder
    public EducationalInformation(final String name,
                                  final String description,
                                  final LocalDate startDate,
                                  final LocalDate endDate,
                                  final String course,
                                  final String place,
                                  final List<Technology> technologyList) {
        super(name, description, startDate, endDate, CareerType.EDUCATIONAL, technologyList);
        this.course = course;
        this.place = place;
    }

    public EducationalInformation() {
    } // necessary for deserialization
}
