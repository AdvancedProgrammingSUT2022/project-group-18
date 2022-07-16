package view;

import controller.GameController;
import enums.Message;
import enums.Regexes;
import enums.UnitEnum;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.BaseCivilization;
import model.City;
import model.unit.Settler;
import model.unit.Unit;

import java.util.Objects;
import java.util.regex.Matcher;


public class GameMenuView extends View {
    GameController controller = new GameController();

    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/game.fxml")));

        Settler settler = (Settler) UnitEnum.getUnits(UnitEnum.SETTLER);
        settler.setX(200);
        settler.setY(400);
        Settler settler1 = (Settler) UnitEnum.getUnits(UnitEnum.SETTLER);
        settler1.setX(400);
        settler1.setY(700);
        settler.setOnMouseClicked(event -> {
            View.setSelectedUnit(settler);
            //View.getSelectedUnit().setEffect(new Shadow());
        });
        settler1.setOnMouseClicked(event -> {
            View.setSelectedUnit(settler1);

        });
        if(View.getSelectedUnit() != null)
            View.getSelectedUnit().setEffect(new Shadow());
        pane.getChildren().addAll(settler, settler1);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    public void initialize() {

    }

    public void run() {
        String input = getInput();
        Matcher matcher;
        if ((matcher = Regexes.getCommand(input, Regexes.INCREASE_TURN)) != null) {
            increaseTurn(matcher);
        } else if ((matcher = Regexes.getCommand(input, Regexes.INCREASE_GOLD)) != null) {
            increaseGold(matcher);
        } else if ((matcher = Regexes.getCommand(input, Regexes.INCREASE_HAPPINESS)) != null) {
            increaseHappiness(matcher);
        } else if (Regexes.getCommand(input, Regexes.INCREAS_CITY_HP) != null)
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
            controller.getUnMilitaryUnitByGPS(Integer.parseInt(matcher.group("X")), Integer.parseInt(matcher.group("Y")));
        } else if ((matcher = Regexes.getCommand(input, Regexes.UNIT_NONCOMBAT_POSITION)) != null) {
            controller.getMilitaryUnitByGPS(Integer.parseInt(matcher.group("X")), Integer.parseInt(matcher.group("Y")));
        } else if ((matcher = Regexes.getCommand(input, Regexes.CITY_NAME)) != null) {
            City city = controller.getCityByName(matcher.group("name"));
            economicOverview(city);
            View.setInCity(city);
        } else if ((matcher = Regexes.getCommand(input, Regexes.CITY_POSITION)) != null) {
            City city = controller.getCityByGps(Integer.parseInt(matcher.group("X")), Integer.parseInt(matcher.group("Y")));
            economicOverview(city);
            View.setInCity(city);
        } else if ((matcher = Regexes.getCommand(input, Regexes.MOVETO_POSITION)) != null) {
            if (1 == 1) {//Unit.canMove
                System.out.println("movement mission was successful");
            } else
                System.out.println("movement mission wasn't successful");
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


    public void economicOverview(City city) {
        System.out.println("Population : " + city.getCityPopulation() + " Strength : " + city.getCityStrength() +
                " Food : " + city.getCityFood() + " Science : " + city.getOwner().getScienceTotal() +
                " Gold : " + city.getCityGold()/*+  " p" + CityView*/);
    }

    public void militaryOverview(City city) {
        for (Unit unit : city.getUnits()) {
            System.out.println(unit.getName());
        }
    }

    public void demographicPanel(City city) {
        System.out.println(city.getCityPopulation());
        System.out.println(city.getCityGold());
    }

    public void citiesPanel() {
        System.out.println(City.allCities);
    }

    public void unitsPanel(BaseCivilization civilization) {
        System.out.println(civilization.getUnits());
    }

    public void researchPanel() {
        //TODO complete after research completed
    }

    public void diplimacypanel() {
        System.out.println(controller.Score);
    }

    public void increaseTurn(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        controller.turn += amount;
    }

    public void increaseGold(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setCityGold(View.getInCity().getCityGold() + amount);
    }

    public void increaseHappiness(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setHappiness(View.getInCity().getHappiness() + amount);
    }

    public void increaseCityHP(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setCityHitPoint(View.getInCity().getCityHitPoint() + amount);
    }

    public void increaseCityStrength(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setcityStrength(View.getInCity().getCityStrength() + amount);
    }
}
