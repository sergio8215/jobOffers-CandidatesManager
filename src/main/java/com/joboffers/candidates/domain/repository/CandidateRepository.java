package com.joboffers.candidates.domain.repository;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends CrudRepository<CandidateEntity, Long> {

    //List<CandidateEntity> findByTechnology(String technologyName);

}
