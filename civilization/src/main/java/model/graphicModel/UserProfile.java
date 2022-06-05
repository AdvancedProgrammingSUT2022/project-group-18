package model.graphicModel;


import java.io.IOException;
import java.util.ArrayList;

public class UserProfile {
    private ProfilePhoto photo;
    private String username;
    private String password;
    private String nickname;
    private String photoAddress;

    private Integer score;
    public static ArrayList<UserProfile> allUserProfiles = new ArrayList<>();


    public UserProfile(ProfilePhoto photo, String username, String password, String nickname, String photoAddress, int score) throws IOException {
        this.photo = photo;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.photoAddress = photoAddress;
        this.score = 0;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public ProfilePhoto getPhoto() {
        return photo;
    }

    public Integer getScore() {
        return score;
    }

    public static ArrayList<UserProfile> getAllUserProfiles() {
        return allUserProfiles;
    }
}
