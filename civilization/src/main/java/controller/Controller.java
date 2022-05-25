package controller;

import enums.Message;
import model.hex;
import model.techs.Technology;
import view.*;

import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;


public abstract class Controller {
    public static int turn = 0;
    public void exitMenu() {
        System.exit(0);
    }

    public Technology findTechnologyByName(String nameOfTech) {
        for (Technology tech : Technology.getTechnologies()) {
            if (tech.getName().equals(nameOfTech))
                return tech;
        }
        return null;
    }

    public Message enterMenu(Matcher matcher) {
        String menuName = matcher.group("menuName");
        if (View.getIsLoggedIn() == null)
            return Message.LOGINERROR;
        else if (View.getInMenu().toLowerCase(Locale.ROOT).equals("game menu") || View.getInMenu().toLowerCase(Locale.ROOT).equals("profile menu"))
            return Message.IVALIDENTERMENU;

        switch (menuName.toLowerCase(Locale.ROOT)) {
            case "main menu":
                goToMainMenu();
                break;
            case "login menu":
                logout();
                break;
            case "profile menu":
                try {
                    goToProfile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "game menu":
                return Message.GAME_WITH_NO_PLAYER;
            default:
                return Message.INVALID_MENU_NAME;
        }

        return null;
    }

    public void goToMainMenu() {
        MainMenuView view = new MainMenuView();
        View.setInMenu("Main Menu");
        view.run();
    }

    public String showCurrentMenu() {
        return View.getInMenu();
    }

    public void logout() {
        View.setIsLoggedIn(null);
        View.setInMenu("Login Menu");
        LoginMenuView view = new LoginMenuView();
        view.run();
    }

    public void goToProfile() throws IOException {
        ProfileView view = new ProfileView();
        View.setInMenu("Profile Menu");
        view.run();
    }

    public void startGame() {
        View.setInMenu("Game Menu");
        GameMenuView view = new GameMenuView();
        for (int i = 0; i < 17; i++) {
            hex.cc(hex.Unit, hex.City);
            hex.getInfo(hex.Unit, hex.City, i);
            hex.printMap(hex.Unit, hex.City, i, hex.randFeature, hex.randLand, hex.featuresType);
        }
        view.run();
    }


}
