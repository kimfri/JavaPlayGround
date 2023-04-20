package org.kimfri;

import java.util.Arrays;
import java.util.List;

public class FlatMapStruff {

    public static void main(String[] args) {
        FlatMapStruff fms = new FlatMapStruff();
        fms.doit();
    }

    private void doit() {
        List<User> users = Arrays.asList(
                new User("Kim", 47, Arrays.asList("1", "2", "3")),
                new User("Maria", 45, Arrays.asList("4", "5", "6")),
                new User("Wille", 16, Arrays.asList("1"))
        );

        users.stream()
                .map(user -> user.getPhoneNo().stream())
                .flatMap(stringStream -> stringStream.filter(s -> "5".equals(s)))
                .findAny()
                .ifPresent(System.out::println);
    }
}

class User {
    private final String name;
    private final int age;
    private final List<String> phoneNo;

    public User(String name, int age, List<String> phoneNo) {
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getPhoneNo() {
        return phoneNo;
    }
}
