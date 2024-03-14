package org.kimfri.json;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HostFileParserTest {

  @Test
  void parseHostFile() {
    // arrange
//    HostFileParser hostFileParser = new HostFileParser();
    HostFileParserV2 hostFileParser = new HostFileParserV2();
    final Path path = Paths.get("src", "test", "resources", "hostFileV2.json");

    // act
    final List<Host> hosts = hostFileParser.parseHostFile(path);
    System.err.println(">>>" + hosts.size());
    // assert
    assertEquals(2, hosts.size());
    assertEquals("http://apa.bepa", hosts.get(0).url());
  }
}