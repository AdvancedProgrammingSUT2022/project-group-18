package controller;

import enums.Message;
import model.User;

import java.util.regex.Matcher;

public class ProfileController extends Controller{
    public void passchange(Matcher matcher) {
        boolean isValid = false;
        if (matcher == null) System.out.println(Message.Invalid);
        else {
            String username = matcher.group("username");
            String oldPass = matcher.group("oldpassword");
            String newPass = matcher.group("newpassword");
            System.out.println(controller.passChange(username, oldPass, newPass));
            int x;
        }

        this.run();
    }

    public void chngeNickname(Matcher matcher) {
        String oldNickName = matcher.group("oldNickname");
        String newNicknam = matcher.group("newNickname");
        if(User.getUserByUsername(oldNickName).equals(newNicknam))
            System.out.println("user with nickName already exist");
        else System.out.println("user changed successfully!");
    }
}
