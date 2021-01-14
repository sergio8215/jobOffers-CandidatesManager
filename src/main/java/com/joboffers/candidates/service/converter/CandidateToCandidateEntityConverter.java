package com.joboffers.candidates.service.converter;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.domain.entity.EducationalInformationEntity;
import com.joboffers.candidates.domain.entity.ProfessionalInformationEntity;
import com.joboffers.candidates.service.model.Candidate;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

public class CandidateToCandidateEntityConverter implements Converter<Candidate, CandidateEntity> {

    private ConversionService conversionService;

    @Override
    public CandidateEntity convert(final Candidate candidate) {
        final CandidateEntity candidateEntity = new CandidateEntity();
        candidateEntity.setName(candidate.getName());
        candidateEntity.setAddress(candidate.getAddress());
        candidateEntity.setBirthday(candidate.getBirthday());
        candidateEntity.setEmail(candidate.getEmail());
        candidateEntity.setGender(candidate.getGender());
        candidateEntity.setLinkedin(candidate.getLinkedin());
        candidateEntity.setPhoneNumber(candidate.getPhoneNumber());
        candidateEntity.setEducationalInformationList(candidate.getEducationalInformationList().stream()
                .map(educationalInformation ->
                        conversionService.convert(educationalInformation, EducationalInformationEntity.class))
                .collect(Collectors.toList()));
        candidateEntity.setProfessionalInformationList(candidate.getProfessionalInformationList().stream()
                .map(professionalInformation ->
                        conversionService.convert(professionalInformation, ProfessionalInformationEntity.class))
                .collect(Collectors.toList()));

        return candidateEntity;
    }
}
