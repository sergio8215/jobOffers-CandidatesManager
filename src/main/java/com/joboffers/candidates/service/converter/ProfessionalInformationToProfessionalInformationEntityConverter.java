package com.joboffers.candidates.service.converter;

import com.joboffers.candidates.domain.entity.ProfessionalInformationEntity;
import com.joboffers.candidates.domain.entity.TechnologyEntity;
import com.joboffers.candidates.service.model.ProfessionalInformation;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

public class ProfessionalInformationToProfessionalInformationEntityConverter implements Converter<ProfessionalInformation, ProfessionalInformationEntity> {

    private ConversionService conversionService;

    @Override
    public ProfessionalInformationEntity convert(final ProfessionalInformation professionalInformation) {
        final ProfessionalInformationEntity professionalInformationEntity = new ProfessionalInformationEntity();
        professionalInformationEntity.setName(professionalInformation.getName());
        professionalInformationEntity.setNotes(professionalInformation.getNotes());
        professionalInformationEntity.setDescription(professionalInformation.getDescription());
        professionalInformationEntity.setStartDate(professionalInformation.getStartDate());
        professionalInformationEntity.setEndDate(professionalInformation.getEndDate());
        professionalInformationEntity.setTechnologyList(professionalInformation.getTechnologyList().stream()
                .map(technology ->
                        conversionService.convert(technology, TechnologyEntity.class))
                .collect(Collectors.toList()));

        return professionalInformationEntity;
    }
}
