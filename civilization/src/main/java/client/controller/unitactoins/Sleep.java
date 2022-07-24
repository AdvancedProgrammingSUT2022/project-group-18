package client.controller.unitactoins;

import client.model.unit.Melee;
import client.model.unit.Ranged;
import client.model.unit.Settler;
import client.model.unit.Worker;

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
