package controller.unitactoins;

import model.unit.Melee;
import model.unit.Ranged;
import model.unit.Settler;
import model.unit.Worker;

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
