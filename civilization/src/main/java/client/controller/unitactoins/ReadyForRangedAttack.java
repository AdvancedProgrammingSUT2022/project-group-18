package client.controller.unitactoins;

import client.model.unit.Melee;
import client.model.unit.Ranged;
import client.model.unit.Settler;
import client.model.unit.Worker;


public class ReadyForRangedAttack extends AbstarctActoin {
    public ReadyForRangedAttack(Settler unit, int target) {
        super(unit);
        this.unit.target=target;
    }
    public ReadyForRangedAttack(Worker unit, int target) {
        super(unit);
        this.unit.target=target;
    }
    public ReadyForRangedAttack(Ranged unit, int target) {
        super(unit);
        this.unit.target=target;
    }
    public ReadyForRangedAttack(Melee unit, int target) {
        super(unit);
        this.unit.target=target;

    }



}
