package com.joboffers.candidates.service.converter;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.ProfessionalInformation;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CandidateEntityToCandidateConverter implements Converter<CandidateEntity, Candidate> {

    private ConversionService conversionService;

    @Override
    public Candidate convert(final CandidateEntity candidateEntity) {
        return Candidate.builder()
                .name(candidateEntity.getName())
                .address(candidateEntity.getAddress())
                .birthday(candidateEntity.getBirthday())
                .email(candidateEntity.getEmail())
                .gender(candidateEntity.getGender())
                .linkedIn(candidateEntity.getLinkedIn())
                .phoneNumber(candidateEntity.getPhoneNumber())
                .professionalInformationList(candidateEntity.getProfessionalInformationList().stream()
                        .map(professionalInformationEntity -> conversionService.convert(professionalInformationEntity, ProfessionalInformation.class))
                        .collect(Collectors.toList()))
                .educationalInformationList(candidateEntity.getEducationalInformationList().stream()
                        .map(educationalInformationEntity -> conversionService.convert(educationalInformationEntity, EducationalInformation.class))
                        .collect(Collectors.toList()))
                .build();
    }
}
