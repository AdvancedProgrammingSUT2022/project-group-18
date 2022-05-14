package model.unit;

import model.BaseCivilization;
import model.City;

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
    public void  meleeCombat (City city , BaseCivilization civilization){
        this.x = city.getOriginTile().getX();
        this.y = city.getOriginTile().getY();
        Unit.attack(city , this , civilization);
    }
}

