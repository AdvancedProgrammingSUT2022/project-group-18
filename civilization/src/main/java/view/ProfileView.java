package view;

import controller.ProfileController;
import enums.Message;
import enums.Regexes;

import java.io.IOException;
import java.util.regex.Matcher;

public class ProfileView extends View{
    ProfileController controller = new ProfileController();
    @Override
    public void run() throws IOException {
        String input = getInput();
        Matcher matcher;
        if((matcher = Regexes.getCommand(input, Regexes.MENU_ENTER)) != null)
            System.out.println(controller.enterMenu(matcher).toString());
        else if((matcher = Regexes.getCommand(input, Regexes.CHANGE_NICKNAME)) != null)
            System.out.println(controller.changeNickname(matcher));
        else if((matcher = controller.changePassRegexes(input)) != null)
            System.out.println(controller.changePassword(matcher));
        else if(Regexes.getCommand(input, Regexes.EXIT_MENU) != null)
            controller.goToMainMenu();
        else if(Regexes.getCommand(input, Regexes.SHOW_CURRENT_MENU) != null)
            System.out.println(controller.showCurrentMenu());
        else if(Regexes.getCommand(input, Regexes.CHANGE_USERNAME) != null)
            System.out.println(Message.CANT_CHANG_USERNAME);
        else
            System.out.println(Message.INVALID);

        this.run();
    }
}
