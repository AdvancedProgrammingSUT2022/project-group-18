package controller;
import enums.Message;
import model.User;
import view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterMenuController extends Controller{

    public Message enterMenu(Matcher matcher) {
        String menuName = matcher.group("menuName");
        if(View.getIsLogedIn() == null)
            return Message.LOGINERROR;
        if(View.getInMenu() != null)
            return Message.IVALIDENTERMENU;

        View.setInMenu(menuName);
        return Message.change;
    }

}