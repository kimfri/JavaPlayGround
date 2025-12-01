package org.kimfri;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "WTF", mixinStandardHelpOptions = true, version = "1.0-SNAPSHOT")
public class CommandParser implements Callable<User> {

  private static final Logger LOGGER = LogManager.getLogger(CommandParser.class);

  @CommandLine.Option(names = {"-u", "--user"}, required = true)
  String name;

  @CommandLine.Option(names = {"-a", "--age"})
  String age;

  @Override
  public User call() throws Exception {

    return new User(name, Integer.parseInt(age));
  }
}
