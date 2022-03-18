package org.kimfri;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IdeSkills {

    public static void main(String[] args) {
        kalle("");
        kalle("2");
        final String someDataMedium = getSomeDataMedium();
        final String s = "hellow world";
        s.getBytes();
        System.out.println("\"kalle\" = " + "kalle");
    }

    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private static void kalle(String apa) {
        String[] args = null;
    }

    public static String getSomeDataFast() {
        return "";
    }

    public static String getSomeDataSlow() {
        return "";
    }

    public static String getSomeDataMedium() {
        return "";
    }

    private int getInt() throws IOException {
        final LocalDateTime now = LocalDateTime.now();
        final long l = System.currentTimeMillis();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("a.txt"))) {
            bufferedReader.lines()
                    .forEach(System.err::println);
        }
        final String x = "kalle" + l;
        System.out.println(x);



        return 1;
    }

    public class Wohoo {
        private final String a;
        private final String b;
        private List<String> values = new ArrayList<>();

        public List<String> getValues() {
            return Collections.unmodifiableList(values);
        }

        public Wohoo(String a, String b) {
            this.a = a;
            this.b = b;
        }
    }
}
