package com.emerson.soccer.api.serialization;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public interface JsonSerializable {
    void writeJson(JsonGenerator jsonGenerator) throws IOException;
}
