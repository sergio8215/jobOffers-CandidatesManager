package com.joboffers.candidates.service.converter;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.service.model.Candidate;
import org.springframework.core.convert.converter.Converter;

public class CandidateToCandidateEntityConverter implements Converter<Candidate, CandidateEntity> {

    @Override
    public CandidateEntity convert(Candidate candidate) {
        CandidateEntity candidateEntity =  new CandidateEntity();
        candidateEntity.setName(candidate.getName());
        candidateEntity.setAddress(candidate.getAddress());
        candidateEntity.setBirthday(candidate.getBirthday());
        candidateEntity.setEmail(candidate.getEmail());
        candidateEntity.setGender(candidate.getGender());
        candidateEntity.setLinkedin(candidate.getLinkedin());
        candidateEntity.setPhoneNumber(candidate.getPhoneNumber());
        candidateEntity.setEducationalInformationList(candidate.getEducationalInformationList());
        candidateEntity.setProfessionalInformationList(candidate.getProfessionalInformationList());
        return candidateEntity;
    }
}
