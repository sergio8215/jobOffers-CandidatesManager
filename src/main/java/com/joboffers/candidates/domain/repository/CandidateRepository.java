package com.joboffers.candidates.domain.repository;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CandidateRepository extends CrudRepository<CandidateEntity, UUID> {

    List<CandidateEntity> findByTechnology(String technologyName);
}
