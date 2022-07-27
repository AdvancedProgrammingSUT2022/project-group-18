package client.view;


import client.ChatMain;
import client.model.graphicModel.ProfilePhoto;
import client.model.graphicModel.UserProfile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;


public class MainMenuController extends Controller {
    private static MainMenuController controller;
    public static Socket socket;
    public static DataInputStream dataInputStream;
    public static DataOutputStream dataOutputStream;
    public static int SERVER_PORT = 7889;

    public static void initialize() {
        try {
            socket = new Socket("localhost", SERVER_PORT);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("wrong in initialize");
            e.printStackTrace();
        }
    }
    public static MainMenuController getInstance() {
        if (controller == null)
            controller = new MainMenuController();
        return controller;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        BorderPane parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/mainMenu.fxml")));
        registeredScoreBord(parent);
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public void scoreTable(Stage stage) throws Exception {
        stage = new Stage();
        TableView<UserProfile> table = new TableView<>();
        table.setStyle("-fx-background-color: transparent;" +
                "-fx-border-color: green;");


        TableColumn<UserProfile, ProfilePhoto> photo = new TableColumn<>("photo");
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));


        TableColumn<UserProfile, String> userNameCol = new TableColumn<>("username");
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<UserProfile, Integer> score = new TableColumn<>("score");
        score.setCellValueFactory(new PropertyValueFactory<>("score"));

        ObservableList<UserProfile> list = FXCollections.observableArrayList(UserProfile.allUserProfiles);
        table.setItems(list);



        table.getColumns().addAll(photo, userNameCol, score);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        userNameCol.setSortType(TableColumn.SortType.DESCENDING);

        loggedInUserBackground(userNameCol, score);

        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);

        stage.setTitle("TableView");

        Scene scene = new Scene(root, 660, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void loggedInUserBackground(TableColumn<UserProfile, String> userNameCol, TableColumn<UserProfile, Integer> score) {

        userNameCol.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty); //This is mandatory

                    if (item == null || empty) { //If the cell is empty
                        setText(null);
                        setStyle("");
                    } else {
                        setText(item);
                        setAlignment(Pos.CENTER);

                        //We get here all the info of the Person of this row
                        UserProfile auxPerson = getTableView().getItems().get(getIndex());

                        if (auxPerson.getUsername().equals(View.getIsLoggedIn().getUsername())) {
                            setTextFill(Color.RED);
                            setStyle("-fx-background-color: #baffba;");
                        } else  {
                            setTextFill(Color.BLACK);
                            setStyle("");
                        }
                    }
                }
            };
        });



        score.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty); //This is mandatory

                    if (item == null || empty) { //If the cell is empty
                        setText(null);
                        setStyle("");
                    } else {

                        setText(String.valueOf(item));
                        setAlignment(Pos.CENTER);

                        //We get here all the info of the Person of this row
                        UserProfile auxPerson = getTableView().getItems().get(getIndex());

                        if (auxPerson.getUsername().equals(View.getIsLoggedIn().getUsername())) {
                            setTextFill(Color.RED);
                            setStyle("-fx-background-color: #baffba;");
                        } else  {
                            setTextFill(Color.BLACK);
                            setStyle("");
                        }
                    }
                }
            };
        });
    }


    public void registeredScoreBord(BorderPane pane) {
        if (View.getIsLoggedIn() != null) {
            Button button = new Button("Score Table");
            Button logout = new Button("logout");
            Button newGame = new Button("Game Menu");
            Button chat = new Button("Chat");

            newGame.setMinWidth(500);
            newGame.getStyleClass().add("button");
            logout.setMinWidth(500);
            logout.getStyleClass().add("button");
            button.setMinWidth(500);
            button.getStyleClass().add("button");
            chat.setMinWidth(500);
            chat.getStyleClass().add("button");
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        scoreTable(ProfileMenuGraphics.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            VBox vBox = (VBox) pane.getChildren().get(0);
            vBox.getChildren().add(vBox.getChildren().size() - 2, button);
            vBox.getChildren().add(vBox.getChildren().size() - 2, logout);
            vBox.getChildren().add(0, newGame);
            vBox.getChildren().add(1, chat);
            logout.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        View.setIsLoggedIn(null);
                        goToRegister(event);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            newGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        new GameMenuView().start(ProfileMenuGraphics.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            chat.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        ProfileMenuGraphics.getStage().close();
                        new ChatMain().start(new Stage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }


    public void newGameWithoutLogin(MouseEvent event) throws Exception {
        GameMenu.getInstance().start(ProfileMenuGraphics.getStage());
    }

    public void goToRegister(MouseEvent event) throws Exception {
        View.setIsLoggedIn(null);
        LoginMenuController.getInstance().register(ProfileMenuGraphics.getStage());
    }


}
