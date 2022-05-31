package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Controller extends Application {

    public void goToLogin(MouseEvent event) throws Exception {
        LoginMenuController.getInstance().login(ProfileMenuGraphics.getStage());
        }

    public void goToMainMenu(MouseEvent event) throws Exception {
        MainMenuController.getInstance().start(ProfileMenuGraphics.getStage());
    }
    public void goToProfile() throws Exception {
        if (View.getIsLoggedIn() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Login First!");
            alert.show();
        } else
            ProfileMenuGraphics.getInstance().start(ProfileMenuGraphics.getStage());
    }
    public void exit(MouseEvent event) throws Exception {
        System.exit(0);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/ProfileMenuGraphics.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);

    }


}
