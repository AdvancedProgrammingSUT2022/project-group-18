package view;

import enums.Message;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.graphicModel.User;

import java.util.Objects;
import java.util.Random;

public class LoginMenuController extends Controller {
    private static LoginMenuController controller;
    @FXML
    private TextField nickname1;
    @FXML
    private TextField password1;
    @FXML
    private TextField username1;

    public static LoginMenuController getInstance() {
        if (controller == null)
            controller = new LoginMenuController();
        return controller;
    }

    public void register(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        BorderPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/registerMenuController.fxml")));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void register(MouseEvent event) throws Exception {
        String username = username1.getText();
        String password = password1.getText();
        String nickname = nickname1.getText();
        int size1 = username1.getLength();
        int size2 = password1.getLength();
        int size3 = nickname1.getLength();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        if(size1 == 0 || size2 == 0 || size3 == 0) {
            alert.setContentText("please fill all the blanks");
            alert.show();
        }
        else if (User.getUserByUsernameOrNickname(username, "username") != null) {
            alert.setContentText(Message.USER_EXIST_USERNAME_ONE + username + Message.USER_EXIST_USERNAME_TWO);
            alert.show();
        } else if (User.getUserByUsernameOrNickname(nickname, "nickname") != null) {
            alert.setContentText(Message.USER_EXIST_NICKNAME_ONE + nickname + Message.USER_EXIST_USERNAME_TWO);
            alert.show();
        }
        else
        {
            Alert ok = new Alert(Alert.AlertType.INFORMATION);
            ok.setHeaderText(null);
            ok.setContentText(Message.USER_CREAT.toString());
            ok.show();
            String[] urls = {"blue", "green", "orange", "purple", "red", "shelakhte", "yellow", "lightBlue"};
            Random random = new Random();
            int rand = random.nextInt(urls.length);
            System.out.println(urls[rand]);
            new User(username, password, nickname,urls[rand], 0);
            LoginMenuController.getInstance().register(ProfileMenuGraphics.getStage());

        }
    }

    public void login(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        BorderPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/loginMenuController.fxml")));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    public void login(MouseEvent event) throws Exception {
        String username = username1.getText();
        String password = password1.getText();
        int size1 = username1.getLength();
        int size2 = password1.getLength();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        if(size1 == 0 || size2 == 0) {
            alert.setContentText("please fill all the blanks");
            alert.show();
        }
        else if (User.getUserByUsernameOrNickname(username, "username") == null) {
            alert.setContentText(Message.NOT_MATCH.toString());
            alert.show();
        }
        else if (!User.getUserByUsernameOrNickname(username, "username").getPassword().equals(password)) {
            alert.setContentText(Message.NOT_MATCH.toString());
            alert.show();
        }
        else {
            View.setIsLoggedIn(User.getUserByUsernameOrNickname(username, "username"));
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setHeaderText(null);
            info.setContentText("Welcome!");
            info.show();
            MainMenuController.getInstance().start(ProfileMenuGraphics.getStage());
        }

    }


}