package model.unit;

import client.view.View;

public class Settler extends Unit {

    public Settler(String name, int movement, int productionCost, model.City city) {
        super(name, movement, productionCost, city);
        View.getInCity().setCityFood(0);
    }
}
