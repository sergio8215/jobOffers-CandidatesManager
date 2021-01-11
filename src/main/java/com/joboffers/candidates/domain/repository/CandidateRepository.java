package com.joboffers.candidates.domain.repository;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.service.model.Candidate;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CandidateRepository extends CrudRepository<CandidateEntity, UUID> {

}
