package client.controller.unitactoins;

import model.hex;
import model.unit.Melee;
import model.unit.Ranged;

public class Settle extends AbstarctActoin {

    public Settle(Ranged unit) {
        super(unit);
    }
    public Settle(Melee unit) {
        super(unit);
    }
    public void settle(){
    if(unit.City.equals(hex.City[unit.curTileId])){
        unit.combatStrength+=2;
        }
    }
}
