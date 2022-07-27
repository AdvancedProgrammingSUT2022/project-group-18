package client.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import client.view.View;


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
        View.getInCity().addBuilding(this);

    }


    public ImageView getIcon() {
        return icon;
    }
}
