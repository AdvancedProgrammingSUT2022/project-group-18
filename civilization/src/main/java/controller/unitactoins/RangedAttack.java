package controller.unitactoins;

import model.BaseCivilization;
import model.unit.Ranged;


public class RangedAttack extends AbstarctActoin {
    public RangedAttack(Ranged unit, BaseCivilization b){
        super(unit);

    }
    public void rangedAttack(){
/*        if(unit.combatStrengthRanged>info.allUnit.get(unit.target).combatStrength){
            unit.combatStrengthRanged=unit.combatStrengthRanged-b.units.get(unit.target).combatStrength;


        }
        else{
           b.units.get(unit.target).combatStrength=b.units.get(unit.target).combatStrength-unit.combatStrengthRanged;
        }*/
    }
}
