package controller;

import model.techs.Technologies;
import model.techs.Technology;

public abstract class Controller {
    Technologies technologies = new Technologies();

    public Technology findTechnologyByName(String nameOfTech) {
        for (Technology tech : technologies.getTechs()) {
            if (tech.getName().equals(nameOfTech))
                return tech;
        }
        return null;
    }
}
