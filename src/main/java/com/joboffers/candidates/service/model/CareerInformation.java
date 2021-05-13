package com.joboffers.candidates.service.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public abstract class CareerInformation {
    @NotBlank(message = "name can't be empty or null")
    private String name;
    private String description;
    @JsonSerialize(using = ToStringSerializer.class)
    @NotBlank(message = "start_date can't be empty or null")
    private LocalDate startDate;
    @JsonSerialize(using = ToStringSerializer.class)
    @NotBlank(message = "end_date can't be empty or null")
    private LocalDate endDate;
    private CareerType career;
    @NotBlank(message = "technology_list can't be empty or null")
    private List<Technology> technologyList = List.of();

    protected CareerInformation() {
    } // necessary for deserialization

    public CareerInformation(@NotBlank(message = "name can't be empty or null") final String name,
                             final String description,
                             @NotBlank(message = "start_date can't be empty or null") final LocalDate startDate,
                             @NotBlank(message = "end_date can't be empty or null") final LocalDate endDate,
                             final CareerType career,
                             @NotBlank(message = "technology_list can't be empty or null") final List<Technology> technologyList) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.career = career;
        this.technologyList = technologyList;
    }
}
