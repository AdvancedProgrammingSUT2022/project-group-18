package client.controller.unitactoins;

import model.unit.Melee;
import model.unit.Ranged;
import model.unit.Settler;
import model.unit.Worker;


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
