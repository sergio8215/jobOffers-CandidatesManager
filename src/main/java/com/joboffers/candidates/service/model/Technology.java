package com.joboffers.candidates.service.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.NotBlank;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Technology {
    @NotBlank(message = "name can't be empty or null")
    private final String name;

    public Technology(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
