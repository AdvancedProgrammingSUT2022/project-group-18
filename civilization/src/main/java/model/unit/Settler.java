package Model.unit;

public class Settler extends Unit {

    public Settler(String name, int movement, int productionCost) {
        this.name = name;
        this.movement = movement;
        this.movementTemp = movement;
        this.movementPotential = movement;
        this.productionCost = productionCost;


    }
}
