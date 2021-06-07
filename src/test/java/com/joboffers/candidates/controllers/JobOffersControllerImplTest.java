package com.joboffers.candidates.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.service.CandidateService;
import com.joboffers.candidates.service.model.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static com.joboffers.candidates.TestObjectFactory.createCandidate;
import static com.joboffers.candidates.TestObjectFactory.createCandidateEntity;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class JobOffersControllerImplTest {

    @Mock
    private CandidateService candidateService;
    @Captor
    private ArgumentCaptor<Candidate> candidateArgumentCaptor;
    @InjectMocks
    private JobOffersControllerImpl underTest;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        underTest = new JobOffersControllerImpl(candidateService);

        mockMvc = MockMvcBuilders.standaloneSetup(underTest)
                .build();
    }

    @Test
    void givenACandidate_whenCreateCandidateIsTriggered_shouldCreateCandidate() throws Exception {
        final CandidateEntity candidateEntity = createCandidateEntity(List.of(), List.of());
        when(candidateService.createCandidate(candidateArgumentCaptor.capture())).thenReturn(candidateEntity);
        final ObjectMapper mapper = new ObjectMapper();
        final String candidateRequest = mapper.writeValueAsString(createCandidate(List.of(), List.of()));

        mockMvc.perform(post("/candidate")
                .contentType(APPLICATION_JSON)
                .content(candidateRequest))
                .andExpect(jsonPath("$.name").value("Patricia"))
                .andExpect(status().isCreated());
    }

    @Test
    void givenACandidateWithEmptyName_whenCreateCandidateIsTriggered_shouldReturn400() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final Candidate candidate = createCandidate(List.of(), List.of());
        candidate.setName("");
        final String candidateRequest = mapper.writeValueAsString(candidate);

        mockMvc.perform(post("/candidate")
                .contentType(APPLICATION_JSON)
                .content(candidateRequest))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenACandidateWithNullName_whenCreateCandidateIsTriggered_shouldReturn400() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final Candidate candidate = createCandidate(List.of(), List.of());
        candidate.setName(null);
        final String candidateRequest = mapper.writeValueAsString(candidate);

        mockMvc.perform(post("/candidate")
                .contentType(APPLICATION_JSON)
                .content(candidateRequest))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenACandidateWithEmptyEmail_whenCreateCandidateIsTriggered_shouldReturn400() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final Candidate candidate = createCandidate(List.of(), List.of());
        candidate.setEmail("");
        final String candidateRequest = mapper.writeValueAsString(candidate);

        mockMvc.perform(post("/candidate")
                .contentType(APPLICATION_JSON)
                .content(candidateRequest))
                .andExpect(status().is4xxClientError());
    }
}