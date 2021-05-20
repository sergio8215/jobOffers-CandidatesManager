package com.joboffers.candidates.service.converter;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.domain.entity.EducationalInformationEntity;
import com.joboffers.candidates.domain.entity.ProfessionalInformationEntity;
import com.joboffers.candidates.service.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CandidateToCandidateEntityConverter implements Converter<Candidate, CandidateEntity> {

    private ConversionService conversionService;

    @Autowired
    @Lazy
    void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public CandidateEntity convert(final Candidate candidate) {
        final CandidateEntity candidateEntity = CandidateEntity.builder()
                .name(candidate.getName())
                .address(candidate.getAddress())
                .birthday(candidate.getBirthday())
                .email(candidate.getEmail())
                .gender(candidate.getGender())
                .linkedIn(candidate.getLinkedin())
                .phoneNumber(candidate.getPhoneNumber())
                .educationalInformationList(candidate.getEducationalInformationList().stream()
                        .map(educationalInformation ->
                                conversionService.convert(educationalInformation, EducationalInformationEntity.class))
                        .collect(Collectors.toList()))
                .professionalInformationList(candidate.getProfessionalInformationList().stream()
                        .map(professionalInformation ->
                                conversionService.convert(professionalInformation, ProfessionalInformationEntity.class))
                        .collect(Collectors.toList()))
                .build();

        candidateEntity.getEducationalInformationList().forEach(educationalInformationEntity -> educationalInformationEntity.setCandidate(candidateEntity));
        candidateEntity.getProfessionalInformationList().forEach(professionalInformationEntity -> professionalInformationEntity.setCandidate(candidateEntity));

        return candidateEntity;
    }
}
