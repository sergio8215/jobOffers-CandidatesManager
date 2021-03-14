package com.joboffers.candidates.domain.repository;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CandidateRepository extends CrudRepository<CandidateEntity, UUID> {

    //List<CandidateEntity> findByTechnology(String technologyName);

    //List<CandidateEntity> findByTechnologyByOrderAsc(String technologyName);

    //List<CandidateEntity> findByTechnologyByOrderDesc(String technologyName);
}
