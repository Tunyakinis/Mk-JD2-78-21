package by.it_academy.jd2.database;

import by.it_academy.jd2.core.dto.Client;

import java.util.ArrayList;
import java.util.List;

public class UsersDatabase {
    private static final List<Client> userList = new ArrayList<>();

    public static void addUser(Client userObject) {
        userList.add(userObject);
    }

    public static Client getUser(String login) {
        for (Client user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public static List<Client> getUserList(){
        return userList;
    }
}
