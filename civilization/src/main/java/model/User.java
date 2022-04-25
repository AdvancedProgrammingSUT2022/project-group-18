package model;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String nickname;
    private static ArrayList<User> users = new ArrayList<>();

    public User(String username , String password, String nickname){
        this.username=username;
        this.password=password;
        this.nickname = nickname;

        User.users.add(this);
    }

    public static User getUserByUsernameOrNickname(String name, String identifier) {
        for (User user : User.users) {
            if (identifier.equals("username") && user.username.equals(name)) {
                return user;
            } else if(identifier.equals("nickname") && user.nickname.equals(name))
                return user;
        }
        return null;
    }

    public String getPassword(){return password;}
    public String getUsername(){return username;}
    public static void addUser(User user){users.add(user);}
    public void setNickname(String nickname) {this.nickname = nickname;}
    public String getNickname() {return nickname;}
    public void passChange(String newPass){this.password = newPass;}
    public static void removeAccount(User user){users.remove(user);}

    public static ArrayList<User> getUsers() {
        return users;
    }
}
