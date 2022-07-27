package Chatserver.Model;

import java.util.ArrayList;

public class Database {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Message> messages = new ArrayList<>();
    private static Database instance;

    private Database() {

    }

    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public User newUserConnected(String nickname) {
        User user = new User();
        user.setNickname(nickname);
        user.setId(this.users.size());
        users.add(user);
        return user;
    }

    public User getUserById(int id) {
        return users.get(id);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}

