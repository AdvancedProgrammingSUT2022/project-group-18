package view;

import controller.MainMenuController;
import enums.Message;
import enums.Regexes;


public class MainMenuView extends View{
    MainMenuController controller = new MainMenuController();
    @Override
    public void run() {
        String input = getInput();

        if(Regexes.getCommand(input, Regexes.PLAY_GAME) != null) {
            Message message =controller.goToGame(input);
            if(message.equals(Message.PLAY_GAME))
                controller.startGame();
        } else if(Regexes.getCommand(input, Regexes.USER_LOGOUT) != null)
            controller.logout();
        else if(Regexes.getCommand(input, Regexes.EXITMENU) != null)
            controller.logout();
        else if(Regexes.getCommand(input, Regexes.SHOW_CURRENT_MENU) != null)
            System.out.println(controller.showCurrentMenu());
        else
            System.out.println(Message.INVALID);
        this.run();
    }
}
