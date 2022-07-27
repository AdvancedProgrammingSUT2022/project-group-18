package client;

import client.model.Request;
import client.model.Response;
import client.controller.NetworkController;
import client.controller.SceneController;
import client.view.Database;
import client.view.LoginDialog;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class ChatMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Database.getInstance().setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(ChatMain.class.getResource("/fxml/users-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        stage.setTitle("Client");
        SceneController.push(scene, null);
        stage.show();
        showLoginPopup();
    }

    private void showLoginPopup() throws IOException {
        // TODO: show on top
        Stage popup = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ChatMain.class.getResource("/fxml/login-dialog.fxml"));
        loader.setController(new LoginDialog(new Callback() {
            @Override
            public Object call(Object object) {
                try {
                    Request request = new Request();
                    request.setHeader("register");
                    request.addData("nickname", Database.getInstance().getNickname());
                    Response response = NetworkController.send(request);
                    int id = (int) Math.floor((Double) response.getData().get("id"));
                    Database.getInstance().setUserId(id);
                    popup.close();
                    NetworkController.listenForUpdates();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return object;
            }
        }));
        Scene scene = new Scene(loader.load(), 250, 150);
        popup.setTitle("Login");
        popup.setScene(scene);
        popup.show();
    }

    public static void main(String[] args) {
        if (!NetworkController.connect())
            return;
        launch();
    }
}
