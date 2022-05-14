package Model.unit.unitactoins;

import Model.unit.Melee;
import Model.unit.Ranged;
import Model.unit.Settler;
import Model.unit.Worker;

public class WakeUp extends AbstarctActoin{
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
        if(unit.sleepmood==true){
            unit.getCommand=true;
        }
    }

}
