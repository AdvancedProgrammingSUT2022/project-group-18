package view;

import controller.GameController;
import enums.Message;
import enums.Regexes;

import java.util.regex.Matcher;

public class GameMenuView extends View {
    GameController controller = new GameController();

    @Override
    public void run() {
        String input = getInput();
        Matcher matcher;

        if (Regexes.getCommand(input, Regexes.EXIT_MENU) != null)
            controller.goToMainMenu();
        else if ((matcher = Regexes.getCommand(input, Regexes.MENU_ENTER)) != null)
            System.out.println(controller.enterMenu(matcher).toString());
        else if (Regexes.getCommand(input, Regexes.SHOW_CURRENT_MENU) != null)
            System.out.println(controller.showCurrentMenu());
        else if (Regexes.getCommand(input, Regexes.EXIT_GAME) != null)
            controller.exitMenu();
        else if ((matcher = Regexes.getCommand(input, Regexes.INCREASE_TURN)) != null) {

        } else if ((matcher = Regexes.getCommand(input, Regexes.INCREASE_GOLD)) != null) {

        } else if ((matcher = Regexes.getCommand(input, Regexes.INCREASE_BEAKERS)) != null) {

        } else if (Regexes.getCommand(input, Regexes.RESEARCH) != null) {
        } else if (Regexes.getCommand(input, Regexes.UNITS) != null) {
        } else if (Regexes.getCommand(input, Regexes.CITIES) != null) {
        } else if (Regexes.getCommand(input, Regexes.DIPLOMACY) != null) {
        } else if (Regexes.getCommand(input, Regexes.VICTORY) != null) {
        } else if (Regexes.getCommand(input, Regexes.DEMOGRAPHICS) != null) {
        } else if (Regexes.getCommand(input, Regexes.NOTIFICATIONS) != null)
            System.out.println(controller.showNotificationsHistory());
        else if (Regexes.getCommand(input, Regexes.MILITARY) != null) {
        } else if (Regexes.getCommand(input, Regexes.ECONOMIC) != null) {
        } else if (Regexes.getCommand(input, Regexes.DIPLOMATIC) != null) {
        } else if (Regexes.getCommand(input, Regexes.DEALS) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.UNIT_COMBAT_POSITION)) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.UNIT_NONCOMBAT_POSITION)) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.CITY_NAME)) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.CITY_POSITION)) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.MOVETO_POSITION)) != null) {
        } else if (Regexes.getCommand(input, Regexes.SLEEP) != null) {
        } else if (Regexes.getCommand(input, Regexes.ALERT) != null) {
        } else if (Regexes.getCommand(input, Regexes.FORTIFY) != null) {
        } else if (Regexes.getCommand(input, Regexes.FORTIFY_HEAL) != null) {
        } else if (Regexes.getCommand(input, Regexes.GARRISON) != null) {
        } else if (Regexes.getCommand(input, Regexes.SETUP_RANGED) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.ATTACK_POSITION)) != null) {
        } else if (Regexes.getCommand(input, Regexes.FOUND_CITY) != null) {
        } else if (Regexes.getCommand(input, Regexes.CANCEL_MISSION) != null) {
        } else if (Regexes.getCommand(input, Regexes.WAKE) != null) {
        } else if (Regexes.getCommand(input, Regexes.DELETE) != null) {
        } else if (Regexes.getCommand(input, Regexes.BUILD_ROAD) != null) {
        } else if (Regexes.getCommand(input, Regexes.BUILD_RAILROAD) != null) {
        } else if (Regexes.getCommand(input, Regexes.BUILD_FARM) != null) {
        } else if (Regexes.getCommand(input, Regexes.BUILD_MINE) != null) {
        } else if (Regexes.getCommand(input, Regexes.BUILD_TRADING_POST) != null) {
        } else if (Regexes.getCommand(input, Regexes.BUILD_LUMBER_MILL) != null) {
        } else if (Regexes.getCommand(input, Regexes.BUILD_PASTURE) != null) {
        } else if (Regexes.getCommand(input, Regexes.BUILD_CAMP) != null) {
        } else if (Regexes.getCommand(input, Regexes.BUILD_PLANTATION) != null) {
        } else if (Regexes.getCommand(input, Regexes.BUILD_QUARRY) != null) {
        } else if (Regexes.getCommand(input, Regexes.REMOVE_JUNGLE) != null) {
        } else if (Regexes.getCommand(input, Regexes.REMOVE_ROUTE) != null) {
        } else if (Regexes.getCommand(input, Regexes.REPAIR) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.SHOW_POSITION)) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.SHOW_CITY_NAME)) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.MOVE_RIGHT)) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.MOVE_LEFT)) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.MOVE_UP)) != null) {
        } else if ((matcher = Regexes.getCommand(input, Regexes.MOVE_DOWN)) != null) {
        } else
            System.out.println(Message.INVALID);
        this.run();
    }
}
