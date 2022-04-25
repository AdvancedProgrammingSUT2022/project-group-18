package controller;

import model.hex;
import model.techs.Technology;
import view.*;


public abstract class Controller {

    public Technology findTechnologyByName(String nameOfTech) {
        for (Technology tech : Technology.getTechnologies()) {
            if (tech.getName().equals(nameOfTech))
                return tech;
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
        LoginMenuView view = new LoginMenuView();
        view.run();
    }

    public void goToProfile() {
        ProfileView view = new ProfileView();
        view.run();
    }

    public void startGame() {
        View.setInMenu("Game Menu");
        GameMenuView view = new GameMenuView();
        view.run();
        hex.printmap();
        //TODO print map for checkpoint
    }


}
