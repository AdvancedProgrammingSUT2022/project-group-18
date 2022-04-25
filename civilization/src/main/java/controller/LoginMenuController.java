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

    public Message enterMenu(Matcher matcher) {
        String menuName = matcher.group("menuName");
        if (View.getIsLogedIn() == null)
            return Message.LOGINERROR;
        else if (View.getInMenu().toLowerCase(Locale.ROOT).equals("game menu") || View.getInMenu().toLowerCase(Locale.ROOT).equals("profile menu"))
            return Message.IVALIDENTERMENU;

        View.setInMenu(menuName);
        if(menuName.toLowerCase(Locale.ROOT).equals("main menu"))
            goToMainMenu();
        else if(menuName.toLowerCase(Locale.ROOT).equals("login menu"))
            logout();
        else if(menuName.toLowerCase(Locale.ROOT).equals("profile menu"))
            goToProfile();
        else if(menuName.toLowerCase(Locale.ROOT).equals("game menu"))
            startGame();
        else
            return Message.INVALID_MENU_NAME;

        return null;
    }

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

    public Matcher matchLogin(String input) {
        Matcher matcher;
        if((matcher = Regexes.getCommand(input, Regexes.USER_LOGIN)) != null)
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