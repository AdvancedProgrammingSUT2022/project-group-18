package Model.unit.unitactoins;

import Model.unit.Melee;
import Model.unit.Ranged;

public class Support extends AbstarctActoin{
    public Support(Ranged unit) {
        super(unit);
    }
    public Support(Melee unit) {
        super(unit);
    }
    public void support (){
        unit.getCommand=false;
        unit.combatStrength++;

    }
}
