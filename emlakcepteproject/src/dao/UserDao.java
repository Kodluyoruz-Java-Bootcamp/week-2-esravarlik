package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final List<User> userList = new ArrayList<>();

    public void createUser(User user) {
        userList.add(user);
    }

    public List<User> findAllUsers() {
        return userList;
    }

    public void saveHistory(String history, User user) {
        user.addSearch(history);
    }
}
