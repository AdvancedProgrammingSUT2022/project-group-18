package client.controller.unitactoins;

import model.unit.Melee;
import model.unit.Ranged;

public class HealthSupport extends AbstarctActoin {
    public HealthSupport(Ranged unit) {
        super(unit);
    }
    public HealthSupport(Melee unit) {
        super(unit);
    }
    public void healthSupport(){
        unit.hitPoints++;
    }
}
