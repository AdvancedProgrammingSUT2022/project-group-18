package controller.unitactoins;

import model.BaseCivilization;
import model.City;
import model.unit.Settler;
import model.unit.Unit;

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
