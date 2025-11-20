package org.kimfri;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

  private Random random;

  public MyCallable(Random random) {
    this.random = random;
  }

  @Override
  public String call() throws Exception {
    final int randValue = random.nextInt(0, 10);
    try {
      Thread.sleep(randValue * 1000L);
    } catch (InterruptedException ie) {
      throw new MyCallableException("I'm interrupted...", ie);
    }

    long currentTime = System.currentTimeMillis();
//    if (currentTime % 2 == 0) {
//      throw new MyCallableException("Current time %d".formatted(currentTime));
//    }
    return "Current time: %d (%d)".formatted(currentTime, randValue);
  }
}
