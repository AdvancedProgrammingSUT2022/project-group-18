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

    public void setPhoto(ProfilePhoto photo) {
        this.photo = photo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public static void setAllUserProfiles(ArrayList<UserProfile> allUserProfiles) {
        UserProfile.allUserProfiles = allUserProfiles;
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
