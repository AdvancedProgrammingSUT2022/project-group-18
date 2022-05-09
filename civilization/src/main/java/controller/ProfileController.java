package controller;


import enums.Message;
import enums.Regexes;
import model.User;
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

    public Matcher changePassRegexes(String input) {
        Matcher matcher;
        if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD1)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD2)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD3)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD4)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD5)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD6)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD11)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD12)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD13)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD14)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD15)) != null)
            return matcher;
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_PASSWORD16)) != null)
            return matcher;
        return null;
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
