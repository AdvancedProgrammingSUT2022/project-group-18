package client.controller.unitactoins;

import client.model.BaseCivilization;
import client.model.unit.Melee;
import client.model.unit.Ranged;
import client.model.unit.Settler;
import client.model.unit.Worker;

public class Delete extends AbstarctActoin{
    int id;
    public Delete(Ranged unit, int id, BaseCivilization b ) {
        super(unit);
        this.id = id;
    }

    public Delete(Melee unit, int id, BaseCivilization b) {
        super(unit);
        this.id = id;
    }

    public Delete(Worker unit, int id, BaseCivilization b) {
        super(unit);
        this.id = id;
    }

    public Delete(Settler unit, int id, BaseCivilization b) {
        super(unit);
        this.id = id;
    }

    public void delete(){
       // b.units.remove(id);


    }
}
