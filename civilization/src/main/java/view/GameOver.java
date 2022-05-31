package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameOver extends Application {
    private static GameOver gameOver;

    public static GameOver getInstance() {
        if (gameOver == null)
            gameOver = new GameOver();
        return gameOver;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/gameOver.fxml"));
        Scene scene = new Scene(pane);
        if (View.getIsLoggedIn() != null)
            View.getIsLoggedIn().setScoresOnJson(View.getIsLoggedIn().getScore());
        stage.setScene(scene);
        stage.show();
    }
}
