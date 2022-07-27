package Chatserver.Controller;

import Chatserver.Model.Database;
import Chatserver.Model.User;

public class UserController {
    public static User getUserByNickname(String nickname) {
        for (User user : Database.getInstance().getUsers()) {
            if (user.getNickname().equals(nickname)) {
                return user;
            }
        }
        return null;
    }

    public static User getUserById(int id) {
        for (User user : Database.getInstance().getUsers()) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}

