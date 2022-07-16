package controller;

import enums.UnitEnum;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Tile;
import model.unit.Settler;
import view.View;

import java.util.Objects;

public class BackController extends Application {

    @FXML
    private Button found;
    private AnchorPane pane;


    @Override
    public void start(Stage stage) throws Exception {
        this.pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/GameBackground.fxml")));
        Scene scene = new Scene(pane);
        //makingPolygons();
        foor();
        Settler settler = (Settler) UnitEnum.getUnits(UnitEnum.SETTLER);
        settler.setX(400);
        settler.setY(500);
        scene.setOnMouseClicked(event -> {
            System.out.println("--------");
            System.out.println(event.getX());
            System.out.println(event.getY());
            System.out.println();
        });
        pane.getChildren().add(settler);
        Button button = new Button("found  city");
        button.setLayoutX(1);
        button.setLayoutY(406);

        pane.getChildren().add(button);
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }


/*    public void makingPolygons() {

        Tile tile1 = new Tile();
        Tile tile2 = new Tile();
        Tile tile3 = new Tile();
        Tile tile4 = new Tile();
        Tile tile5 = new Tile();
        Tile tile6 = new Tile();
        Tile tile7 = new Tile();
        Tile tile8 = new Tile();
        Tile tile9 = new Tile();

        tile1.setCoordinates(100, 100);
        tile1.setImage("dirt_12");
        pane.getChildren().add(tile1);

        tile2.setCoordinates(260, 100);
        tile2.setImage("grass_12");
        pane.getChildren().add(tile2);

        tile3.setCoordinates(420, 100);
        tile3.setImage("grass_11");
        pane.getChildren().add(tile3);

        tile4.setCoordinates(580, 100);
        tile4.setImage("grass_14");
        pane.getChildren().add(tile4);

        tile5.setCoordinates(500, 235);
        tile5.setImage("stone_13");
        pane.getChildren().add(tile5);

        tile6.setCoordinates(660, 235);
        tile6.setImage("stone_13");
        pane.getChildren().add(tile6);

        tile7.setCoordinates(980, 235);
        tile7.setImage("stone_14");
        pane.getChildren().add(tile7);

        tile8.setCoordinates(1140, 235);
        tile8.setImage("stone_02");
        pane.getChildren().add(tile8);

    }*/

    public void foor() {
        String[] name = {"dirt", "grass", "sand", "stone"};
        int rand = 0;
        for (int i = -1; i < 12; i++) {
            for (int j = -2; j < 6; j++) {
                rand = (int) Math.floor(Math.random() * 100);
                if (rand % 6 != 0) {
                    String back = name[rand % 4] + (rand % 4 + 1);

                    if (j % 2 == 0) {
                        int x = 100 + (i * 160);
                        int y = 100 + (j * 135);
                        Tile tile = new Tile(View.getInCity(), x, y);
                        //if (x + 80 < 1500 && x - 80 > 0 && y - 45 > 0)
                            tile.setCoordinates(x, y);
                        tile.setImage(back);
                        pane.getChildren().add(tile);
                    } else {
                        int x = 180 + (i * 160);
                        int y = 100 + (j * 135);
                        Tile tile = new Tile(View.getInCity(), x, y);
                        //if (x+80 < 1500 && x-80 > 0 && y+45 < 780 && y-45 > 0)
                        tile.setCoordinates(x, y);
                        tile.setImage(back);
                        pane.getChildren().add(tile);
                    }

                }

            }
        }
    }

    public int makingRandomNum() {
        int min = 50;
        int max = 100;

        //Generate random int value from 50 to 100
        System.out.println("Random value in int from " + min + " to " + max + ":");
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
