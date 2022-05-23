package org.kimfri.json.model;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MetadataParserTest {

    private MetadataParser metadataParser;

    @BeforeEach
    void setUp() {
        metadataParser = new MetadataParser();
    }

    @Test
    void givenCorrectFile_whenParsing_thenReturnCorrectObject() throws IOException {
        final String filename = "files/small.json";
        final String file = getClass().getClassLoader().getResource(filename).getFile();
        final Metadata metadata = metadataParser.parseMetadataFile(new File(file));
        final String uuid = "97a97444-7344-45f5-87b6-64221075175d";
        assertNotNull(metadata);
        assertNotNull(metadata.getMeta());
        assertEquals(uuid, metadata.getMeta().getUuid());
    }

    @Test
    void givenUnknownProperty_whenParsingFile_thenThrowException() {
        final String filename = "files/unknownProperty.json";
        final String file = getClass().getClassLoader().getResource(filename).getFile();

        Assertions.assertThrows(UnrecognizedPropertyException.class, () -> {
            metadataParser.parseMetadataFile(new File(file));
        });
    }
}