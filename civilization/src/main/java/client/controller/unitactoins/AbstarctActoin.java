package client.controller.unitactoins;

import model.BaseCivilization;
import model.unit.*;

public abstract class AbstarctActoin {
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
