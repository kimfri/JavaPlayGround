package org.kimfri.lombockStuff;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private final String name;
    private final String email;
    private int age;

    @Builder
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}