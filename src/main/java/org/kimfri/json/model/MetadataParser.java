package org.kimfri.json.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MetadataParser {
    private ObjectMapper objectMapper;

    public Metadata parseMetadataFile(File jsonFile) throws IOException {
        return getObjectMapper().readValue(jsonFile, Metadata.class);
    }

    ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }
}
