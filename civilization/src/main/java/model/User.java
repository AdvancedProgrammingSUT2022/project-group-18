package model;

import com.google.gson.Gson;
import controller.DataBase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String nickname;
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<User> players = new ArrayList<>();// it should not save it is just for doing changes on users;
    public static ArrayList<User> dataBaseUsers = new ArrayList<>();

    public User(String username , String password, String nickname){
        this.username=username;
        this.password=password;
        this.nickname = nickname;
        addNewUserToDataBase(this);
    }

    public static User getUserByUsernameOrNickname(String name, String identifier) {
        for (User user : dataBaseUsers) {
            if (identifier.equals("username") && user.username.equals(name)) {
                return user;
            } else if(identifier.equals("nickname") && user.nickname.equals(name))
                return user;
        }
        return null;
    }

    public String getPassword(){return password;}
    public String getUsername(){return username;}
    public void setNickname(String nickname) {this.nickname = nickname;}
    public String getNickname() {return nickname;}
    public void passChange(String newPass){this.password = newPass;}
    public static void removeAccount(User user){users.remove(user);}
    public static void setPlayers(User players) {User.players.add(players);}
    public static ArrayList<User> getPlayers() {return players;}

    public static ArrayList<User> getUsers() {
        return users;
    }
    public static ArrayList<User> getUsersFromDataBase(){
        int n = 0;
        try {
            n = DataBase.numberOfUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0 ; i<n ; i++){
            dataBaseUsers.add(DataBase.getUserFromDataBase(i));
        }
        return dataBaseUsers;
    }
    public void addNewUserToDataBase(User user){
        int n = 0;
        try {
            n = DataBase.numberOfUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileName = "user" + n + ".json";
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(new Gson().toJson(user));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataBase.setNumOfUsers();
    }
}
