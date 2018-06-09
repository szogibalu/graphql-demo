package com.szogibalu.meetup.graphql.util;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.core.util.BufferRecyclers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class TestUtils {

    private JsonStringEncoder jsonStringEncoder = BufferRecyclers.getJsonStringEncoder();

    @Value("classpath:graphql/query-wrapper.json")
    private Resource queryWrapperFile;


    public String queryWrapper() {
        try {
            return StreamUtils.copyToString(queryWrapperFile.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String createJsonQuery(Resource resource) {
        try {
            return createJsonQuery(StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String createJsonQuery(String graphQL) {
        return queryWrapper().replace("__payload__", escapeQuery(graphQL));
    }

    public String escapeQuery(String graphQL) {
        return String.valueOf(jsonStringEncoder.quoteAsString(graphQL));
    }

    public JsonNode parse(String payload) {
        try {
            return new ObjectMapper().readTree(payload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
