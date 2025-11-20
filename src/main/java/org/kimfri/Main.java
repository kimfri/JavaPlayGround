package org.kimfri;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Main {
  private static final Logger LOGGER = LogManager.getLogger();
  private ExecutorService es = new ForkJoinPool();
  private List<MyCallable> callableList = new ArrayList<>();
  private Random random = new Random();
  private List<Future<String>> futureList = new ArrayList<>();


  static void main() throws InterruptedException {
    Main main = new Main();
//    main.doit1();
    main.doit2();
  }

  private void doit2() throws InterruptedException {
    createCallables(10);
    startAllCallables();
    while (!allFuturesDone()) {
      Thread.sleep(100);
    }
    printAllFutureStrings();
  }

  private void printAllFutureStrings() {
    futureList.forEach(it -> {
      try {
        LOGGER.error(">>> " + it.get() + "\n");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } catch (ExecutionException e) {
        throw new RuntimeException(e);
      }
    });
  }

  void createCallables(int amount) {
    for (int i = 0; i < amount; i++) {
      callableList.add(new MyCallable(random));
    }
  }

  void startAllCallables() {
    callableList.forEach(it -> futureList.add(es.submit(it)));
  }

  boolean allFuturesDone() {
    final Optional<Future<String>> anyFuture = futureList.stream()
        .filter(it -> !it.isDone())
        .findAny();
    return anyFuture.isEmpty();
  }

  private void doit1() throws InterruptedException {
    MyCallable myCallable = new MyCallable(random);
    final Future<String> stringFuture = es.submit(myCallable);

    LOGGER.error(() -> "And so it begins...");

    while (!stringFuture.isDone()) {
      Thread.sleep(200);
    }
    if (!stringFuture.isCancelled()) {
      try {
        LOGGER.error("From the future: " + stringFuture.get());
      } catch (Exception e) {
        LOGGER.error(e::getMessage, e);
      }
    }
  }
}
