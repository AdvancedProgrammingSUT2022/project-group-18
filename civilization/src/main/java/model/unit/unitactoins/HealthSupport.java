package Model.unit.unitactoins;

import Model.unit.Melee;
import Model.unit.Ranged;

public class HealthSupport extends AbstarctActoin{
    public HealthSupport(Ranged unit) {
        super(unit);
    }
    public HealthSupport(Melee unit) {
        super(unit);
    }
    public void healthSupport(){
        unit.health++;
    }
}
