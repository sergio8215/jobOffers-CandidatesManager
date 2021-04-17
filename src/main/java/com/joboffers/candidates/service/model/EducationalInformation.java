package com.joboffers.candidates.service.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EducationalInformation {
    @NotBlank(message = "name can't be empty or null")
    private String name;
    private String description;
    @JsonSerialize(using = ToStringSerializer.class)
    @NotBlank(message = "start_date can't be empty or null")
    private LocalDate startDate;
    @JsonSerialize(using = ToStringSerializer.class)
    @NotBlank(message = "end_date can't be empty or null")
    private LocalDate endDate;
    private String course;
    @NotBlank(message = "place can't be empty or null")
    private String place;
    @NotBlank(message = "technology_list can't be empty or null")
    private List<Technology> technologyList = List.of();

    public EducationalInformation(final String name,
                                  final String description,
                                  final LocalDate startDate,
                                  final LocalDate endDate,
                                  final String course,
                                  final String place,
                                  final List<Technology> technologyList) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.place = place;
        this.technologyList = technologyList;
    }

    public EducationalInformation() {
    } // necessary for deserialization
}
