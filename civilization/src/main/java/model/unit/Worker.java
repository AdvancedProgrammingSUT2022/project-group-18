package model.unit;

public class Worker extends  Unit{
    public Worker(String name, int movement, int productionCost) {
        super(name , movement, productionCost);
        this.movementTemp = movement;
        this.movementPotential = movement;
    }

}
