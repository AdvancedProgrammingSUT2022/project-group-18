package model;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private static ArrayList<User> users = new ArrayList<>();

    public User(String username , String password){
        this.username=username;
        this.password=password;

        User.users.add(this);
    }

    public static User getUserByUsername(String username) {
        for (User user : User.users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public String getPassword(){return password;}
    public String getUsername(){return username;}
    public static void addUser(User user){users.add(user);}
    public void passChange(String newPass){this.password = newPass;}
    public static void removeAccount(User user){users.remove(user);}
}
