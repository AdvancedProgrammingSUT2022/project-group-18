package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Building {
    private String name;
    private int cost;
    private int maintenance;
    private ImageView icon = new ImageView();

    public Building(String name, int cost, int maintenance) {
        this.name = name;
        this.cost = cost;
        this.maintenance = maintenance;
        this.icon.setImage(new Image(Building.class.getResource("/BuildingIcons/" + name + ".png").toExternalForm()));

    }


    public ImageView getIcon() {
        return icon;
    }
}
