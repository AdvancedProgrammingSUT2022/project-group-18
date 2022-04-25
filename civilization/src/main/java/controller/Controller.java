package controller;

import model.techs.Technologies;
import model.techs.Technology;

import java.util.Locale;

public abstract class Controller {
    private Technology technologies = new Technology();

    public void setTechnologies(Technologies technologies) {
        this.technologies = technologies;
    }

    public Technologies getTechnologies() {
        return technologies;
    }

    public Technology findTechnologyByName(String nameOfTech) {
        for (Technology tech : technologies.getTechnologies()) {
            if (tech.getName().equals(nameOfTech))
                return tech;
        }
        return null;
    }

    public void goToMenu(String menuName) {
        if(menuName.toLowerCase(Locale.ROOT).equals("login"))
            //TODO;
        else if(menuName.toLowerCase(Locale.ROOT).equals("main"))
            //TODO
        else if(menuName.toLowerCase(Locale.ROOT).equals("play game"))
            //TODO
        else
            //TODO profile menu
    }
}
