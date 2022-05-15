package model.unit;

import model.BaseCivilization;
import model.City;

public class Ranged extends Unit{
    public Ranged(String name, int movement, int combatStrength,int combatStrengthRanged,int ranged, int productionCost, boolean isMilitary,  boolean hasTerrainCost) {
        this.name = name;
        this.movement = movement;
        this.productionCost = productionCost;
        this.combatStrength = combatStrength;
        this.combatStrengthRanged = combatStrengthRanged;
        this.ranged = ranged;
        this.isMilitary = isMilitary;
        this.hasTerrainCost = hasTerrainCost;
    }
    public void rangedAttack(model.City city, Unit unit, BaseCivilization civilization){
            while (unit.hitPoints>1 && city.hitPoints>1){
                unit.hitPoints--;
                city.hitPoints--;
            }
    }
    public void readyForRangedAttack(){

    }
}
