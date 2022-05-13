package view;

import controller.MainMenuController;
import enums.Message;
import enums.Regexes;

import java.util.regex.Matcher;


public class MainMenuView extends View{
    MainMenuController controller = new MainMenuController();
    @Override
    public void run() {
        String input = getInput();
        Matcher matcher;

        if((matcher = Regexes.getCommand(input, Regexes.MENU_ENTER)) != null) {
            Message message = controller.enterMenu(matcher);
            System.out.println(message);
            if(message.equals(Message.PLAY_GAME))
                controller.startGame();
        }
        else if(Regexes.getCommand(input, Regexes.PLAY_GAME) != null) {
            Message message =controller.goToGame(input);
            System.out.println(message);
            if(message.equals(Message.PLAY_GAME))
                controller.startGame();
        } else if(Regexes.getCommand(input, Regexes.USER_LOGOUT) != null) {
            System.out.println(Message.USER_LOGOUT);
            controller.logout();
        }
        else if(Regexes.getCommand(input, Regexes.EXIT_MENU) != null) {
            System.out.println(Message.USER_LOGOUT);
            controller.logout();
        }
        else if(Regexes.getCommand(input, Regexes.SHOW_CURRENT_MENU) != null)
            System.out.println(controller.showCurrentMenu());
        else
            System.out.println(Message.INVALID);
        this.run();
    }
}
