package controller;

import enums.BuildingEnum;
import enums.UnitEnum;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Building;
import model.City;
import model.Tile;
import model.unit.Settler;
import model.unit.Unit;
import view.View;

import java.util.Objects;

public class BackController extends Application {

    @FXML
    private Button found;
    private AnchorPane pane;
    int size = 0;
    int counter = 0;
    boolean flag = false;
    boolean moveFlag = false;


    @Override
    public void start(Stage stage) throws Exception {
        this.pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/GameBackground.fxml")));
        Scene scene = new Scene(pane);


        foor();

        foundCity(pane);
        moving(scene, pane, stage);

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


        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void moving(Scene scene, AnchorPane pane, Stage stage) {

        Button move = new Button("move");
        move.setLayoutX(1);
        move.setLayoutY(469);
        move.setPrefHeight(63);
        move.setPrefWidth(77);
        for (Unit unit : View.getInCity().getUnits()) {
            unit.setOnMouseClicked(event -> {
                if (!flag) {
                    move.setOnMouseClicked(event1 -> {
                        if (!moveFlag) {
                            scene.setOnMouseClicked(event2 -> {
                                Tile tile = Tile.getTileFromCoordinate(event2.getX(), event2.getY());
                                int distance = unit.distance(tile.getX(), tile.getY());
                                if (distance <= unit.getMovement()) {
                                    unit.move(tile.getX() - 25, tile.getY() - 50);
                                    unit.setUnitTile(tile);
                                    unit.minesMovement(distance);
                                } else {
                                    System.out.println("you can't go there!");
                                }


                                moveFlag = true;
                            });
                        } else {
                            moveFlag = false;
                        }
                    });
                    unit.setEffect(new Glow());
                    flag = true;
                } else {
                    unit.setEffect(null);
                    flag = false;
                }
            });
        }
        pane.getChildren().add(move);


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
            City city = new City(x, y);
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
        String[] name = {"dirt", "grass", "sand", "stone"};
        int rand = 0;
        for (int i = -1; i < 12; i++) {
            for (int j = -2; j < 6; j++) {
                rand = (int) Math.floor(Math.random() * 100);
                String back = name[rand % 4] + 1;

                if (j % 2 == 0) {
                    int x = 100 + (i * 160);
                    int y = 100 + (j * 135);
                    Tile tile = new Tile(x, y, back);
                    if (x + 80 < 1500 && x - 80 > 0 && y - 45 > 0)
                        tile.setCoordinates(x, y);
                    tile.setImage(back);
                    pane.getChildren().add(tile);
                } else {
                    int x = 180 + (i * 160);
                    int y = 100 + (j * 135);
                    Tile tile = new Tile(x, y, back);
                    if (x + 80 < 1500 && x - 80 > 0 && y + 45 < 780 && y - 45 > 0)
                        tile.setCoordinates(x, y);
                    tile.setImage(back);
                    pane.getChildren().add(tile);
                }


            }
        }
    }
}
