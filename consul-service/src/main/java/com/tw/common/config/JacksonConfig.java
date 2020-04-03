package com.tw.common.config;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.tw.common.base.Status;
import com.tw.common.deserializer.StatusDeserializer;
import com.tw.common.serializer.StatusSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {
    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();

        objectMapper.setSerializationInclusion(Include.NON_NULL);

        // 序列化Status类型
        SimpleModule module = new SimpleModule();
        module.addSerializer(Status.class, new StatusSerializer());
        module.addDeserializer(Status.class, new StatusDeserializer());
        objectMapper.registerModule(module);

        return objectMapper;
    }
}
