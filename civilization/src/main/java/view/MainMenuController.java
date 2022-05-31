package view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.graphicModel.User;

import java.util.ArrayList;
import java.util.Objects;

import static model.graphicModel.User.getUsersFromDataBase;


public class MainMenuController extends Controller {
    private static MainMenuController controller;

    public static MainMenuController getInstance() {
        if (controller == null)
            controller = new MainMenuController();
        return controller;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        BorderPane parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/mainMenu.fxml")));
        notRegisteredGame(parent);
        registeredScoreBord(parent);
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public void scoreTable(Stage stage) throws Exception {
        //BorderPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/scoreTable.fxml")));
        stage = new Stage();
        TableView<User> table = new TableView<>();

        TableColumn<User, String> userNameCol = new TableColumn<>("username");

        TableColumn<User, Integer> score = new TableColumn<>("score");

        userNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));

        userNameCol.setSortType(TableColumn.SortType.DESCENDING);

        ObservableList<User> list = getUserList();
        table.setItems(list);

        table.getColumns().addAll(userNameCol, score);

        StackPane root = new StackPane();
        //root.setPadding(new Insets(5));
        root.getChildren().add(table);

        stage.setTitle("TableView");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private ObservableList<User> getUserList() {
        ArrayList<User> users = getUsersFromDataBase();


        return FXCollections.observableArrayList(users);
    }

    public void registeredScoreBord(BorderPane pane) {
        if (View.getIsLoggedIn() != null) {
            Button button = new Button("Score Table");
            button.setMinWidth(500);
            button.getStyleClass().add("button");
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
        }

    }

    public void notRegisteredGame(BorderPane parent) {
        if (View.getIsLoggedIn() == null) {
            Button button = new Button("new Game without login");
            button.setMinWidth(500);
            button.getStyleClass().add("button");
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        newGameWithoutLogin(event);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            VBox vBox = (VBox) parent.getChildren().get(0);
            vBox.getChildren().add(0, button);
        }
    }

    public void newGame(MouseEvent event) throws Exception {
        if (View.getIsLoggedIn() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Login First!");
            alert.show();
        } else {
            //TODO go to main menu
        }
    }

    public void newGameWithoutLogin(MouseEvent event) throws Exception {
        //TODO go to main menu
    }

    public void goToRegister(MouseEvent event) throws Exception {
        View.setIsLoggedIn(null);
        View.setInMenu("Login Menu");
        LoginMenuController.getInstance().register(ProfileMenuGraphics.getStage());
    }


}
