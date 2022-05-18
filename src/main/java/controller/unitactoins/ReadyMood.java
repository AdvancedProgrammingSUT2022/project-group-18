package controller.unitactoins;

import model.unit.Melee;
import model.unit.Ranged;
import model.unit.Settler;
import model.unit.Worker;

public class ReadyMood extends AbstarctActoin {

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
