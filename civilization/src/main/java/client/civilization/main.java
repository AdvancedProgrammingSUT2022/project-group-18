package client.civilization;

import client.view.MainMenuController;

import static javafx.application.Application.launch;

public class main {
    public static void main(String[] args) {
        try {
            MainMenuController.initialize();
            launch(MainMenuController.class, args);
            //new ProfileMenuGraphics().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
