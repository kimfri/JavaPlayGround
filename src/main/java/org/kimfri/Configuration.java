package org.kimfri;

public class Configuration {
  private final String accessToken;
  private final String accessKey;
  private static Configuration instance;

  private Configuration() {
    accessKey = System.getProperty("accessKey", "kalle");
    accessToken = System.getProperty("accessToken", "pelle");
  }

  static Configuration getInstance() {
    if (instance == null) {
      instance = new Configuration();
    }
    return instance;
  }

  public String getAccessKey() {
    return accessKey;
  }

  public String getAccessToken() {
    return accessToken;
  }
}
