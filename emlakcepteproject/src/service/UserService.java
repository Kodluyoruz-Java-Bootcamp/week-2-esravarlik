package service;

import dao.UserDao;
import model.User;

import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();


    // Singleton Pattern
    private static final UserService userService = new UserService();

	private UserService() {

	}
	public static UserService getDifferentInstance() {
		return  new UserService();
	}

	public static UserService getSameInstance() {
		return userService;
	}

    public void createUser(User user) {
        if (user.getPassword().length() < 5) {
            System.out.println("Password must be at least 5 characters. ");
        } else {
            userDao.createUser(user);
        }
    }

    public List<User> getAllUser() {
        return userDao.findAllUsers();
    }

    public void printAllUser() {
        getAllUser().forEach(user -> System.out.println("createUser :: " + user.getName()));

    }

    public void updatePassword(User user, String newPassword) {
        user.setPassword(newPassword);
        userDao.createUser(user);
    }

}
