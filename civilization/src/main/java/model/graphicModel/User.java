package model.graphicModel;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import controller.DataBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class User {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("address")
    private String photoAddress;
    @SerializedName("image")
    //private ProfilePhoto photo;

    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<User> players = new ArrayList<>();// it should not save it is just for doing changes on users;
    public static ArrayList<User> allUsers = new ArrayList<>();
    private Integer score;

    public User(String username, String password, String nickname, String photoAddress, int score) throws IOException {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.photoAddress = photoAddress;
        this.score = 0;
        allUsers.add(this);
        addNewUserToDataBase(this);
        addNewUserProfile();

    }


    public void setScore(int score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public static User getUserByUsernameOrNickname(String name, String identifier) {
        ArrayList<User> savedUsers = getUsersFromDataBase();
        for (User user : savedUsers) {
            if (identifier.equals("username") && user.username.equals(name)) {
                return user;
            } else if (identifier.equals("nickname") && user.nickname.equals(name))
                return user;
        }
        return null;
    }

    public void setScoresOnJson(int score) throws IOException {
        ArrayList<User> users = getUsersFromDataBase();
        for (int k = 0; k < DataBase.numberOfUsers(); k++) {
            if (users.get(k).getUsername().equals(this.getUsername())) {
                File file = new File("user" + k + ".json");
                String json = new String(Files.readAllBytes(Paths.get("user" + k + ".json")));
                User user = new Gson().fromJson(json, User.class);
                UserProfile.allUserProfiles.remove(user);
                allUsers.remove(user);
                user.score = score;
                file.delete();
                FileWriter writer = new FileWriter("user" + k + ".json");
                writer.write(new Gson().toJson(user));
                writer.close();
                allUsers.add(k, user);
                UserProfile.allUserProfiles.add(k, new UserProfile(new ProfilePhoto(user.photoAddress), user.username, user.password, user.nickname, user.photoAddress, user.score));
                break;
            }
        }
    }

    public void setPhotoAddress(String photoAddress) throws IOException {

        ArrayList<User> users = getUsersFromDataBase();
        for (int k = 0; k < DataBase.numberOfUsers(); k++) {
            if (users.get(k).getUsername().equals(this.getUsername())) {
                File file = new File("user" + k + ".json");
                String json = new String(Files.readAllBytes(Paths.get("user" + k + ".json")));
                User user = new Gson().fromJson(json, User.class);
                UserProfile.allUserProfiles.remove(user);
                allUsers.remove(user);
                user.photoAddress = photoAddress;
                file.delete();
                FileWriter writer = new FileWriter("user" + k + ".json");
                writer.write(new Gson().toJson(user));
                writer.close();
                allUsers.add(k, user);
                UserProfile.allUserProfiles.add(k, new UserProfile(new ProfilePhoto(user.photoAddress), user.username, user.password, user.nickname, user.photoAddress, user.score));
                break;
            }
        }
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setNickname(String nickname) throws IOException {

        ArrayList<User> users = getUsersFromDataBase();
        for (int i = 0; i < DataBase.numberOfUsers(); i++) {
            if (users.get(i).getUsername().equals(this.getUsername())) {
                File file = new File("user" + i + ".json");
                String json = new String(Files.readAllBytes(Paths.get("user" + i + ".json")));
                User user = new Gson().fromJson(json, User.class);
                allUsers.remove(user);
                UserProfile.allUserProfiles.remove(user);
                user.nickname = nickname;
                file.delete();
                FileWriter writer = new FileWriter("user" + i + ".json");
                writer.write(new Gson().toJson(user));
                writer.close();
                allUsers.add(i, user);
                UserProfile.allUserProfiles.add(i, new UserProfile(new ProfilePhoto(user.photoAddress), user.username, user.password, user.nickname, user.photoAddress, user.score));

                break;
            }
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void passChange(String newPass) throws IOException {

        ArrayList<User> users = getUsersFromDataBase();
        for (int i = 0; i < DataBase.numberOfUsers(); i++) {
            if (users.get(i).getUsername().equals(this.getUsername())) {
                File file = new File("user" + i + ".json");
                String json = new String(Files.readAllBytes(Paths.get("user" + i + ".json")));
                User user = new Gson().fromJson(json, User.class);
                UserProfile.allUserProfiles.remove(user);
                allUsers.remove(user);
                user.password = newPass;
                file.delete();
                FileWriter writer = new FileWriter("user" + i + ".json");
                writer.write(new Gson().toJson(user));
                writer.close();
                allUsers.add(i, user);
                UserProfile.allUserProfiles.add(i, new UserProfile(new ProfilePhoto(user.photoAddress), user.username, user.password, user.nickname, user.photoAddress, user.score));
                break;
            }
        }

    }

    public void removeAccount(User user1) throws IOException {
        ArrayList<User> users = getUsersFromDataBase();
        for (int i = 0; i < DataBase.numberOfUsers(); i++) {
            if (users.get(i).equals(user1)) {
                File file = new File("user" + i + ".json");
                String json = new String(Files.readAllBytes(Paths.get("user" + i + ".json")));
                User user = new Gson().fromJson(json, User.class);
                UserProfile.allUserProfiles.remove(user);
                allUsers.remove(user);
                file.delete();
                break;
            }
        }
    }

    public static void setPlayers(User players) {
        User.players.add(players);
    }

    public static ArrayList<User> getPlayers() {
        return players;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<User> getUsersFromDataBase() {
        int n = 0;
        try {
            n = DataBase.numberOfUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean bool = false;
        for (int i = 0; i < n; i++) {
            for (User allUser : allUsers) {
                if (allUser.username.equals(DataBase.getUserFromDataBase(i).username)) {
                    bool = true;
                    break;
                }
            }
            if (bool)
                break;
            User user = DataBase.getUserFromDataBase(i);

            allUsers.add(DataBase.getUserFromDataBase(i));
        }
        return allUsers;
    }

    public void addNewUserProfile() {
        int n = 0;
        try {
            n = DataBase.numberOfUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean bool = false;
        for (int i = 0; i < n; i++) {
            User user = DataBase.getUserFromDataBase(i);
            for (UserProfile allUser : UserProfile.allUserProfiles) {
                if (allUser.getUsername().equals(user.username)) {
                    bool = true;
                    break;
                }
            }
            if (bool)
                break;
            try {
                //new ImageView(new Image(getClass().getResource("/images/" + user.photoAddress + ".jpg").toExternalForm()))
                UserProfile profile = new UserProfile(new ProfilePhoto(user.photoAddress), user.username, user.password, user.nickname, user.photoAddress, user.score);
                UserProfile.allUserProfiles.add(profile);
            } catch (IOException e) {
                System.out.println("null");
                e.printStackTrace();
            }
        }
    }

    public void addNewUserToDataBase(User user) throws IOException {
        int n = 0;
        n = DataBase.numberOfUsers();
        String fileName = "user" + n + ".json";
        FileWriter writer = new FileWriter(fileName);
        writer.write(new Gson().toJson(user));
        writer.close();
        DataBase.setNumOfUsers();
    }
}
