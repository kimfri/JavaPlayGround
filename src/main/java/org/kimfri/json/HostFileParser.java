package org.kimfri.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HostFileParser {
  private final ObjectMapper objectMapper;

  private static final Logger LOGGER = LogManager.getLogger(HostFileParser.class);

  public HostFileParser() {
    objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public List<Host> parseHostFile(Path path) {
    try {
      String jsonString = Files.readString(path);
      LOGGER.error(() -> "Error");
      LOGGER.debug(() -> "Debug");
      return objectMapper.readValue(jsonString, Hosts.class).getHosts();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return List.of();
  }
}
