package com.joboffers.candidates.service.converter;

import com.joboffers.candidates.domain.entity.EducationalInformationEntity;
import com.joboffers.candidates.domain.entity.TechnologyEntity;
import com.joboffers.candidates.service.model.EducationalInformation;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

public class EducationalInformationToEducationalInformationEntityConverter implements Converter<EducationalInformation, EducationalInformationEntity> {

    private ConversionService conversionService;

    @Override
    public EducationalInformationEntity convert(final EducationalInformation educationalInformation) {
        final EducationalInformationEntity educationalInformationEntity = new EducationalInformationEntity();
        educationalInformationEntity.setName(educationalInformation.getName());
        educationalInformationEntity.setPlace(educationalInformation.getPlace());
        educationalInformationEntity.setCourse(educationalInformation.getCourse());
        educationalInformationEntity.setDescription(educationalInformation.getDescription());
        educationalInformationEntity.setStartDate(educationalInformation.getStartDate());
        educationalInformationEntity.setEndDate(educationalInformation.getEndDate());
        educationalInformationEntity.setTechnologyList(educationalInformation.getTechnologyList().stream().map(technology ->
                conversionService.convert(technology, TechnologyEntity.class))
                .collect(Collectors.toList()));

        return educationalInformationEntity;
    }
}
