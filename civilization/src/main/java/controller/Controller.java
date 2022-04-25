package controller;

import model.techs.Technologies;
import model.techs.Technology;

import java.util.Locale;

public abstract class Controller {

    public Technology findTechnologyByName(String nameOfTech) {
        for (Technology tech : Technology.getTechnologies()) {
            if (tech.getName().equals(nameOfTech))
                return tech;
        }
        return null;
    }

    public void goToMenu(String menuName) {
        if(menuName.toLowerCase(Locale.ROOT).equals("login menu"))
            //TODO;
        else if(menuName.toLowerCase(Locale.ROOT).equals("main menu"))
            //TODO
        else if(menuName.toLowerCase(Locale.ROOT).equals("play game"))
            //TODO
        else
            //TODO profile menu
    }
}
