package view;

import controller.RegisterMenuController;
import enums.Regexes;

import java.util.regex.Matcher;

public class RegesterMenuView extends View{
    RegisterMenuController controller = new RegisterMenuController();

    public void run() {
        String input = getInput();
        Matcher matcher;
        if((matcher = Regexes.getCommand(input, Regexes.MENUENTER)) != null)
            controller.enterMenu(matcher);



    }

}
