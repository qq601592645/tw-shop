package com.tw.common.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.tw.common.base.Status;

import java.io.IOException;

public class StatusDeserializer extends JsonDeserializer<Status> {
    @Override
    public Status deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        int value = p.getIntValue();
        
        return Status.valueOf(value);
    }
}
