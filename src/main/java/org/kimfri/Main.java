package org.kimfri;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  Logger logger = LogManager.getLogger(Main.class);
  List<String> fileExtensions = List.of(".txt", ".iml");
  List<String> prefixBlocks = List.of("DEBUG");

  public static void main(String[] args) {
    Main main = new Main();
    main.start();
  }

  private void start() {
    logger.error("Starting something");

    logger.error(() -> String.format("AccessKey: %s", Configuration.getInstance().getAccessKey()));

    final List<Path> files = findFiles();
    logger.error(() -> String.format("Amount of files: %d", files.size()));
    for (Path file: files) {
      sendToBucket(file);
    }
  }

  void sendToBucket(Path theFilePath) {
    final String fileNameToStore = theFilePath.getFileName().toString();
    logger.error(() -> String.format("File: %s  Will be stored as: %s", theFilePath.getFileName(), fileNameToStore));
  }

  private List<Path> findFiles() {
    try (Stream<Path> stream = Files.list(Path.of("."))) {
      return stream
          .filter(Files::isRegularFile)
          .map(Path::getFileName)
          .filter(this::isAssumedFileExtension)
          .filter(this::isPrefixBlocked)
          .collect(Collectors.toList());
    } catch (IOException i) {
      logger.error(i.getMessage(), i);
    }
    return List.of();
  }

  boolean isAssumedFileExtension(Path path) {
    return fileExtensions.stream()
        .anyMatch(extension ->
            path.getFileName().toString().contains(extension));
  }

  boolean isPrefixBlocked(Path path) {
    return prefixBlocks.stream()
        .noneMatch(prefix ->
            path.getFileName().toString().startsWith(prefix));
  }
}
