package controller;

import enums.Message;
import model.BaseCivilization;
import model.City;
import model.unit.Unit;

public class CombatController extends Controller{
    public Message AnnouncementCombat(){ //اعلان جنگ
        Message message = null;
        return message; // just for run code and don't have errors
    }
    public Message Combat(){
        Message message = null;
        return message; // just for run code and don't have errors
    }
    public void ColdWar(){}
    public void radiusHealth(){}
    public void MPUse(){}
    public void receiveXP(){}
    public void hpsInUnitCityCombat(){
        if()
    }
    public Message WarningAlert(){
        Message message = null;
        return message; // just for run code and don't have errors
    }
    public void reducePointOfCity(){}
    public void cityCapture(){}
    public void AttackMode(){}
    public void DamageRepair(){}
    public static void attack(City city, Unit unit, BaseCivilization civilization) {
        unit.isAttacking = true;
        while (unit.hitPoints != 0 && city.hitPoints != 0) {
            unit.hitPoints--;
            city.hitPoints--;
        }
        if (unit.hitPoints == 0) civilization.deleteUnit(unit);
        if (city.hitPoints == 0) city.winCombat(civilization);
    }


}
