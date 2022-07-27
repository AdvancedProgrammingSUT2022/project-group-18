package model.unit;

import client.controller.CombatController;
import model.BaseCivilization;
import model.City;

public class Melee extends Unit {
    public Melee(String name, int movement,int combatStrength, int productionCost, boolean isMilitary, model.City city) {
        super(name, movement, productionCost, city);
        this.isMilitary = isMilitary;
        this.combatStrength=combatStrength;
    }
    public void  MELEEATTACK (){
    }
    public void  meleeCombat (City city , BaseCivilization civilization){
        this.x = city.getOriginTile().getX();
        this.y = city.getOriginTile().getY();
        CombatController.attack(city , this , civilization);
    }
}

