package model.unit;

import model.City;
import view.View;

public class Settler extends Unit {

    public Settler(String name, int movement, int productionCost) {
        this.name = name;
        this.movement = movement;
        this.movementTemp = movement;
        this.movementPotential = movement;
        this.productionCost = productionCost;
        View.getInCity().setCityFood(0);
    }
}
