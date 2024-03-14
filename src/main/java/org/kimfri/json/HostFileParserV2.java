package org.kimfri.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HostFileParserV2 {
  private final ObjectMapper objectMapper;

  private static final Logger LOGGER = LogManager.getLogger(HostFileParserV2.class);

  public HostFileParserV2() {
    objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public List<Host> parseHostFile(Path path) {
    try {
      String jsonString = Files.readString(path);
      System.err.println(jsonString);
      return objectMapper.readValue(jsonString, new TypeReference<>() {});
    } catch (Exception e) {
      e.printStackTrace();
    }
    return List.of();
  }
}
