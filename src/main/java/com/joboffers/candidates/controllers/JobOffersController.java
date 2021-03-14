package com.joboffers.candidates.controllers;

import com.joboffers.candidates.service.model.Candidate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public interface JobOffersController {

    @PostMapping(value = "/candidate", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    String createCandidate(@RequestBody Candidate request);
}
