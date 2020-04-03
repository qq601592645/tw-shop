package com.tw.common.serializer;



import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tw.common.base.Status;

import java.io.IOException;

public class StatusSerializer extends JsonSerializer<Status> {
    @Override
    public void serialize(Status value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeNumber(value.getValue());
    }
}
