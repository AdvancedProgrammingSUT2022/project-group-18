package client.controller.unitactoins;

import client.model.unit.Melee;
import client.model.unit.Ranged;
import client.model.unit.Settler;
import client.model.unit.Worker;

public class WakeUp extends AbstarctActoin {
    public static boolean x=true;
    public static boolean y=true;
    public WakeUp(Settler unit) {
        super(unit);
    }
    public WakeUp(Worker unit) {
        super(unit);
    }
    public WakeUp(Ranged unit) {
        super(unit);
    }
    public WakeUp(Melee unit) {
        super(unit);
    }
    public  void wakeUp(){
        if(unit.sleepMode==true){
            unit.getCommand=true;
        }
    }

}
