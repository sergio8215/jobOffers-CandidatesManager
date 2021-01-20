package com.joboffers.candidates.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String firstName;
    private String surname;
    private int age;
    private int height;
}
