package controller;

import enums.BuildingEnum;
import enums.UnitEnum;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.Building;
import model.City;
import model.Tile;
import model.unit.Settler;

import java.awt.*;
import java.util.Objects;

public class BackController extends Application {
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
    private AnchorPane pane;
    int size = 0;
    int numOfRight =0;


    @Override
    public void start(Stage stage) throws Exception {
        this.pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/GameBackground.fxml")));
        Scene scene = new Scene(pane);
        foor();
        scene.setOnMouseClicked(event -> {
            System.out.println("--------");
            Tile ti;
            if ((ti = Tile.getTileFromCoordinate(event.getX(), event.getY())) != null) {
                System.out.println(ti.getX() + " " + ti.getY());
            }
            /*System.out.println(event.getX());
            System.out.println(event.getY());*/
            System.out.println();
        });
        foundCity(pane);
        pane.requestFocus();
        pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode().getName()) {
                    case "Left":
                        moveLeft();
                        break;
                    case "Right":
                        moveRight();
                        break;
                    case "Up":
                        moveUp();
                        break;
                    case "Down":
                        moveDown();
                        break;
                }
            }
        });
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                popup(mouseEvent.getX(),mouseEvent.getY(),stage);
            }
        });        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void moveDown() {
        numOfDown++;
        for (Tile tile : Tile.getTiles()) {
            tile.setLayoutY(tile.getLayoutY() - 10);
        }
        if (numOfDown % 5 == 0 && numOfDown < 20)
            newRowOfTiles(1);
    }

    private void moveUp() {
        numOfUp++;
        for (Tile tile : Tile.getTiles()) {
            tile.setLayoutY(tile.getLayoutY() + 10);

        }
        if (numOfUp % 5 == 0 && numOfUp < 20)
            newRowOfTiles(0);
    }

    private void moveRight() {
        numOfRight++;
        for (Tile tile : Tile.getTiles()) {
            tile.setLayoutX(tile.getLayoutX() - 10);
        }
        if (numOfRight % 5 == 0 && numOfRight < 20)
            newColumn(0);
    }

    private void moveLeft() {
        for (Tile tile : Tile.getTiles()) {
            tile.setLayoutX(tile.getLayoutX() + 10);
        }
    }

    public void foundCity(AnchorPane pane) {
        Settler settler = (Settler) UnitEnum.getUnits(UnitEnum.SETTLER);
        Tile tile = Tile.getTileFromCoordinate(500, 500);
        settler.setX(tile.getX() - 40);
        settler.setY(tile.getY() - 40);
        System.out.println(tile.getTileType());
        Button button = new Button("found  city");
        button.setLayoutX(1);
        button.setLayoutY(406);
        button.setPrefHeight(63);
        button.setPrefWidth(77);

        button.setOnMouseClicked(event -> {
            double x = settler.getX();
            double y = settler.getY();
            Tile capital = Tile.getTileFromCoordinate(x, y);
            x = capital.getX();
            y = capital.getY();
            City city = new City();
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
            capital = Tile.getTileFromCoordinate(x - 80, y + 135);
            System.out.println(capital.getX() + " " + capital.getY());
            city.addTileToCity(capital);
            capital = Tile.getTileFromCoordinate(x + 80, y + 135);
            System.out.println(capital.getX() + " " + capital.getY());
            city.addTileToCity(capital);
            pane.getChildren().remove(settler);
            size = pane.getChildren().size() - 1;
            Building building = BuildingEnum.makeBuilding(BuildingEnum.PALACE);
            building.getIcon().setFitHeight(120);
            building.getIcon().setFitWidth(120);
            building.getIcon().setX(x - 55);
            building.getIcon().setY(y - 60);
            pane.getChildren().add(size, building.getIcon());
            pane.getChildren().remove(button);

        });
        size = pane.getChildren().size() - 1;
        pane.getChildren().add(size, button);
        pane.getChildren().add(size + 1, settler);
    }

    public void foor() {

        String[] name = {"dasht", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "kavir", "kooh", "ocean", "sand", "sand"
                , "sand", "grass", "snow", "tappe", "tappe", "tondra"};
        int rand = 0;
        for (int i = -1; i < 12; i++) {
            for (int j = -2; j < 6; j++) {
                rand = (int) Math.floor(Math.random() * 100);
                String back = name[rand % 19];
                if (j % 2 == 0) {
                    int x = 100 + (i * 160);
                    int y = 100 + (j * 135);
                    Tile tile = new Tile(x, y, back);
                    if (x + 80 < 1500 && x - 80 > 0 && y - 45 > 0) {
                        tile.setCoordinates(x, y);
                        tile.setImage(back);
                        if (y > 600 || x > 1200 || y<100 || x<200) {
                            settingEffect(tile);
                        }
                        pane.getChildren().add(tile);
                    }
                } else {
                    int x = 180 + (i * 160);
                    int y = 100 + (j * 135);
                    Tile tile = new Tile(x, y, back);
                    if (x + 80 < 1500 && x - 80 > 0 && y + 45 < 780 && y - 45 > 0) {
                        tile.setCoordinates(x, y);
                        tile.setImage(back);
                        if (y > 600 || x > 1200 || y<200 || x<200) {
                            settingEffect(tile);
                        }
                        pane.getChildren().add(tile);
                    }

                }
            }
        }
    }

    public void settingEffect(Tile tile) {
        GaussianBlur gaussianBlur = new GaussianBlur();
        gaussianBlur.setRadius(20);
        tile.setEffect(gaussianBlur);
    }

    public void popUp() {

    }

    public void newRowOfTiles(int side) { // side =0 -> up     side =1 -> down
        String[] name = {"dasht", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "kavir", "kooh", "ocean", "sand", "sand"
                , "sand", "grass", "snow", "tappe", "tappe", "tondra"};
        if (side == 0) {
            if (oUp % 2 == 0) {
                for (int i = 0; i < 9; i++) {
                    int rand = (int) Math.floor(Math.random() * 100);
                    String back = name[rand % 19];
                    Tile tile = new Tile(100 + i * 160, firstOfY, back);
                    tile.setCoordinates(100 + i * 160, firstOfY);
                    tile.setImage(back);
                    pane.getChildren().add(tile);
                }
            }
            if (oUp % 2 != 0) {
                for (int i = 0; i < 8; i++) {
                    int rand = (int) Math.floor(Math.random() * 100);
                    String back = name[rand % 19];
                    Tile tile = new Tile(180 + i * 160, firstOfY, back);
                    tile.setCoordinates(180 + i * 160, firstOfY);
                    tile.setImage(back);
                    pane.getChildren().add(tile);
                }
            }
            oUp++;
        } else {
            if (oDown % 2 == 0) {
                for (int i = 0; i < 9; i++) {
                    int rand = (int) Math.floor(Math.random() * 100);
                    String back = name[rand % 19];
                    Tile tile = new Tile(100 + i * 160, endOfY, back);
                    tile.setCoordinates(100 + i * 160, endOfY);
                    tile.setImage(back);
                    settingEffect(tile);
                    pane.getChildren().add(tile);
                }
            }
            if (oDown % 2 != 0) {
                for (int i = 0; i < 8; i++) {
                    int rand = (int) Math.floor(Math.random() * 100);
                    String back = name[rand % 19];
                    Tile tile = new Tile(180 + i * 160, endOfY, back);
                    tile.setCoordinates(180 + i * 160, endOfY);
                    tile.setImage(back);
                    settingEffect(tile);
                    pane.getChildren().add(tile);
                }
            }
            oDown++;
        }
        firstOfY -= 90;
        endOfY += 90;
    }

    public void newColumn(int side) { //side=0 -> Right      side=0 -> Left
        String[] name = {"dasht", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "kavir", "kooh", "ocean", "sand", "sand"
                , "sand", "grass", "snow", "tappe", "tappe", "tondra"};
        if (side == 0) {
            for (int i = 0; i < 9; i++) {
                int rand = (int) Math.floor(Math.random() * 100);
                String back = name[rand % 19];
                Tile tile = new Tile(endOfX, firstOfY + 150*i, back);
                tile.setCoordinates(endOfX, firstOfY + 150*i);
                tile.setImage(back);
                pane.getChildren().add(tile);
            }
            oUp++;
        } else {
            if (oDown % 2 == 0) {
                for (int i = 0; i < 9; i++) {
                    int rand = (int) Math.floor(Math.random() * 100);
                    String back = name[rand % 19];
                    Tile tile = new Tile(100 + i * 160, endOfY, back);
                    tile.setCoordinates(100 + i * 160, endOfY);
                    tile.setImage(back);
                    pane.getChildren().add(tile);
                }
            }
            if (oDown % 2 != 0) {
                for (int i = 0; i < 8; i++) {
                    int rand = (int) Math.floor(Math.random() * 100);
                    String back = name[rand % 19];
                    Tile tile = new Tile(180 + i * 160, endOfY, back);
                    tile.setCoordinates(180 + i * 160, endOfY);
                    tile.setImage(back);
                    pane.getChildren().add(tile);
                }
            }
            oDown++;
        }
        firstOfX -= 160;
        endOfX += 160;
    }

    public void popup(double x , double y , Stage stage){
        Tile tile = Tile.getTileFromCoordinate(x , y);
        Popup popup = new Popup();
        String gold = String.valueOf(tile.goldOutput);
        javafx.scene.image.Image image = new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResource("/images/icon.png").toExternalForm()));
        ImageView imageView = new ImageView(image);
        Label label = new Label("gold: " + gold +
                "\nproduction: " + tile.prodution +
                "\nfood: " + tile.foodOutput +
                "\ncombat modifiers: " + tile.cm +
                "\nmovement cost: " + tile.cost , imageView);
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
        popup.show(stage);
    }
}
