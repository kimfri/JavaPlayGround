package org.kimfri;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;

public class Main {
  private static final Logger LOGGER = LogManager.getLogger(Main.class);

  static void main() {
    new CommandLine(new CommandParser()).execute("-a=51", "-u=Kim");
//    new CommandLine(new CommandParser()).execute("-a=51");
//    new CommandLine(new CommandParser()).execute("-h");
  }
}
