package controller;

import enums.Message;
import enums.UnitEnum;
import model.hex;
import model.techs.Technology;
import model.unit.Unit;
import model.unit.Units;
import view.*;

import java.util.Locale;
import java.util.regex.Matcher;


public abstract class Controller {

    public Technology findTechnologyByName(String nameOfTech) {
        for (Technology tech : Technology.getTechnologies()) {
            if (tech.getName().equals(nameOfTech))
                return tech;
        }
        return null;
    }

    public Message enterMenu(Matcher matcher) {
        String menuName = matcher.group("menuName");
        if (View.getIsLogedIn() == null)
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
                goToProfile();
                break;
            case "game menu":
                startGame();
                break;
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
        View.setIsLogedIn(null);
        View.setInMenu("Login Menu");
        LoginMenuView view = new LoginMenuView();
        view.run();
    }

    public void goToProfile() {
        ProfileView view = new ProfileView();
        View.setInMenu("Profile Menu");
        view.run();
    }

    public void startGame() {
        View.setInMenu("Game Menu");
        GameMenuView view = new GameMenuView();
        hex.printmap();
        view.run();
    }

}
