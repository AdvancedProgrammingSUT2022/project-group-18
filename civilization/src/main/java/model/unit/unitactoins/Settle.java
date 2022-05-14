package Model.unit.unitactoins;

import Model.unit.Melee;
import Model.unit.Ranged;
import Model.unit.Unit;
import Model.hex;
public class Settle extends AbstarctActoin{

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
