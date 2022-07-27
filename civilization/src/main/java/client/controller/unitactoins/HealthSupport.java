package client.controller.unitactoins;

import client.model.unit.Melee;
import client.model.unit.Ranged;

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
