package view;
import model.unit.Unit;
import controller.GameController;
import enums.Message;
import enums.Regexes;
import model.BaseCivilization;
import model.City;

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
            increaseTurn(matcher);
        } else if ((matcher = Regexes.getCommand(input, Regexes.INCREASE_GOLD)) != null) {
            increaseGold(matcher);
        } else if ((matcher = Regexes.getCommand(input, Regexes.INCREASE_HAPPINESS)) != null) {
            increaseHappiness(matcher);
        }else if (Regexes.getCommand(input, Regexes.INCREAS_CITY_HP) != null)
            increaseCityHP(matcher);
        else if (Regexes.getCommand(input, Regexes.INCREASE_CITY_STRENGTH) != null)
            increaseCityStrength(matcher);
        else if (Regexes.getCommand(input, Regexes.RESEARCH) != null) {
        } else if (Regexes.getCommand(input, Regexes.UNITS) != null) {
            System.out.println("created new unit");
        } else if (Regexes.getCommand(input, Regexes.CITIES) != null) {
            citiesPanel();
        } else if (Regexes.getCommand(input, Regexes.DIPLOMACY) != null) {
            diplimacypanel();
        } else if (Regexes.getCommand(input, Regexes.VICTORY) != null) {
            System.out.println("there is a long way to victory");
        } else if (Regexes.getCommand(input, Regexes.DEMOGRAPHICS) != null) {
            demographicPanel(getInCity());
        } else if (Regexes.getCommand(input, Regexes.NOTIFICATIONS) != null)
            System.out.println(controller.showNotificationsHistory());
        else if (Regexes.getCommand(input, Regexes.MILITARY) != null) {
            militaryOverview(getInCity());
        } else if (Regexes.getCommand(input, Regexes.ECONOMIC) != null) {
            economicOverview(getInCity());
        } else if (Regexes.getCommand(input, Regexes.DIPLOMATIC) != null) {
            System.out.println();
        } else if (Regexes.getCommand(input, Regexes.DEALS) != null) {
            System.out.println("we have no deals in first phase");
        } else if ((matcher = Regexes.getCommand(input, Regexes.UNIT_COMBAT_POSITION)) != null) {
            controller.getUnMilitaryUnitByGPS(Integer.parseInt(matcher.group("X")) , Integer.parseInt(matcher.group("Y")));
        } else if ((matcher = Regexes.getCommand(input, Regexes.UNIT_NONCOMBAT_POSITION)) != null) {
            controller.getMilitaryUnitByGPS(Integer.parseInt(matcher.group("X")) , Integer.parseInt(matcher.group("Y")));
        } else if ((matcher = Regexes.getCommand(input, Regexes.CITY_NAME)) != null) {
            City city = controller.getCityByName(matcher.group("name"));
            economicOverview(city);
            View.setInCity(city);
        } else if ((matcher = Regexes.getCommand(input, Regexes.CITY_POSITION)) != null) {
            City city = controller.getCityByGps(Integer.parseInt(matcher.group("X")) , Integer.parseInt(matcher.group("Y")));
            economicOverview(city);
            View.setInCity(city);
        } else if ((matcher = Regexes.getCommand(input, Regexes.MOVETO_POSITION)) != null) {
            if(1 == 1){//Unit.canMove
            System.out.println( "movement mission was successful" );
             }
            else
            System.out.println( "movement mission wasn't successful" );
        } else if (Regexes.getCommand(input, Regexes.SLEEP) != null) {
            System.out.println("sleep mode was turned on");
        } else if (Regexes.getCommand(input, Regexes.ALERT) != null) {
            System.out.println("ready mode was turned on");
        } else if (Regexes.getCommand(input, Regexes.FORTIFY) != null) {
            System.out.println("unit defensive power increased");
        } else if (Regexes.getCommand(input, Regexes.FORTIFY_HEAL) != null) {
            System.out.println("unit health increased");
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
        } else if (Regexes.getCommand(input, Regexes.BUILD_RAILWAY) != null) {
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
        } else if (Regexes.getCommand(input, Regexes.REMOVE_FOREST) != null) {
            System.out.println("the forest was removed");
        } else if (Regexes.getCommand(input, Regexes.REMOVE_MARSH) != null) {
            System.out.println("the marsh was removed");
        } else if (Regexes.getCommand(input, Regexes.REMOVE_ROAD) != null) {
            //if(worker.deleteRoad)
            System.out.println("the road was removed");
        } else if (Regexes.getCommand(input, Regexes.REPAIR) != null) {
            System.out.println("the worker is repairing");
        } else if ((matcher = Regexes.getCommand(input, Regexes.SHOW_POSITION)) != null) {
            System.out.println("it is just graphic and you want me this in this phase? shame on you");
        } else if ((matcher = Regexes.getCommand(input, Regexes.SHOW_CITY_NAME)) != null) {
            controller.getCityByName(matcher.group("name"));
        } else if ((matcher = Regexes.getCommand(input, Regexes.MOVE_RIGHT)) != null) {
            Unit.moveUnit();
            System.out.println("move to right");
        } else if ((matcher = Regexes.getCommand(input, Regexes.MOVE_LEFT)) != null) {
             Unit.moveUnit();
            System.out.println("move to right");
        } else if ((matcher = Regexes.getCommand(input, Regexes.MOVE_UP)) != null) {
             Unit.moveUnit();
            System.out.println("move to right");
        } else if ((matcher = Regexes.getCommand(input, Regexes.MOVE_DOWN)) != null) {
             Unit.moveUnit();
            System.out.println("move to right");
        } else
            System.out.println(Message.INVALID);
        this.run();
    }


    public void economicOverview(City city){
        System.out.println("Population : " + city.getCityPopulation() + " Strength : " + city.getCityStrength()+
                " Food : "+ city.getCityFood() +" Science : " + city.getOwner().getScienceTotal() +
                " Gold : " + city.getCityGold()/*+  " p" + CityView*/);
    }

    public void militaryOverview(City city){
        for (Unit unit : city.getUnits()){
            System.out.println(unit.getName());
        }
    }
    public void demographicPanel(City city){
        System.out.println(city.getCityPopulation());
        System.out.println(city.getCityGold());
    }
    public void citiesPanel(){
        System.out.println(City.allCitis);
    }
    public void unitsPanel(BaseCivilization civilization){
        System.out.println(civilization.getUnits());
    }
    public void researchPanel(){
        //TODO complete after research completed
    }
    public void diplimacypanel(){
        System.out.println(controller.Score);
    }
    public void increaseTurn(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        controller.turn+=amount;
    }
    public void increaseGold(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setCityGold(View.getInCity().getCityGold() + amount);
    }
    public void increaseHappiness(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setHappiness(View.getInCity().getHappiness() +amount);
    }
    public void increaseCityHP(Matcher matcher  ){
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setCityHitPoint(View.getInCity().getCityHitPoint()+ amount);
    }

    public void increaseCityStrength(Matcher matcher  ){
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setcityStrength(View.getInCity().getCityStrength()+ amount);
    }
}
