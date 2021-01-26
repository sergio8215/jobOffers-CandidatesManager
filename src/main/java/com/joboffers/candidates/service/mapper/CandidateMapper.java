package com.joboffers.candidates.service.mapper;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.service.model.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CandidateMapper {
    
    Candidate mapToCandidate(CandidateEntity candidateEntity);
}
