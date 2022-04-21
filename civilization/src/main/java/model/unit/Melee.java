package model.unit;

public class Melee extends Unit {
    public Melee(String name, int movement,int combatStrength, int productionCost, boolean isMilitary) {
        this.name = name;
        this.movement = movement;
        this.productionCost = productionCost;
        this.isMilitary = isMilitary;
        this.combatStrength=combatStrength;

    }
    public void  MELEEATTACK (){

    }

}

