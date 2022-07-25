package model.techs;

import client.view.View;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Technology extends ImageView {
    private String name;
    private Integer cast;
    private String prerequisiteTechs;
    private String leadsToTechs;
    private String unlocks;


    public Technology(String name, Integer cast, String prerequisiteTechs, String leadsToTechs, String unlocks) {
        this.name = name;
        this.cast = cast;
        this.prerequisiteTechs = prerequisiteTechs;
        this.leadsToTechs = leadsToTechs;
        this.unlocks = unlocks;
        View.getCivilization().addTechnology(this);
        this.setImage(new Image(Technology.class.getResource("/technology/" + name + ".png").toExternalForm()));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCast(Integer cast) {
        this.cast = cast;
    }

    public void setPrerequisiteTechs(String prerequisiteTechs) {
        this.prerequisiteTechs = prerequisiteTechs;
    }

    public void setLeadsToTechs(String leadsToTechs) {
        this.leadsToTechs = leadsToTechs;
    }

    public void setUnlocks(String unlocks) {
        this.unlocks = unlocks;
    }

    public String getName() {
        return name;
    }

    public Integer getCast() {
        return cast;
    }

    public String getPrerequisiteTechs() {
        return prerequisiteTechs;
    }

    public String getLeadsToTechs() {
        return leadsToTechs;
    }

    public String getUnlocks() {
        return unlocks;
    }

}
