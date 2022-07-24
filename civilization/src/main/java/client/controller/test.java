package client.controller;

import client.view.ProfileMenuGraphics;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Objects;

public class test extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        AnchorPane parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/test.fxml")));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(10 ,10);
        scroll.setContent(new Rectangle(100, 90));
        scroll.setContent(new Circle(50));
        parent.getChildren().add(scroll);

        stage.show();
    }
}
