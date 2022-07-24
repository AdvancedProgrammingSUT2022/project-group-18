package client.controller.unitactoins;

import client.model.unit.Melee;
import client.model.unit.Ranged;
import client.model.unit.Settler;
import client.model.unit.Worker;

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
