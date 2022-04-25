package controller;


import enums.Message;
import model.User;
import view.GameMenuView;
import view.LoginMenuView;
import view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenuController extends Controller{

    public Message goToGame(String input) {
        input = input.replaceAll("play game ", "");
        Pattern password = Pattern.compile("([-][-]player[0-9] (?<username>\\S+))");
        Matcher matcher = password.matcher(input);
        while(matcher.find()) {
            String username = matcher.group("username");
            if(User.getUserByUsernameOrNickname(username, "username") == null)
                return Message.USER_NOT_EXIST;
        }
        return Message.PLAY_GAME;
    }


}
