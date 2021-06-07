package com.joboffers.candidates.service.converter;

import com.joboffers.candidates.domain.entity.TechnologyEntity;
import com.joboffers.candidates.service.model.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TechnologyToTechnologyEntityConverter implements Converter<Technology, TechnologyEntity> {

    private ConversionService conversionService;

    @Autowired
    @Lazy
    void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public TechnologyEntity convert(final Technology source) {
        return TechnologyEntity.builder()
                .technology(source.getTechnology())
                .build();
    }

}
