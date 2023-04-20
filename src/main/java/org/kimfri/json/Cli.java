package org.kimfri.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kimfri.json.model.Metadata;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Cli {
    private static final Logger logger = LogManager.getLogger(Cli.class);

    public static void main(String[] args) {
        Cli cli = new Cli();
//        cli.doit("c:\\Users\\kimfr\\utveckling\\JavaPlayGround\\src\\test\\resources\\files\\small.json");
//        cli.doit("c:\\Users\\kimfr\\utveckling\\JavaPlayGround\\src\\test\\resources\\files\\unknownProperty.json");
        cli.print("c:\\Users\\kimfr\\utveckling\\JavaPlayGround\\src\\test\\resources\\files\\small.json");
    }

    private void print(String filename) {
        final Injector injector = Guice.createInjector(new MetadataModule());
        final FormatParser format = injector.getInstance(FormatParser.class);
        Metadata metadata = null;
        try {
            metadata = format.getMetadata(new File(filename));
        } catch (IOException upe) {
            decideWhatHappened(upe);
        }
        final String jsonString = Optional.ofNullable(metadata)
                .map(this::metadataToJsonString)
                .orElse("N/A");
        logger.debug(jsonString);
    }

    private String metadataToJsonString(Metadata metadata) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(metadata);
        } catch (JsonProcessingException e) {
            decideWhatHappened(e);
        }
        return json;
    }

    private void doit(String filename) {
        final Injector injector = Guice.createInjector(new MetadataModule());
        final FormatParser format = injector.getInstance(FormatParser.class);
        try {
            final String uuidFromMetadataFile = format.getUuidFromMetadataFile(new File(filename));
            logger.debug(uuidFromMetadataFile);
        } catch (IOException upe) {
            decideWhatHappened(upe);
        }
    }

    private void decideWhatHappened(IOException upe) {
        if (upe instanceof UnrecognizedPropertyException) {
            logger.error("Shady data");
        } else {
            upe.printStackTrace();
        }
    }
}
