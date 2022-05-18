package model.unit;

import view.View;

public class Settler extends Unit {

    public Settler(String name, int movement, int productionCost) {
        super(name, movement, productionCost);
        View.getInCity().setCityFood(0);
    }
}
