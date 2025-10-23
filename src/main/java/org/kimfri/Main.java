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

  public static void main(String[] args) {
    Main main = new Main();
    main.start();
  }

  private void start() {
    logger.error("Starting something");

    logger.error("AccessKey: " + Configuration.getInstance().getAccessKey());

    final List<Path> files = findFiles();
    logger.error("Amount of files: " + files.size());
    for (Path file: files) {
      sendToBucket(file);
    }
  }

  void sendToBucket(Path theFilePath) {
    final String fileNameToStore = theFilePath.getFileName().toString();

    logger.error("File: " + theFilePath.getFileName() + " Will be stored as: " + fileNameToStore);
  }

  private List<Path> findFiles() {
    try (Stream<Path> stream = Files.list(Path.of("."))) {
      return stream
          .filter(Files::isRegularFile)
          .map(Path::getFileName)
          .filter(this::isAssumedFileExtension)
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
}
