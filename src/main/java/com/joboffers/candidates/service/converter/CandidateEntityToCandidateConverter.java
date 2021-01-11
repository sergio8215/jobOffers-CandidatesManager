package com.joboffers.candidates.service.converter;

import com.joboffers.candidates.service.model.builder.CandidateBuilder;
import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.service.model.Candidate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CandidateEntityToCandidateConverter implements Converter<CandidateEntity, Candidate> {

    @Override
    public Candidate convert(final CandidateEntity candidateEntity) {
        return CandidateBuilder.aCandidate()
                .withName(candidateEntity.getName())
                .withAddress(candidateEntity.getAddress())
                .withBirthday(candidateEntity.getBirthday())
                .withEmail(candidateEntity.getEmail())
                .withGender(candidateEntity.getGender())
                .withLinkedin(candidateEntity.getLinkedin())
                .withPhoneNumber(candidateEntity.getPhoneNumber())
                .withProfessionalInformationList(candidateEntity.getProfessionalInformationList())
                .withEducationalInformationList(candidateEntity.getEducationalInformationList())
                .build();
    }
}
