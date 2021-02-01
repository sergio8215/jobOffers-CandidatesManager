package com.joboffers.candidates.service.converter;

import com.joboffers.candidates.domain.entity.ProfessionalInformationEntity;
import com.joboffers.candidates.domain.entity.TechnologyEntity;
import com.joboffers.candidates.service.model.ProfessionalInformation;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProfessionalInformationToProfessionalInformationEntityConverter implements Converter<ProfessionalInformation, ProfessionalInformationEntity> {

    private ConversionService conversionService;

    @Override
    public ProfessionalInformationEntity convert(final ProfessionalInformation professionalInformation) {
        return ProfessionalInformationEntity.builder()
                .name(professionalInformation.getName())
                .notes(professionalInformation.getNotes())
                .description(professionalInformation.getDescription())
                .startDate(professionalInformation.getStartDate())
                .endDate(professionalInformation.getEndDate())
                .technologyList(professionalInformation.getTechnologyList().stream()
                        .map(technology ->
                                conversionService.convert(technology, TechnologyEntity.class))
                        .collect(Collectors.toList()))
                .build();
    }
}
