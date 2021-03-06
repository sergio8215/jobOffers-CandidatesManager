package com.joboffers.candidates.service.converter;

import com.joboffers.candidates.domain.entity.EducationalInformationEntity;
import com.joboffers.candidates.domain.entity.TechnologyEntity;
import com.joboffers.candidates.service.model.EducationalInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EducationalInformationToEducationalInformationEntityConverter implements Converter<EducationalInformation, EducationalInformationEntity> {

    private ConversionService conversionService;

    @Autowired
    @Lazy
    void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }
    
    @Override
    public EducationalInformationEntity convert(final EducationalInformation educationalInformation) {
        final EducationalInformationEntity educationalInformationEntity = EducationalInformationEntity.builder()
                .name(educationalInformation.getName())
                .place(educationalInformation.getPlace())
                .course(educationalInformation.getCourse())
                .description(educationalInformation.getDescription())
                .startDate(educationalInformation.getStartDate())
                .endDate(educationalInformation.getEndDate())
                .technologyList(educationalInformation.getTechnologyList().stream().map(technology ->
                        conversionService.convert(technology, TechnologyEntity.class))
                        .collect(Collectors.toList()))
                .build();

        //educationalInformationEntity.getTechnologyList().forEach(technologyEntity -> technologyEntity.setEducationalInformationList(List.of(educationalInformationEntity)));

        return educationalInformationEntity;
    }
}
