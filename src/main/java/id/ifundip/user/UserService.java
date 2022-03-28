package id.ifundip.user;

import java.util.ArrayList;

public class UserService {
    private ArrayList<User> users;

    public UserService() {
        users = new ArrayList<User>();

        users.add(new User("john@gmail.com", "john"));
        users.add(new User("jane@gmail.com", "jane"));
    }

    public User whereEmail(String email) {
        for (User user : users) {
            if (email == user.getEmail())
                return user;
        }

        return new User();
    }
}
