package model;

import model.techs.Technology;

public class Building {
    private String name;
    private int cost;
    private int maintenance;

    public Building(String name, int cost, int maintenance) {
        this.name = name;
        this.cost = cost;
        this.maintenance = maintenance;
    }
}
