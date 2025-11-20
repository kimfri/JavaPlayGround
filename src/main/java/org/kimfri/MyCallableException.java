package org.kimfri;

public class MyCallableException extends RuntimeException {
  public MyCallableException(String message) {
    super(message);
  }
  public MyCallableException(String message, Throwable e) {
    super(message, e);
  }
}
