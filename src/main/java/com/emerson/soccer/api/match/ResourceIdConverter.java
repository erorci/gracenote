package com.emerson.soccer.api.match;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResourceIdConverter implements Converter<String, ResourceId> {

    @Override
    public ResourceId convert(String value) {
        return ResourceId.fromString(value);
    }
}
