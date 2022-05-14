package Model.unit.unitactoins;

import Model.unit.Melee;
import Model.unit.Ranged;
import Model.unit.Settler;
import Model.unit.Worker;

public class Sleep extends AbstarctActoin  {
    public Sleep(Settler unit) {
        super(unit);
    }
    public Sleep(Worker unit) {
        super(unit);
    }
    public Sleep(Ranged unit) {
        super(unit);
    }
    public Sleep(Melee unit) {
        super(unit);
    }
   public void sleep(){
       unit.getCommand=false;
       unit.sleepmood=true;
   }
}
