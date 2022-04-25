package view;

import controller.GameController;
import enums.Message;
import enums.Regexes;

public class GameMenuView extends View{
    GameController controller = new GameController();
    @Override
    public void run() {
        String input = getInput();
        if(Regexes.getCommand(input, Regexes.EXITMENU) != null)
            controller.goToMainMenu();
        else if(Regexes.getCommand(input, Regexes.SHOW_CURRENT_MENU) != null)
            System.out.println(controller.showCurrentMenu());
        else
            System.out.println(Message.INVALID);
    }
}
