package controller;

import model.techs.Technologies;
import model.techs.Technology;

public abstract class Controller {
    private Technologies technologies = new Technologies();

    public void setTechnologies(Technologies technologies) {
        this.technologies = technologies;
    }

    public Technologies getTechnologies() {
        return technologies;
    }

    public Technology findTechnologyByName(String nameOfTech) {
        for (Technology tech : technologies.getTechs()) {
            if (tech.getName().equals(nameOfTech))
                return tech;
        }
        return null;
    }
}
