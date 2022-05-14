package Model.unit.unitactoins;

import Model.unit.Unit;

public abstract class AbstarctActoin extends Unit {
    protected Unit unit;

    public AbstarctActoin(Unit unit) {
        this.unit = unit;
    }

    public Unit getUnit() {
        return unit;
    }


}
