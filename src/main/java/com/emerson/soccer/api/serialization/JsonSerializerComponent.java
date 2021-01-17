package com.emerson.soccer.api.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.io.IOException;

@JsonComponent
public class JsonSerializerComponent extends JsonObjectSerializer<JsonSerializable> {
    @Override
    protected void serializeObject(JsonSerializable serializable,
                                   JsonGenerator jsonGenerator,
                                   SerializerProvider provider) throws IOException {
        serializable.writeJson(jsonGenerator);
    }
}
