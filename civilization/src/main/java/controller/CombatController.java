package controller;

import controller.unitactoins.Delete;
import enums.Message;
import model.BaseCivilization;
import model.City;
import model.hex;
import model.unit.*;
import view.View;

import java.util.regex.Matcher;

public class CombatController extends Controller {
    public Message AnnouncementCombat() { //اعلان جنگ
        Message message = null;
        return message; // just for run code and don't have errors
    }

    public Message Combat() {
        Message message = null;
        return message; // just for run code and don't have errors
    }

    public Message attackOfUnitToCity(Matcher matcher) {
        String unitName = matcher.group("unitName");
        String cityName = matcher.group("cityName");
        Unit unit = BaseCivilization.findUnitByName(unitName);
        City city = BaseCivilization.findCityByName(cityName);
        if (city == null)
            return Message.CITY_NOT_EXIST_WITH_NAME;
        else if (unit == null)
            return Message.UNIT_NOT_EXIST;
        else {
            effectModifiersForUnitInAttackToCity(unit, city);
            if (cityIsDead(city) != null) {
                safeDeleteCity();
                return Message.DESTROYED_CITY;
            }
            return Message.COMBAT_SUCCESSFUL;
        }
    }

    public Message attackOfCityToUnit(Matcher matcher) {
        String unitName = matcher.group("unitName");
        String cityName = matcher.group("cityName");
        Unit unit = BaseCivilization.findUnitByName(unitName);
        City city = BaseCivilization.findCityByName(cityName);
        if (city == null)
            return Message.CITY_NOT_EXIST_WITH_NAME;
        else if (unit == null)
            return Message.UNIT_NOT_EXIST;
        else {
            effectModifiersForCityInAttackToUnit(unit, city);
            if (unitIsDead(unit) != null) {
                safeDeleteUnits();
                return Message.KILL_UNIT;
            }
            return Message.COMBAT_SUCCESSFUL;
        }
    }

    public void effectModifiersForUnitInAttackToCity(Unit unit, City city) {
        switch (hex.getRandLand()) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                city.decreaseHealth((int) (unit.getCombatStrength() * 1.33));
                break;
            case 3:
            case 7:
                city.decreaseHealth((int) (unit.getCombatStrength() * 0.75));
                break;
            default:
                city.decreaseHealth(unit.getCombatStrength());
                break;
        }
        switch (hex.getFeature()) {
            case 0:
            case 2:
            case 3:
                city.decreaseHealth((int) (unit.getCombatStrength() * 1.33));
                break;
            case 1:
            case 6:
            default:
                city.decreaseHealth(unit.getCombatStrength());
                break;
            case 4:
            case 5:
                city.decreaseHealth((int) (unit.getCombatStrength() * 0.75));
                break;

        }
    }
    public void effectModifiersForCityInAttackToUnit(Unit unit, City city) {
        switch (hex.getRandLand()) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                unit.decreaseHealth((int)(city.getCityStrength() * 1.33));
                break;
            case 3:
            case 7:
                unit.decreaseHealth((int)(city.getCityStrength() * 0.75));
                break;
            default:
                unit.decreaseHealth(city.getCityStrength());
                break;
        }
        switch (hex.getFeature()) {
            case 0:
            case 2:
            case 3:
                unit.decreaseHealth((int)(city.getCityStrength() * 1.33));
                break;
            case 1:
            case 6:
            default:
                unit.decreaseHealth(city.getCityStrength());
                break;
            case 4:
            case 5:
                unit.decreaseHealth((int)(city.getCityStrength() * 0.75));
                break;

        }
    }

/*    public Message setStrength(Unit unit) {
        //when this method calls for a unit, unit go's to sleep
        if(unit instanceof Ranged || unit instanceof Melee) {
            if(!unit.getStrengths()) {
                unit.setStrengths(true);
                unit.increaseHitPoints((int)(0.25 * unit.getHitPoints()));
                return Message.STRENGTHS;
            }
            else {
                unit.increaseHitPoints((int)(0.5 * unit.getHitPoints()));
                return Message.STRENGTHS;
            }
        }
        return Message.UNIT_CANT_STRENGTHS;

    }*/


    public void ColdWar() {
    }

    public void radiusHealth() {
    }

    public void MPUse() {
    }

    public void receiveXP() {
    }

    public Unit unitIsDead(Unit unit) {
        if (unit.getHitPoints() == 0) {
            return unit;
        }
        return null;
    }

    public City cityIsDead(City city) {
        if (city.getHitPoints() == 0)
            return city;
        return null;
    }

    public void safeDeleteCity() {
        for (City city : View.getCivilization().getCities()) {
            if (cityIsDead(city) != null)
                city.destroy();
        }
    }

    public void safeDeleteUnits() {
        for (Unit unit : View.getCivilization().getUnits())
            if (unitIsDead(unit) != null) {
                if (unit instanceof Ranged)
                    new Delete((Ranged) unit, View.getCivilization().findIndexOfUnit(unit), View.getCivilization());
                else if (unit instanceof Melee)
                    new Delete((Melee) unit, View.getCivilization().findIndexOfUnit(unit), View.getCivilization());
                else if (unit instanceof Settler)
                    new Delete((Settler) unit, View.getCivilization().findIndexOfUnit(unit), View.getCivilization());
                else if (unit instanceof Worker)
                    new Delete((Worker) unit, View.getCivilization().findIndexOfUnit(unit), View.getCivilization());
            }
    }

    public void hpsInUnitCityCombat() {
    }

    public Message WarningAlert() {
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
