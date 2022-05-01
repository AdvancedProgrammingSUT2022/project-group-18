package view;

import controller.ProfileController;
import enums.Message;
import enums.Regexes;

import java.util.regex.Matcher;

public class ProfileView extends View{
    ProfileController controller = new ProfileController();
    @Override
    public void run() {
        String input = getInput();
        Matcher matcher;
        if((matcher = Regexes.getCommand(input, Regexes.MENUENTER)) != null)
            System.out.println(controller.enterMenu(matcher).toString());
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_NICKNAME)) != null)
            System.out.println(controller.changeNickname(matcher));
        else if(controller.changePassRegexes(input) != null)
            System.out.println(controller.changePassword(matcher));
        else if(Regexes.getCommand(input, Regexes.EXITMENU) != null)
            controller.goToMainMenu();
        else if(Regexes.getCommand(input, Regexes.SHOW_CURRENT_MENU) != null)
            System.out.println(controller.showCurrentMenu());
        else
            System.out.println(Message.INVALID);

        this.run();
    }
}
