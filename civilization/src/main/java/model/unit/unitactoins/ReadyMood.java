package Model.unit.unitactoins;

import Model.unit.Melee;
import Model.unit.Ranged;
import Model.unit.Settler;
import Model.unit.Worker;

public class ReadyMood extends AbstarctActoin   {

    public ReadyMood(Settler unit) {
        super(unit);
    }
    public ReadyMood(Worker unit) {
        super(unit);
    }
    public ReadyMood(Ranged unit) {
        super(unit);
    }
    public ReadyMood(Melee unit) {
        super(unit);
    }
    public void readyMood(){
        unit.getCommand=false;
      // if(){
            unit.getCommand=true;
       // }


    }


}
