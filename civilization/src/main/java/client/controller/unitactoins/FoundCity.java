package client.controller.unitactoins;

import client.model.BaseCivilization;
import client.model.unit.Settler;
import client.model.unit.Unit;

public class FoundCity extends AbstarctActoin{
    public FoundCity(Settler unit, BaseCivilization b){
        super(unit);
        b.decreaseHappiness();
        //super(b);
    }
    public void foundCity(BaseCivilization b, Unit unit){
        //b.setCities(new City());
        //Delete(unit,b,unit.id);

    }

}
