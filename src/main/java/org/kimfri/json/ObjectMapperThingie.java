package org.kimfri.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ObjectMapperThingie {

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    public static JsonNode pareFile(File file) throws IOException {
        return getObjectMapper().readTree(file);
    }

    public static <A> A fromJson(JsonNode jsonNode, Class<A> clazz)
            throws JsonProcessingException {
        return getObjectMapper().treeToValue(jsonNode, clazz);
    }
}
