package client.view;

import client.Model.Chat;
import client.Model.Request;
import client.Model.Response;
import client.controller.NetworkController;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class UsersPage {
    public VBox usersList;

    public void initialize() {
        showUsers();
    }

    public void refreshUsers(ActionEvent actionEvent) {
        Request request = new Request();
        request.setHeader("get_chats");
        Response response = NetworkController.send(request);
        String chatsJson = new Gson().toJson(response.getData().get("chats"));
        ArrayList<Chat> chats = new Gson().fromJson(chatsJson, new TypeToken<ArrayList<Chat>>(){}.getType());
        Database.getInstance().setChats(chats);
        showUsers();
    }

    private void showUsers() {
        usersList.getChildren().clear();
        ArrayList<Chat> chats = Database.getInstance().getChats();
        for (Chat chat : chats) {
            HBox holder = new HBox();
            Label text = new Label();
            text.setText(chat.getName());
            text.setStyle("-fx-start-margin: 8;");
            holder.setAlignment(Pos.CENTER_LEFT);
            holder.setStyle("-fx-padding: 16; -fx-border-color: #011f4b; -fx-border-width: 0 1 1 1; " +
                    "-fx-color-label-visible: #4480d7");
            holder.setMinHeight(24);
            holder.getChildren().add(text);
            usersList.getChildren().add(holder);
            holder.setOnMouseClicked(mouseEvent -> {
                try {
                    ChatPage.run(chat.getId());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

