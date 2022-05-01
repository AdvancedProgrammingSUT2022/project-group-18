package view;

import controller.GameController;
import enums.Message;
import enums.Regexes;

import java.util.regex.Matcher;

public class GameMenuView extends View{
    GameController controller = new GameController();
    @Override
    public void run() {
        String input = getInput();
        Matcher matcher;

        if(Regexes.getCommand(input, Regexes.EXITMENU) != null)
            controller.goToMainMenu();
        else if((matcher = Regexes.getCommand(input, Regexes.MENUENTER)) != null)
            System.out.println(controller.enterMenu(matcher).toString());
        else if(Regexes.getCommand(input, Regexes.SHOW_CURRENT_MENU) != null)
            System.out.println(controller.showCurrentMenu());
        else
            System.out.println(Message.INVALID);
        this.run();
    }
}
