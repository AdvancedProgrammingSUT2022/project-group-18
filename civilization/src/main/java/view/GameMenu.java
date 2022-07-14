package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class GameMenu extends Application {

    private static GameMenu controller;
    public static GameMenu getInstance() {
        if(controller == null)
            controller = new GameMenu();
        return controller;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        BorderPane parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/gameMenuController.fxml")));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
