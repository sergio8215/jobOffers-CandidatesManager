package com.joboffers.candidates.service.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.NotBlank;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Technology {

    @NotBlank(message = "name can't be empty or null")
    private String technology;

    public Technology() {
    }

    public Technology(@NotBlank(message = "name can't be empty or null") final String technology) {
        this.technology = technology;
    }

    public void setTechnology(final String technology) {
        this.technology = technology;
    }

    public String getTechnology() {
        return technology;
    }

}
