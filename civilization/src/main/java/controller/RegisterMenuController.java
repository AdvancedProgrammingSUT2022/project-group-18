package controller;

import enums.Message;
import model.User;
import view.MainMenuView;
import view.ProfileView;
import view.View;

import javax.swing.*;
import java.util.Locale;
import java.util.regex.Matcher;

public class RegisterMenuController extends Controller {

    public Message enterMenu(Matcher matcher) {
        String menuName = matcher.group("menuName");
        if (View.getIsLogedIn() == null) //TODO in shartay bishtari vase error dadan bayad dashte bashe
            return Message.LOGINERROR;
        if (View.getInMenu() != null)
            return Message.IVALIDENTERMENU;

        View.setInMenu(menuName.toLowerCase(Locale.ROOT));
        goToMenu(menuName.toLowerCase(Locale.ROOT));

        return null;
    }

    public void exitMenu() {
        String menuName = View.getInMenu().toLowerCase(Locale.ROOT);
        if (menuName.equals("login menu"))
            View.getScanner().close();
        else if (menuName.equals("main menu"))
        //TODO go to login
        else
        //TODO go to main menu

    }

    public Message showCurrentMenu() {
        if(View.getInMenu().equals("main menu"))
            return Message.MAINMENU;
        else if(View.getInMenu().equals("login menu"))
            return Message.LOGINMENU;
        return null;
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

    public void goToMainMenu() {
        MainMenuView view = new MainMenuView();
        view.run();
    }

}