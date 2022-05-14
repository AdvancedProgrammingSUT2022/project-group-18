package Model.unit.unitactoins;

import Model.unit.Melee;
import Model.unit.Ranged;
import Model.unit.Settler;
import Model.unit.Worker;


public class ReadyForRangedAttack extends AbstarctActoin {
    public ReadyForRangedAttack(Settler unit,int target) {
        super(unit);
        this.unit.target=target;
    }
    public ReadyForRangedAttack(Worker unit,int target) {
        super(unit);
        this.unit.target=target;
    }
    public ReadyForRangedAttack(Ranged unit,int target) {
        super(unit);
        this.unit.target=target;
    }
    public ReadyForRangedAttack(Melee unit,int target) {
        super(unit);
        this.unit.target=target;

    }



}
