package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WinPage extends Application {
    private static WinPage winPage;

    public static WinPage getInstance() {
        if (winPage == null) {
            winPage = new WinPage();
        }
        return winPage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/winPage.fxml"));
        Scene scene = new Scene(pane);
        if (View.getIsLoggedIn() != null)
            View.getIsLoggedIn().setScoresOnJson(View.getIsLoggedIn().getScore());
        stage.setScene(scene);
        stage.show();
    }
}
