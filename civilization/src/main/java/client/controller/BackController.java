package client.controller;

<<<<<<< HEAD
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
=======
import enums.TechsEnum;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
>>>>>>> origin
import model.Building;
import model.City;
import model.Tile;
import model.techs.Technology;
import model.unit.Melee;
import model.unit.Settler;
import model.unit.Unit;
import client.view.View;
import enums.BuildingEnum;
import enums.Regexes;
import enums.UnitEnum;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.unit.Worker;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;

import static client.view.View.getInCity;
import static enums.TechsEnum.AGRI_CULTURE;

public class BackController extends Application {
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

<<<<<<< HEAD

        foundCity(pane, scene, pane1);
        moving(scene, pane);
        infoPanel(pane);
=======
        Button button = new Button("Research Panel");
        button.setLayoutX(1);
        button.setLayoutY(1);
        pane.getChildren().add(button);
        foundCity(pane, scene, pane1);
        moving(scene, pane1);
>>>>>>> origin
        handleAudio();
        cheatCode(scene);
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

    public void moving(Scene scene, AnchorPane pane) {
<<<<<<< HEAD
=======

>>>>>>> origin
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
        pane.getChildren().add(move);

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

<<<<<<< HEAD
    public void foundCity(AnchorPane pane, Scene scene, AnchorPane pane1) {
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
            warrior.setX(capital.getX() - 50);
            warrior.setY(capital.getY() - 50);

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
            moving(scene, pane);

        });
        pane.getChildren().add(button);
    }

    public void map(AnchorPane pane) {

        String[] name = {"dasht", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "kavir", "kooh", "ocean", "sand", "sand"
                , "sand", "grass", "snow", "tappe", "tappe", "tondra"};
=======
        switch (rand) {
            case 0:
                new Technology(AGRI_CULTURE.toString(), 20, "None", "Pottery, Animal Husbandry, Archery, Mining", "farm");
            case 1:
                Tile capital;
                capital = Tile.getTileFromCoordinate(x - 80, y - 135);
                assert capital != null;
                if(capital.getEffect() != null) capital.setEffect(null);
                capital = Tile.getTileFromCoordinate(x + 80, y - 135);
                assert capital != null;
                if(capital.getEffect() != null) capital.setEffect(null);
                capital = Tile.getTileFromCoordinate(x - 160, y);
                assert capital != null;
                if(capital.getEffect() != null) capital.setEffect(null);
                capital = Tile.getTileFromCoordinate(x + 160, y);
                assert capital != null;
                if(capital.getEffect() != null) capital.setEffect(null);
                break;
            case 2:
                getInCity().setCityPopulation(getInCity().getCityPopulation() + 1);
                break;
            case 3:
                getInCity().setCityGold(getInCity().getCityGold() + 10);
                break;
            case 4:
                if(two == 1) {
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

    public void foundCity(AnchorPane pane, Scene scene, AnchorPane pane1) {
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
            moving(scene, pane1);

        });
        pane.getChildren().add(button);
    }

    public void map(AnchorPane pane) {

        String[] name = {"dasht", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "kavir", "kooh", "ocean", "sand", "sand"
                , "sand", "grass", "snow", "tappe", "tappe", "tondra", "grassRuin"};
>>>>>>> origin
        int rand = 0;
        for (int i = -10; i < 15; i++) {
            for (int j = -10; j < 9; j++) {
                rand = (int) Math.floor(Math.random() * 100);
<<<<<<< HEAD
                String back = name[rand % 19];
=======
                String back = name[rand % 20];
>>>>>>> origin
                if (j % 2 == 0) {
                    int x = 100 + (i * 160);
                    int y = 100 + (j * 135);
                    Tile tile = new Tile(x, y, back);
                    tile.setCoordinates(x, y);
                    tile.setImage(back);
<<<<<<< HEAD
                    if (y > 600 || x > 1200 || y < 100 || x < 200) {
                        settingEffect(tile);
                    }
=======
                    if (tile.getTileType().equals("grassRuin")) {
                        settingEffect(tile);
                    }
                    if (y > 600 || x > 1200 || y < 100 || x < 200) {
                        settingEffect(tile);
                    }
>>>>>>> origin

                    pane.getChildren().add(tile);
                } else {
                    int x = 180 + (i * 160);
                    int y = 100 + (j * 135);
                    Tile tile = new Tile(x, y, back);
                    tile.setCoordinates(x, y);
                    tile.setImage(back);
<<<<<<< HEAD
=======
                    if (tile.getTileType().equals("grassRuin")) {
                        settingEffect(tile);
                    }
>>>>>>> origin
                    if (y > 600 || x > 1200 || y < 200 || x < 200) {
                        settingEffect(tile);
                    }
                    pane.getChildren().add(tile);
<<<<<<< HEAD
=======

>>>>>>> origin
                }
            }
        }
    }

    public void settingEffect(Tile tile) {
        GaussianBlur gaussianBlur = new GaussianBlur();
        gaussianBlur.setRadius(20);
        tile.setEffect(gaussianBlur);
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
<<<<<<< HEAD

    public void infoPanel(Pane pane) {
        Rectangle rectangle = new Rectangle(10 , 40 , 500 , 30);
        rectangle.setFill(Color.WHITE);
        rectangle.setOpacity(0.7);
        pane.getChildren().add(rectangle);
        Circle gold = new Circle(50, 50, 40);
        Image image = new Image(Objects.requireNonNull(getClass().getResource("/images/gold.png")).toExternalForm());
        gold.setFill(new ImagePattern(image));
        pane.getChildren().add(gold);
        Circle Science = new Circle(180, 50, 40);
        Image Scienceimage = new Image(Objects.requireNonNull(getClass().getResource("/images/Science.png")).toExternalForm());
        Science.setFill(new ImagePattern(Scienceimage));
        pane.getChildren().add(Science);
        Circle crowd = new Circle(310, 50, 40);
        Image crowdimage = new Image(Objects.requireNonNull(getClass().getResource("/images/crowd.png")).toExternalForm());
        crowd.setFill(new ImagePattern(crowdimage));
        pane.getChildren().add(crowd);
        Circle food = new Circle(440, 50, 40);
        Image foodimage = new Image(Objects.requireNonNull(getClass().getResource("/images/Food.png")).toExternalForm());
        food.setFill(new ImagePattern(foodimage));
        pane.getChildren().add(food);
    }
=======
>>>>>>> origin

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
