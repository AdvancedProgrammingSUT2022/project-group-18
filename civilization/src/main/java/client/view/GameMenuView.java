package client.view;

import client.controller.BackController;
import client.controller.GameController;
import enums.Message;
import enums.Regexes;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import client.model.BaseCivilization;
import client.model.City;
import client.model.unit.Unit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;


public class GameMenuView extends View {

    GameController controller = new GameController();
    boolean flag = true;
    TextArea textArea = new TextArea("");

    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/game.fxml")));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void newGame() {
        ProfileMenuGraphics.getStage().close();
        try {
            new BackController().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Task<Void> printResults(Process process) {
        textArea.setEditable(false);
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        updateMessage(line);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
                }

                return null;
            }
        };

        return task;
    }

    public void run() {
        String input = getInput();
        Matcher matcher;
        if (Regexes.getCommand(input, Regexes.RESEARCH) != null) {
        } else if (Regexes.getCommand(input, Regexes.UNITS) != null) {
            System.out.println("created new unit");
        } else if (Regexes.getCommand(input, Regexes.CITIES) != null) {
            citiesPanel();
        } else if (Regexes.getCommand(input, Regexes.DIPLOMACY) != null) {
            diplomacyPanel();
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
            setInCity(city);
        } else if ((matcher = Regexes.getCommand(input, Regexes.CITY_POSITION)) != null) {
            City city = controller.getCityByGps(Integer.parseInt(matcher.group("X")), Integer.parseInt(matcher.group("Y")));
            economicOverview(city);
            setInCity(city);
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

    public void diplomacyPanel() {
        System.out.println(controller.Score);
    }


    public void backToMain(MouseEvent event) {
        try {
            new MainMenuController().start(ProfileMenuGraphics.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
