package view;

import controller.GameController;
import enums.Message;
import enums.Regexes;
import model.unit.Unit;

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
            System.out.println("created new unit");
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
            if(1 == 1){//Unit.canMove
            System.out.println( "movement mission was successful" );
             }
            else
            System.out.println( "movement mission wasn't successful" );
        } else if (Regexes.getCommand(input, Regexes.SLEEP) != null) {
            System.out.println(Message.SLEEP);
        } else if (Regexes.getCommand(input, Regexes.ALERT) != null) {
            System.out.println(Message.ALERT);
        } else if (Regexes.getCommand(input, Regexes.FORTIFY) != null) {
            System.out.println(Message.FORTIFY);
        } else if (Regexes.getCommand(input, Regexes.FORTIFY_HEAL) != null) {
            System.out.println(Message.FORTIFY_HEAL);
        } else if (Regexes.getCommand(input, Regexes.GARRISON) != null) {
            System.out.println(Message.GARRISON);
        } else if (Regexes.getCommand(input, Regexes.SETUP_RANGED) != null) {
            System.out.println(Message.SETUP_RANGED);
        } else if ((matcher = Regexes.getCommand(input, Regexes.ATTACK_POSITION)) != null) {
            System.out.println(Message.ATTACK_POSITION);
        } else if (Regexes.getCommand(input, Regexes.FOUND_CITY) != null) {
            System.out.println(Message.FOUND_CITY);
        } else if (Regexes.getCommand(input, Regexes.CANCEL_COMMAND) != null) {
            System.out.println(Message.CANCEL_COMMAND);
        } else if (Regexes.getCommand(input, Regexes.WAKE) != null) {
            System.out.println(Message.WAKE);
        } else if (Regexes.getCommand(input, Regexes.DELETE) != null) {
            System.out.println(Message.DELETE);
        } else if (Regexes.getCommand(input, Regexes.BUILD_ROAD) != null) {
            //if(Worker,foundRoad())
            System.out.println(Message.BUILD_ROAD);
        } else if (Regexes.getCommand(input, Regexes.BUILD_RAILWAY) != null) {
            //if(Worker.railWay)
            System.out.println(Message.BUILD_ROAD);
        } else if (Regexes.getCommand(input, Regexes.BUILD_FARM) != null) {
            System.out.println(Message.BUILD_FARM);
        } else if (Regexes.getCommand(input, Regexes.BUILD_MINE) != null) {
            System.out.println(Message.BUILD_MINE);
        } else if (Regexes.getCommand(input, Regexes.BUILD_TRADING_POST) != null) {
            System.out.println(Message.BUILD_TRADING_POST);
        } else if (Regexes.getCommand(input, Regexes.BUILD_LUMBER_MILL) != null) {
            System.out.println(Message.BUILD_LUMBER_MILL);
        } else if (Regexes.getCommand(input, Regexes.BUILD_PASTURE) != null) {
            System.out.println(Message.BUILD_PASTURE);
        } else if (Regexes.getCommand(input, Regexes.BUILD_CAMP) != null) {
            System.out.println(Message.BUILD_CAMP);
        } else if (Regexes.getCommand(input, Regexes.BUILD_PLANTATION) != null) {
            System.out.println(Message.BUILD_PLANTATION);
        } else if (Regexes.getCommand(input, Regexes.BUILD_QUARRY) != null) {
            System.out.println(Message.BUILD_QUARRY);
        } else if (Regexes.getCommand(input, Regexes.REMOVE_JUNGLE) != null) {
            System.out.println(Message.REMOVE_JUNGLE);
        } else if (Regexes.getCommand(input, Regexes.REMOVE_FOREST) != null) {
            System.out.println(Message.REMOVE_FOREST);
        } else if (Regexes.getCommand(input, Regexes.REMOVE_MARSH) != null) {
            System.out.println(Message.REMOVE_MARSH);
        } else if (Regexes.getCommand(input, Regexes.REMOVE_ROAD) != null) {
            //if(worker.deleteRoad)
            System.out.println(Message.REMOVE_ROAD);
        } else if (Regexes.getCommand(input, Regexes.REPAIR) != null) {
            System.out.println(Message.REPAIR);
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
