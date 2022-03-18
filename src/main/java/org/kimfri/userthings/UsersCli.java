package org.kimfri.userthings;

import java.util.List;

public class UsersCli {
    public static void main(String[] args) {
        UsersCli usersCli = new UsersCli();
        usersCli.doit();
    }

    private void doit() {
        Users users = new Users();
        final User kim = new User("Kim", 47);
        users.addUser(kim);

        final List<User> userList = users.getUserList();
        System.err.println("local userlist.size: " + userList.size());
        System.err.println("users.userlist.size: " + users.getAmountOfUsers());

        System.err.println("Wille removed: " + users.removeUser(new User("Wille", 17)));
        System.err.println("users.userlist.size: " + users.getAmountOfUsers());
        System.err.println("remove all: " + users.removeAllUsers());
        System.err.println("users.userlist.size: " + users.getAmountOfUsers());
    }
}
