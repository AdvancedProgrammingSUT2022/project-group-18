package Model.unit.unitactoins;

import Model.unit.Settler;

public class FoundCity extends AbstarctActoin{
    public FoundCity(Settler unit,BaseCivilization b){
        super(unit);
        super(b);
    }
    public void foundCity(){
        b.cities.add(new city());
        Delete(unit,b,unit.id);

    }

}
