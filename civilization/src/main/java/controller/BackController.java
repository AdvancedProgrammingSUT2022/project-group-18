package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import model.Tile;

import java.util.Objects;

public class BackController extends Application {

    AnchorPane pane;

    @FXML

    @Override
    public void start(Stage stage) throws Exception {
        this.pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/GameBackground.fxml")));
        //makingPolygons();
        foor();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    public void makingPolygons() {

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

    }

    public void foor() {
        String[] name = {"dirt", "grass", "sand", "stone"};
        int rand =0;
        for (int i = -1; i < 12; i++) {
            for (int j = -2; j < 6; j++) {
                rand = (int) Math.floor(Math.random()*100);
                if (rand%6!=0){
                    String back = name[rand % 4 ] + (rand % 4 +1);
                    Tile tile = new Tile();
                    if (j % 2 == 0) {
                        tile.setCoordinates(100 + (i * 160), 100 + (j * 135));
                        tile.setImage(back);
                    } else {
                        tile.setCoordinates(180 + (i * 160), 100 + (j * 135));
                        tile.setImage(back);
                    }
                    pane.getChildren().add(tile);
                }

            }
        }
    }

    public int makingRandomNum() {
        int min = 50;
        int max = 100;

        //Generate random int value from 50 to 100
        System.out.println("Random value in int from " + min + " to " + max + ":");
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }
}
