package controller;


import enums.Message;
import model.User;
import view.MainMenuView;
import view.View;

import java.util.regex.Matcher;

public class ProfileController extends Controller{

    public String changeNickname(Matcher matcher) {
        String nickname = matcher.group("nickname");
        if(User.getUserByUsernameOrNickname(nickname, "nickname") != null)
            return Message.USER_EXIST_NICKNAME_ONE + nickname + Message.USER_EXIST_USERNAME_TWO;
        else {
            View.getIsLogedIn().setNickname(nickname);
            return Message.CHANGE_NICKNAME.toString();
        }
    }

    public Message changePassword(Matcher matcher) {
        String currentPass= matcher.group("currentPass");
        String newPass = matcher.group("newPass");
        if(!View.getIsLogedIn().getPassword().equals(currentPass))
            return Message.PASS_INVALID;
        else if(View.getIsLogedIn().getPassword().equals(newPass))
            return Message.SAME_PASS;
        else {
            View.getIsLogedIn().passChange(newPass);
            return Message.CHANGE_PASSWORD;
        }
    }

}
