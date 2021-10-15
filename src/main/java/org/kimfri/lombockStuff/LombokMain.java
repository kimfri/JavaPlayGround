package org.kimfri.lombockStuff;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LombokMain {

    public static void main(String[] args) {
        LombokMain lm = new LombokMain();
        lm.doit();
    }

    private void doit() {
        Person person = new Person(
                "Kim",
                "Fritzon",
                "kim.fritzon@gmail.com");
        Person person2 = new Person(
                "Maria",
                "Fritzon-Ölander");

        log.info(person.toString());
        log.info(person2.toString());
    }
}
