package service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    /**
     * Creates a user if the password
     * has more than five characters.
     *
     * @param user
     * @return void
     */
    public void createUser(User user) {
        if (user.getPassword().length() < 5) {
            System.out.println("Password must be at least 5 characters. ");
        } else {
            userRepository.createUser(user);
        }
    }

    public List<User> getAllUser() {
        return userRepository.findAllUsers();
    }

    /**
     * Prints all articles.
     *
     * @return void
     */
    public void printAllUser() {
        getAllUser().forEach(user -> System.out.println("createUser :: " + user.getUserName()));

    }
}
