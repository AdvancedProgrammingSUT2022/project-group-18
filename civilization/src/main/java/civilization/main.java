package civilization;

import controller.DataBase;
import view.LoginMenuView;

import java.io.IOException;

public class main {
    public static void main(String[] args) {
        System.out.println("besme Allahe ghaseme aljabbarin");
        LoginMenuView view = new LoginMenuView();
        view.run();
    }

}
