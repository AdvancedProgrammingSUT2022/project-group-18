package client.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ProfileMenuGraphics extends Application {
    private static ProfileMenuGraphics graphics;
    private static Stage stage;

    public static void setStage(Stage stage) {
        ProfileMenuGraphics.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }

    public static ProfileMenuGraphics getInstance() {
        if(graphics == null)
            graphics = new ProfileMenuGraphics();
        return graphics;
    }
    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        BorderPane parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/profileMenuGraphics.fxml")));
        Scene scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }
    public void deleteAccount(MouseEvent keyEvent) throws IOException {
        View.getIsLoggedIn().removeAccount(View.getIsLoggedIn());
        try {
            LoginMenuController.getInstance().register(ProfileMenuGraphics.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeProfilePhoto(MouseEvent mouseEvent) throws Exception {
       ProfileController.getInstance().start(stage);
    }

    public void changePass(MouseEvent mouseEvent) throws Exception {
        ProfileController.getInstance().changePassword(stage);
    }

    public void changeNickname(MouseEvent mouseEvent) throws Exception {
        ProfileController.getInstance().changeNickname(stage);
    }

    public void backToMainMenu(MouseEvent event) throws Exception {
        MainMenuController.getInstance().start(stage);
    }
}
