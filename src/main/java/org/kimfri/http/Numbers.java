package org.kimfri.http;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Numbers {
    public static void main(String[] args) {
        Numbers names = new Numbers();
        names.doit();
    }

    private void doit() {
        final MyHttp myHttp = new MyHttp();
        final List<String> numbers = getRandomNumbers(10);
        final String url = "http://numbersapi.com/";
        numbers.stream()
                .map(name -> url + name + "/math")
                .forEach(myHttp::getGetHttp);
    }

    private List<String> getRandomNumbers(int amountOfNumbers) {
        Random random = new Random(System.currentTimeMillis());
        List<String> numberList = new ArrayList<>();
        for (int i = 0; i < amountOfNumbers; i++) {
            numberList.add(Integer.toString(random.nextInt(0, 1000)));
        }
        return numberList;
    }
}
