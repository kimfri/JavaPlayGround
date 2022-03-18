package org.kimfri.userthings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Users {
    private final List<User> userList = new ArrayList<>();

    public boolean addUser(User user) {
        return userList.add(user);
    }

    public List<User> getUserList() {
        return Collections.unmodifiableList(userList);
    }

    public boolean removeAllUsers() {
        return userList.removeAll(getUserList());
    }

    public boolean removeUser(User user) {
        return userList.remove(user);
    }

    public int getAmountOfUsers() {
        return userList.size();
    }
}
