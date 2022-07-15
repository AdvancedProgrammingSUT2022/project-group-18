package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import model.Tile;

import java.awt.*;
import java.beans.EventHandler;
import java.util.Objects;

public class BackController extends Application {

    AnchorPane pane ;

    @FXML
    public Polygon polygon;
    public Circle circle = new Circle();
    public double x = circle.getCenterX();

    @Override
    public void start(Stage stage) throws Exception {
        this.pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/GameBackground.fxml")));
        makingPolygons();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    public void makingPolygons(){

        Tile tile1 = new Tile();
        Tile tile2 = new Tile();
        Tile tile3 = new Tile();
        Tile tile4 = new Tile();
        Tile tile5 = new Tile();

        pane.getChildren().add(tile1);
        pane.getChildren().add(tile2);
        pane.getChildren().add(tile3);
        pane.getChildren().add(tile4);
        pane.getChildren().add(tile5);


    }
}
