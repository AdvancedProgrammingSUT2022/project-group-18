package model.unit;

import controller.CombatController;
import model.BaseCivilization;
import model.City;

public class Melee extends Unit {
    public Melee(String name, int movement,int combatStrength, int productionCost, boolean isMilitary) {
        super();
    }
    public void  MELEEATTACK (){
    }
    public void  meleeCombat (City city , BaseCivilization civilization){
        this.x = city.getOriginTile().getX();
        this.y = city.getOriginTile().getY();
        CombatController.attack(city , this , civilization);
    }
}

