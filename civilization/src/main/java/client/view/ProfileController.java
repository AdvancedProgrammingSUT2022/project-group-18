package client.view;

import model.graphicModel.ProfilePhoto;
import model.graphicModel.User;
import enums.Message;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileController extends Controller {

    private static ProfileController controller;
    private static final List<String> anotherList = Arrays.asList("blue.jpg", "green.jpg", "orange.jpg",
            "purple.jpg", "red.jpg", "shelakhte.jpg", "yellow.jpg", "lightBlue.jpg");
    public static ArrayList<String> urls = new ArrayList<>(anotherList);
    @FXML
    private TextField nickName;
    @FXML
    private PasswordField cpyNewPass;
    @FXML
    private PasswordField newPass;
    @FXML
    private PasswordField currentPass;

    public static ProfileController getInstance() {
        if (controller == null)
            controller = new ProfileController();
        return controller;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        BorderPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/profileController.fxml")));
        addPhotos(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void changePassword(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        BorderPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/profileControllerPass.fxml")));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void changeNickname(Stage stage) throws Exception {
        ProfileMenuGraphics.setStage(stage);
        BorderPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/profileControllerNick.fxml")));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void addPhotos(BorderPane pane) throws IOException {
        GridPane gridPane = new GridPane();
        ArrayList<ProfilePhoto> rectangles = new ArrayList<>();


        int counter = 0;
        gridPane.setTranslateY(130);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                ProfilePhoto photo = new ProfilePhoto(urls.get(counter));
                onMouseClicked(photo);
                rectangles.add(photo);
                gridPane.add(rectangles.get(counter), i, j);
                counter++;

            }
        }
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        pane.setTop(gridPane);

    }

    public void browsAndChoosePhoto(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            File dest = new File("src/main/resources/images/" + file.getName());
            ImageIO.write(bufferedImage, "jpg", dest);
            System.out.println("Writing complete.");

            ProfilePhoto photo = new ProfilePhoto(file.getName());
            View.getIsLoggedIn().setPhotoAddress(photo.getName());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Profile Photo Changed successfully!");
            alert.show();
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onMouseClicked(ProfilePhoto photo) {
        photo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                try {
                    View.getIsLoggedIn().setPhotoAddress(photo.getName());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Profile Photo Changed successfully!");
                    alert.show();
                } catch (IOException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Something went wrong:{");
                    alert.show();
                    e.printStackTrace();
                }
            }
        });

        photo.setOnMouseEntered(mouseEvent -> {
            photo.getStyleClass().add("button");
            photo.setCursor(Cursor.HAND);
        });
        photo.setOnMouseExited(mouseEvent -> photo.setCursor(Cursor.CLOSED_HAND));
    }


    public void changeNickname(MouseEvent event) throws IOException {
        String nickname = nickName.getText();
        int size = nickName.getLength();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        if (size == 0) {
            alert.setContentText("please fill all the blanks");
            alert.show();
        } else if (User.getUserByUsernameOrNickname(nickname, "nickname") != null) {
            alert.setContentText(Message.USER_EXIST_NICKNAME_ONE + nickname + Message.USER_EXIST_USERNAME_TWO);
            alert.show();
        } else {
            View.getIsLoggedIn().setNickname(nickname);
            Alert ok = new Alert(Alert.AlertType.INFORMATION);
            ok.setHeaderText(null);
            ok.setContentText(Message.CHANGE_NICKNAME.toString());
            ok.show();
        }
    }


    public void backToMenu(MouseEvent mouseEvent) throws Exception {
        ProfileMenuGraphics.getInstance().start(ProfileMenuGraphics.getStage());
    }

    public void changePassword(MouseEvent keyEvent) throws IOException {
        String currentPassText = currentPass.getText();
        String newPassText = newPass.getText();
        String newPssCpy = cpyNewPass.getText();

        int size1 = currentPass.getLength();
        int size2 = newPass.getLength();
        int size3 = cpyNewPass.getLength();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);

        if (size1 == 0 || size2 == 0 || size3 == 0) {
            alert.setContentText("please fill all the blanks");
            alert.show();
        } else if (!View.getIsLoggedIn().getPassword().equals(currentPassText)) {
            alert.setContentText("current password isn't correct");
            alert.show();
        } else if (!newPassText.equals(newPssCpy)) {
            alert.setContentText("new passwords dose not match");
            alert.show();
        } else if (View.getIsLoggedIn().getPassword().equals(newPassText)) {
            alert.setContentText(Message.SAME_PASS.toString());
            alert.show();
        } else {
            View.getIsLoggedIn().passChange(newPassText);
            Alert ok = new Alert(Alert.AlertType.INFORMATION);
            ok.setHeaderText(null);
            ok.setContentText(Message.CHANGE_PASSWORD.toString());
            ok.show();
            try {
                ProfileMenuGraphics.getInstance().start(ProfileMenuGraphics.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
