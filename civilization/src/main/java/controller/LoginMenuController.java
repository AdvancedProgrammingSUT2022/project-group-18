package controller;

import com.google.gson.Gson;
import enums.Message;
import enums.Regexes;
import model.User;
import view.View;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;

public class LoginMenuController extends Controller {

    public void exitMenu() {
            View.getScanner().close();
    }

    public String creatUser(Matcher matcher) {
        String username = matcher.group("username");
        String password = matcher.group("password");
        String nickname = matcher.group("nickname");

        if(User.getUserByUsernameOrNickname(username, "username") != null)
            return Message.USER_EXIST_USERNAME_ONE + username + Message.USER_EXIST_USERNAME_TWO;
        else if(User.getUserByUsernameOrNickname(nickname, "nickname") != null)
            return Message.USER_EXIST_NICKNAME_ONE + nickname + Message.USER_EXIST_USERNAME_TWO;
        else
            View.setIsLogedIn(new User(username,password,nickname));
            return Message.USERCREAT.toString();
    }

    public Matcher matchCreateUser(String input) {
        Matcher matcher;
        if((matcher = Regexes.getCommand(input, Regexes.CREAT_USER1)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CREAT_USER2)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CREAT_USER3)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CREAT_USER4)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CREAT_USER5)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CREAT_USER6)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CREAT_USER7)) != null)
            return matcher;

        return null;
    }

    public Matcher matchLogin(String input) {
        Matcher matcher;
        if((matcher = Regexes.getCommand(input, Regexes.USER_LOGIN1)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.USER_LOGIN2)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.USER_LOGIN3)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.USER_LOGIN4)) != null)
            return matcher;
        return null;
    }
    public Message loginUser(Matcher matcher) {
        String username = matcher.group("username");
        String password = matcher.group("password");
        if(User.getUserByUsernameOrNickname(username, "username") == null)
            return Message.NOT_MATCH;
        else if(!User.getUserByUsernameOrNickname(username, "username").getPassword().equals(password))
            return Message.NOT_MATCH;
        else
            View.setIsLogedIn(User.getUserByUsernameOrNickname(username, "username"));
            return Message.LOGIN_USER;
    }

    public void addNewUserToDataBase(User user ){
        int n = DataBase.numberOfUsers();
        String fileName = "user" + n + ".json";
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(new Gson().toJson(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataBase.setNumOfUsers();
    }

}