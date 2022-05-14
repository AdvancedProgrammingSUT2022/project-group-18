package Model.unit.unitactoins;

import Model.unit.Melee;
import Model.unit.Ranged;
import Model.unit.Settler;
import Model.unit.Worker;

public class Delete extends AbstarctActoin{
    int id;
    public Delete(Ranged unit, int id,BaseCivilization b ) {
        super(unit);
        this.id = id;
    }

    public Delete(Melee unit, int id,BaseCivilization b) {
        super(unit);
        this.id = id;
    }

    public Delete(Worker unit, int id,BaseCivilization b) {
        super(unit);
        this.id = id;
    }

    public Delete(Settler unit, int id,BaseCivilization b) {
        super(unit);
        this.id = id;
    }
    public void delete(){
        b.units(id);


    }
}
