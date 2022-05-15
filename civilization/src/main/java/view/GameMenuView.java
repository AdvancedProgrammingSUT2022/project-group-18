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
            //if(Unit.canMove=={
            System.out.println( "movement mission was successful" );
            // }
            else
            System.out.println( "movement mission was'nt successful" );
        } else if (Regexes.getCommand(input, Regexes.SLEEP) != null) {
            System.out.println("sleep mood was turned on");
        } else if (Regexes.getCommand(input, Regexes.ALERT) != null) {
            System.out.println("ready mood was turned on");
        } else if (Regexes.getCommand(input, Regexes.FORTIFY) != null) {
            System.out.println("unit defensive power incraased");
        } else if (Regexes.getCommand(input, Regexes.FORTIFY_HEAL) != null) {
            System.out.println("unit health incraased");
        } else if (Regexes.getCommand(input, Regexes.GARRISON) != null) {
            System.out.println("the unit is ready to defensive it's city ");
        } else if (Regexes.getCommand(input, Regexes.SETUP_RANGED) != null) {
            System.out.println("the unit chose it's enemy");
        } else if ((matcher = Regexes.getCommand(input, Regexes.ATTACK_POSITION)) != null) {
            System.out.println("enter your command");
        } else if (Regexes.getCommand(input, Regexes.FOUND_CITY) != null) {
            System.out.println("the settler unit found a new city");
        } else if (Regexes.getCommand(input, Regexes.CANCEL_COMMAND) != null) {
            System.out.println("This mission canceled");
        } else if (Regexes.getCommand(input, Regexes.WAKE) != null) {
            System.out.println("This unit woke up");
        } else if (Regexes.getCommand(input, Regexes.DELETE) != null) {
            System.out.println("This unit was removed ");
        } else if (Regexes.getCommand(input, Regexes.BUILD_ROAD) != null) {
            //if(Worker,foundRoad())
            System.out.println("the road was built");
        } else if (Regexes.getCommand(input, Regexes.BUILD_RAILWAy) != null) {
            //if(Worker.railWay)
            System.out.println("the railway was built");
        } else if (Regexes.getCommand(input, Regexes.BUILD_FARM) != null) {
            System.out.println("the farm was built");
        } else if (Regexes.getCommand(input, Regexes.BUILD_MINE) != null) {
            System.out.println("the mine was built");
        } else if (Regexes.getCommand(input, Regexes.BUILD_TRADING_POST) != null) {
            System.out.println("the trading post was built");
        } else if (Regexes.getCommand(input, Regexes.BUILD_LUMBER_MILL) != null) {
            System.out.println("the lumber mill was built");
        } else if (Regexes.getCommand(input, Regexes.BUILD_PASTURE) != null) {
            System.out.println("the pasture was built");
        } else if (Regexes.getCommand(input, Regexes.BUILD_CAMP) != null) {
            System.out.println("the camp was built");
        } else if (Regexes.getCommand(input, Regexes.BUILD_PLANTATION) != null) {
            System.out.println("the plantation was built");
        } else if (Regexes.getCommand(input, Regexes.BUILD_QUARRY) != null) {
            System.out.println("the quarry was built");
        } else if (Regexes.getCommand(input, Regexes.REMOVE_JUNGLE) != null) {
            System.out.println("the jungle was removed");
        } else if (Regexes.getCommand(input, Regexes.REMOVE_forest) != null) {
            System.out.println("the forest was removed");
        } else if (Regexes.getCommand(input, Regexes.REMOVE_MARSH) != null) {
            System.out.println("the marsh was removed");
        } else if (Regexes.getCommand(input, Regexes.REMOVE_ROUD) != null) {
            //if(worker.deleteRoad)
            System.out.println("the road was removed");
        } else if (Regexes.getCommand(input, Regexes.REPAIR) != null) {
            System.out.println("the worker is repairing");
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
