package client.controller;

import client.model.Building;
import client.model.City;
import client.model.Tile;
import client.model.techs.Technology;
import client.model.unit.Melee;
import client.model.unit.Settler;
import client.model.unit.Unit;
import client.model.unit.Worker;
import client.view.GameMenuView;
import client.view.View;
import enums.BuildingEnum;
import enums.Regexes;
import enums.UnitEnum;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;

import static client.view.View.getInCity;
import static enums.TechsEnum.AGRI_CULTURE;

public class BackController extends Application {
    client.model.BaseCivilization baseCivilization = View.getCivilization();
    ArrayList<Node> infopanelNodes = new ArrayList<Node>();
    ArrayList<Node> panels = new ArrayList<>();
    boolean firstInfoPanel = true;
    @FXML
    private ScrollPane scrollPane;
    private static MediaPlayer mediaPlayer;
    int endOfX = 1540;
    int endOfY = 730;
    int firstOfX = 180;
    int firstOfY = 10;
    int oUp = 1;
    int oDown = 1;
    int oRight = 1;
    int oLeft = 1;
    int numOfUp = 0;
    int numOfDown = 0;
    @FXML
    private Button found;
    int size = 0;
    int numOfRight = 0;
    int counter = 0;
    boolean flag = false;
    boolean moveFlag = false;
    public static final int SERVER_PORT = 9423;


    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/GameBackground.fxml")));
        AnchorPane pane1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/test.fxml")));

        map(pane1);
        Scene scene = new Scene(pane);

        this.scrollPane = createScrollPane(pane1);
        pane.getChildren().add(scrollPane);
        Button button = new Button("Research Panel");
        button.setLayoutX(1);
        button.setLayoutY(1);
        pane.getChildren().add(button);
        foundCity(pane, scene, pane1 , stage);
        moving(pane,scene, pane1);
        infoPanel(pane , stage);
        handleAudio();
        cheatCode(scene);
        setting(pane, stage);
        scrollPane.requestFocus();

/*        scene.setOnMouseClicked(event -> {
            System.out.println("--------");
            Tile ti;
            if ((ti = Tile.getTileFromCoordinate(event.getX(), event.getY())) != null) {
                System.out.println(ti.getX() + " " + ti.getY());
            }
        });*/

        showPopup(stage);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private void showPopup(Stage stage) {
        for (Tile tile : Tile.getTiles()) {
            Popup popup = popup(tile.getX(), tile.getY());
            tile.setOnMouseEntered(event -> {
                popup.show(stage);
            });
            tile.setOnMouseExited(event -> {
                popup.hide();
            });
        }
    }


    private ScrollPane createScrollPane(Pane layout) {
        ScrollPane scroll = new ScrollPane();
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setPannable(true);
        scroll.setPrefSize(1500, 780);
        scroll.setContent(layout);
        return scroll;
    }

    public void moving(AnchorPane pane1, Scene scene, AnchorPane pane) {
        Button move = new Button("move");
        move.setLayoutX(1);
        move.setLayoutY(469);
        move.setPrefHeight(63);
        move.setPrefWidth(77);
        new Thread(() -> {
            for (Unit unit : getInCity().getUnits()) {
                unit.setOnMouseClicked(event -> {
                    if (!flag) {
                        move.setOnMouseClicked(event1 -> {
                            if (!moveFlag) {
                                scene.setOnMouseClicked(event2 -> {
                                    Tile tile = Tile.getTileFromCoordinate(event2.getX(), event2.getY());
                                    int distance = unit.distance(tile.getX(), tile.getY());
                                    System.out.println(distance);
                                    if (distance <= unit.getMovement()) {
                                        unit.move(tile.getX() - 25, tile.getY() - 50);
                                        unit.setUnitTile(tile);
                                        unit.minesMovement(distance);
                                        if (tile.getEffect() != null) {
                                            tile.setEffect(null);
                                        }
                                        if (tile.getTileType().equals("grassRuin")) {
                                            tile.setImage("grass");
                                            inRuin(tile);
                                        }

                                    } else {
                                        System.out.println("you can't go there!");
                                    }

                                    moveFlag = true;
                                });
                            } else {
                                moveFlag = false;
                            }
                        });
                        unit.setEffect(new Bloom());
                        flag = true;
                    } else {
                        unit.setEffect(null);
                        flag = false;
                    }
                });
            }
        }).start();
        pane1.getChildren().add(move);

    }

    private void handleAudio() {
        Media media = new Media(BackController.class.getResource("/music/BackgroundMusic.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(-1);
        mediaPlayer.play();
    }

    protected void inRuin(Tile tile) {
        double x = tile.getX();
        double y = tile.getY();
        Random random = new Random();
        int rand = random.nextInt(5);
        int two = random.nextInt(2);
        switch (rand) {
            case 0:
                new Technology(AGRI_CULTURE.toString(), 20, "None", "Pottery, Animal Husbandry, Archery, Mining", "farm");
            case 1:
                Tile capital;
                capital = Tile.getTileFromCoordinate(x - 80, y - 135);
                assert capital != null;
                if (capital.getEffect() != null) capital.setEffect(null);
                capital = Tile.getTileFromCoordinate(x + 80, y - 135);
                assert capital != null;
                if (capital.getEffect() != null) capital.setEffect(null);
                capital = Tile.getTileFromCoordinate(x - 160, y);
                assert capital != null;
                if (capital.getEffect() != null) capital.setEffect(null);
                capital = Tile.getTileFromCoordinate(x + 160, y);
                assert capital != null;
                if (capital.getEffect() != null) capital.setEffect(null);
                break;
            case 2:
                getInCity().setCityPopulation(getInCity().getCityPopulation() + 1);
                break;
            case 3:
                getInCity().setCityGold(getInCity().getCityGold() + 10);
                break;
            case 4:
                if (two == 1) {
                    Worker worker = (Worker) UnitEnum.getUnits(UnitEnum.WORKER);
                    worker.setX(getInCity().getX());
                    worker.setY(getInCity().getY());
                } else {
                    Settler worker = (Settler) UnitEnum.getUnits(UnitEnum.WORKER);
                    worker.setX(getInCity().getX());
                    worker.setY(getInCity().getY());
                }
                break;
        }

    }

    public void foundCity(AnchorPane pane, Scene scene, AnchorPane pane1 , Stage stage) {
        Settler settler = (Settler) UnitEnum.getUnits(UnitEnum.SETTLER);
        Tile tile = Tile.getTileFromCoordinate(500, 500);
        settler.setX(tile.getX() - 40);
        settler.setY(tile.getY() - 40);
        pane1.getChildren().add(settler);

        Button button = new Button("found  city");
        button.setLayoutX(1);
        button.setLayoutY(406);
        button.setPrefHeight(63);
        button.setPrefWidth(77);
        size = pane.getChildren().size() - 1;


        button.setOnMouseClicked(event -> {
            double x = settler.getX();
            double y = settler.getY();
            Tile capital = Tile.getTileFromCoordinate(x, y);
            x = capital.getX();
            y = capital.getY();
            City city = new City(x, y);
            View.setInCity(city);
            city.setX(x);
            city.setY(y);


            city.addTileToCity(capital);
            capital = Tile.getTileFromCoordinate(x - 80, y - 135);
            System.out.println(capital.getX() + " " + capital.getY());
            city.addTileToCity(capital);
            capital = Tile.getTileFromCoordinate(x + 80, y - 135);
            System.out.println(capital.getX() + " " + capital.getY());
            city.addTileToCity(capital);
            capital = Tile.getTileFromCoordinate(x - 160, y);
            System.out.println(capital.getX() + " " + capital.getY());
            city.addTileToCity(capital);
            capital = Tile.getTileFromCoordinate(x + 160, y);
            System.out.println(capital.getX() + " " + capital.getY());
            city.addTileToCity(capital);
            Melee warrior = (Melee) UnitEnum.getUnits(UnitEnum.WARRIOR);
            warrior.setX(capital.getX() - 40);
            warrior.setY(capital.getY() - 40);

            pane1.getChildren().add(warrior);

            capital = Tile.getTileFromCoordinate(x - 80, y + 135);
            System.out.println(capital.getX() + " " + capital.getY());
            city.addTileToCity(capital);
            capital = Tile.getTileFromCoordinate(x + 80, y + 135);
            System.out.println(capital.getX() + " " + capital.getY());
            city.addTileToCity(capital);
            pane1.getChildren().remove(settler);
            size = pane1.getChildren().size() - 1;
            Building building = BuildingEnum.makeBuilding(BuildingEnum.PALACE);
            building.getIcon().setFitHeight(120);
            building.getIcon().setFitWidth(120);
            building.getIcon().setX(x - 55);
            building.getIcon().setY(y - 60);
            pane1.getChildren().add(size, building.getIcon());
            pane.getChildren().remove(button);
            moving(pane, scene, pane1);
            firstInfoPanel = false;
            infoPanel(pane , stage);
        });
        pane.getChildren().add(button);
    }

    public void map(AnchorPane pane) {

        String[] name = {"dasht", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "kavir", "kooh", "ocean", "sand", "sand"
                , "sand", "grass", "snow", "tappe", "tappe", "tondra", "grassRuin"};
        int rand = 0;
        for (int i = -10; i < 15; i++) {
            for (int j = -10; j < 9; j++) {
                rand = (int) Math.floor(Math.random() * 100);
                String back = name[rand % 20];
                if (j % 2 == 0) {
                    int x = 100 + (i * 160);
                    int y = 100 + (j * 135);
                    Tile tile = new Tile(x, y, back);
                    tile.setCoordinates(x, y);
                    tile.setImage(back);
                    if (tile.getTileType().equals("grassRuin")) {
                        settingEffect(tile);
                    }
                    if (y > 600 || x > 1200 || y < 100 || x < 200) {
                        settingEffect(tile);
                    }
                    pane.getChildren().add(tile);
                } else {
                    int x = 180 + (i * 160);
                    int y = 100 + (j * 135);
                    Tile tile = new Tile(x, y, back);
                    tile.setCoordinates(x, y);
                    tile.setImage(back);
           if (tile.getTileType().equals("grassRuin")) {
                        settingEffect(tile);
                    }
                    if (y > 600 || x > 1200 || y < 200 || x < 200) {
                        settingEffect(tile);
                    }
                    pane.getChildren().add(tile);
                }
            }
        }
    }

    public void settingEffect(Tile tile) {
        GaussianBlur gaussianBlur = new GaussianBlur();
        gaussianBlur.setRadius(20);
        tile.setEffect(gaussianBlur);
    }

    public void setting(AnchorPane pane, Stage stage) {
        ImageView setting = new ImageView();
        setting.setImage(new Image(BackController.class.getResource("/icon/setting.png").toExternalForm()));
        setting.setFitWidth(35);
        setting.setFitHeight(35);
        setting.setX(1465);
        setting.setY(1);
        setting.setOnMouseClicked(event -> {

            Button button1 = new Button("mute audio");
            button1.setOnMouseClicked(event1 -> {
                mediaPlayer.stop();
            });
            Button play = new Button(" play audio ");
            play.setOnMouseClicked(event1 -> {
                mediaPlayer.play();
            });
            Button exit = new Button("      Exit      ");

            Popup popup0 = new Popup();
            Popup popup = new Popup();
            Popup popup1 = new Popup();
            Popup popup2 = new Popup();
            popup0.setX(700);
            popup0.setY(300);
            popup.setX(737);
            popup.setY(350);
            popup1.setX(737);
            popup1.setY(400);
            popup2.setX(737);
            popup2.setY(450);
            Label label0 = new Label("              " );
            label0.setPrefWidth(150);
            label0.setPrefHeight(300);
            Label label = new Label("", button1);
            Label label1 = new Label("", play);
            Label label2 = new Label("", exit);

            popup0.getContent().add(label0);
            popup1.getContent().add(label);
            popup.getContent().add(label1);
            popup2.getContent().add(label2);

            label0.setStyle(" -fx-background-color: rgba(235,255,200,0.6);");
            label.setFont(Font.font(""));
            popup.setOpacity(1);

            popup.setAutoHide(true);
            popup0.show(stage);
            popup.show(stage);
            popup1.show(stage);
            popup2.show(stage);

            exit.setOnMouseClicked(event1 -> {
                popup0.hide();
                popup.hide();
                popup1.hide();
                popup2.hide();
            });
        });
        pane.getChildren().add(setting);
    }

    public Popup popup(double x, double y) {
        Tile tile = Tile.getTileFromCoordinate(x, y);
        Popup popup = new Popup();
        String gold = String.valueOf(tile.goldOutput);
        javafx.scene.image.Image image = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("/images/icon.png").toExternalForm()));
        ImageView imageView = new ImageView(image);
        Label label = new Label("gold: " + gold +
                "\nproduction: " + tile.prodution +
                "\nfood: " + tile.foodOutput +
                "\ncombat modifiers: " + tile.cm +
                "\nmovement cost: " + tile.cost, imageView);
        popup.getContent().add(label);
        label.setMinWidth(150);
        label.setMinHeight(100);
        label.setStyle(" -fx-text-fill: #851111;");
        label.setStyle(" -fx-background-color: rgba(255,255,255,0.6);");
        label.setFont(Font.font(""));
        popup.setOpacity(1);
        popup.setX(1200);
        popup.setY(400);
        popup.setAutoHide(true);
        return popup;
    }
    public void infoPanel(Pane pane , Stage stage) {
        if (firstInfoPanel==false){
            for (Node node : infopanelNodes){
                pane.getChildren().remove(node);
            }
        }
        Rectangle rectangle = new Rectangle(20 , 60 , 500 , 30);
        rectangle.setFill(Color.WHITE);
        rectangle.setOpacity(0.7);
        pane.getChildren().add(rectangle);
        infopanelNodes.add(rectangle);
        String data = baseCivilization.getGoldTotal() + "               " +
                baseCivilization.getScienceTotal() + "               " +
                baseCivilization.getPopulation() + "               " +
                View.getInCity().getCityFood();
        Text text = new Text(90 , 80 ,  data);
        text.setFont(Font.font("verdana", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        Circle gold = new Circle(50, 70, 35);
        Image image = new Image(Objects.requireNonNull(getClass().getResource("/images/goldAsset 2.png")).toExternalForm());
        gold.setFill(new ImagePattern(image));
        pane.getChildren().add(gold);
        infopanelNodes.add(gold);
        Circle Science = new Circle(180, 70, 35);
        Image Scienceimage = new Image(Objects.requireNonNull(getClass().getResource("/images/ScienceAsset 1.png")).toExternalForm());
        Science.setFill(new ImagePattern(Scienceimage));
        pane.getChildren().add(Science);
        infopanelNodes.add(Science);
        Circle crowd = new Circle(310, 70, 35);
        Image crowdimage = new Image(Objects.requireNonNull(getClass().getResource("/images/crowdAsset 4.png")).toExternalForm());
        crowd.setFill(new ImagePattern(crowdimage));
        pane.getChildren().add(crowd);
        infopanelNodes.add(crowd);
        Circle food = new Circle(440, 70, 35);
        Image foodimage = new Image(Objects.requireNonNull(getClass().getResource("/images/foodAsset 3.png")).toExternalForm());
        food.setFill(new ImagePattern(foodimage));
        pane.getChildren().add(food);
        infopanelNodes.add(food);
        pane.getChildren().add(text);
        infopanelNodes.add(text);

        Circle happiness = new Circle(1410, 70, 35);
        Image hapimage = new Image(Objects.requireNonNull(getClass().getResource("/images/Happiness.png")).toExternalForm());
        happiness.setFill(new ImagePattern(hapimage));
        Rectangle hadata = new Rectangle(1330 , 60 , 70 , 30);
        hadata.setFill(Color.WHITE);
        hadata.setOpacity(0.7);
        pane.getChildren().add(hadata);
        infopanelNodes.add(hadata);
        String happ = String.valueOf(baseCivilization.getHappiness()) ;
        Text hatext = new Text(1335 , 80 ,  happ);
        hatext.setFont(Font.font("verdana", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        pane.getChildren().add(hatext);
        pane.getChildren().add(happiness);
        infopanelNodes.add(hatext);
        infopanelNodes.add(happiness);
        Rectangle back = new Rectangle(50 , 720 , 1400 , 30);
        back.setFill(Color.WHITE);
        back.setOpacity(0.7);
        pane.getChildren().add(back);
        makePanel(30 , 700 , "search" , pane , stage);
        makePanel(180 , 700 , "unit" , pane , stage);
        makePanel(330 , 700 , "city" , pane , stage);
        makePanel(480 , 700 , "diplomacy" , pane ,stage);
        makePanel(630 , 700 , "win" , pane , stage);
        makePanel(780 , 700 , "crowda" , pane , stage);
        makePanel(930 , 700 , "notif" , pane , stage);
        makePanel(1080 , 700 , "military" , pane , stage);
        makePanel(1230 , 700 , "economy" , pane , stage);
        makePanel(1380 , 700 , "exchange" , pane , stage);
    }

    public void makePanel(int x , int y , String name , Pane pane , Stage stage){
        Rectangle rectangle = new Rectangle(x, y , 90 , 70);
        Image image = new Image(Objects.requireNonNull(getClass().getResource("/images/"+ name + ".png")).toExternalForm());
        rectangle.setFill(new ImagePattern(image));
        Popup popup = new Popup();
        Image popimage = new Image(Objects.requireNonNull(getClass().getResource("/images/loc.png").toExternalForm()));
        ImageView imageView = new ImageView(popimage);
        String data = "";
        switch(name){
            case "search":
                data = "net yet set";
                break;
            case "unit":
                data = GameMenuView.unitsPanel(baseCivilization);
                break;
            case "city":
                for (City city : GameMenuView.citiesPanel())
                data += "\n" + city.getCityName();
                break;
            case "diplomacy":
                data = GameMenuView.demographicPanel(GameMenuView.getInCity());
                break;
            case "win":
                data = "it is the first of the trip\nwait & be patient!";
                break;
            case "crowda":
                data = String.valueOf(baseCivilization.getPopulation());
                break;
            case "notif":
                data = "empty";
                break;
            case "military":
                data = GameMenuView.militaryOverview(View.getInCity());
                break;
            case "economy":
                data = GameMenuView.economicOverview(View.getInCity());
                break;
            case "exchange":
                data = "not exchange yet";
                break;
            default: data = "empty";
        }
        Label label = new Label(data, imageView);
        popup.getContent().add(label);
        label.setMinWidth(150);
        label.setMinHeight(100);
        label.setStyle(" -fx-text-fill: #851111;");
        label.setStyle(" -fx-background-color: rgba(255,255,255,0.6);");
        label.setFont(Font.font(""));
        popup.setOpacity(1);
        popup.setX(x);
        popup.setY(y);
        popup.setAutoHide(true);
        rectangle.setOnMouseEntered(event -> {
            popup.show(stage);
        });
//        rectangle.setOnMouseExited(event -> {
//            popup.hide();
//        });
        pane.getChildren().add(rectangle);

    }
    public void cheatCode(Scene scene) {
        KeyCombination kc = new KeyCodeCombination(KeyCode.C, KeyCombination.SHIFT_DOWN, KeyCombination.CONTROL_DOWN);
        Runnable rn = () -> {
            AnchorPane parent = null;
            try {
                parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/codeTaghalob.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene1 = new Scene(parent);
            Stage stage1 = new Stage();
            stage1.setScene(scene1);
            stage1.show();
            TextArea textArea = new TextArea("");
            textArea.setLayoutX(70);
            textArea.setLayoutY(100);
            Button button = new Button("try code");
            button.setLayoutX(274);
            button.setLayoutY(308);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);

            button.setOnMouseClicked(event -> {
                String code = textArea.getText();
                Matcher matcher;
                if ((matcher = Regexes.getCommand(code, Regexes.INCREASE_TURN)) != null) {
                    getInCity().increaseTurn(matcher);
                    alert.setContentText("turn increased successfully!");
                    alert.show();
                } else if ((matcher = Regexes.getCommand(code, Regexes.INCREASE_GOLD)) != null) {
                    getInCity().increaseGold(matcher);
                    alert.setContentText("successful! your gold is: " + getInCity().getCityGold());
                    alert.show();
                } else if ((matcher = Regexes.getCommand(code, Regexes.INCREASE_BEAKERS)) != null) {
                    getInCity().increaseBeakers(matcher);
                    alert.setContentText("successful! your beakers are: " + getInCity().getCityBeakers());
                    alert.show();
                } else if ((matcher = Regexes.getCommand(code, Regexes.INCREASE_FOOD)) != null) {
                    getInCity().increaseFood(matcher);
                    alert.setContentText("successful! your food is: " + getInCity().getCityFood());
                    alert.show();
                } else if ((matcher = Regexes.getCommand(code, Regexes.INCREASE_HAPPINESS)) != null) {
                    getInCity().increaseHappiness(matcher);
                    alert.setContentText("successful! your happiness is: " + getInCity().getHappiness());
                    alert.show();
                } else if ((matcher = Regexes.getCommand(code, Regexes.INCREASE_CITY_STRENGTH)) != null) {
                    getInCity().increaseCityStrength(matcher);
                    alert.setContentText("successful! your city strength is: " + getInCity().getCityStrength());
                    alert.show();
                } else if ((matcher = Regexes.getCommand(code, Regexes.INCREASE_CITY_HP)) != null) {
                    getInCity().increaseCityHP(matcher);
                    alert.setContentText("successful! your city HP is: " + getInCity().getCityHitPoint());
                    alert.show();
                } else {
                    alert.setContentText("not a cheat code:)");
                    alert.show();
                }
            });

            parent.getChildren().addAll(textArea, button);
        };
        scene.getAccelerators().put(kc, rn);
    }
}
