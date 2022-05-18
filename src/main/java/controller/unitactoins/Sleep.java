package controller.unitactoins;

import model.unit.Melee;
import model.unit.Ranged;
import model.unit.Settler;
import model.unit.Worker;

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
       unit.sleepMode=true;
   }
}
