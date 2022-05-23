package org.kimfri.json;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Cli {
    private static final Logger logger = LoggerFactory.getLogger(Cli.class);

    public static void main(String[] args) {
        Cli cli = new Cli();
        cli.doit("c:\\Users\\kimfr\\utveckling\\JavaPlayGround\\src\\test\\resources\\files\\small.json");
        cli.doit("c:\\Users\\kimfr\\utveckling\\JavaPlayGround\\src\\test\\resources\\files\\unknownProperty.json");
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
