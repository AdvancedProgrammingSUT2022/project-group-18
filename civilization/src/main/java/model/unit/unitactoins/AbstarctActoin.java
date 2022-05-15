package model.unit.unitactoins;

import model.BaseCivilization;
import model.unit.*;
import model.unit.Unit;

public abstract class AbstarctActoin extends Unit {
    protected Unit unit;

    public AbstarctActoin(Melee unit) {
        this.unit = unit;
    }
    public AbstarctActoin(Worker unit) {
        this.unit = unit;
    }
    public AbstarctActoin(Settler unit) {
        this.unit = unit;
    }
    public AbstarctActoin(Ranged unit) {
        this.unit = unit;
    }

    public AbstarctActoin(BaseCivilization b) {

    }

    public Unit getUnit() {
        return unit;
    }


}
