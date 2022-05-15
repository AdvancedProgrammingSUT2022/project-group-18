package controller;

import controller.unitactoins.Delete;
import enums.Message;
import model.BaseCivilization;
import model.City;
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
            city.decreaseHealth(unit.getcombatStrength());
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
            unit.decreaseHealth(city.getCityStrength());
            if (unitIsDead(unit) != null) {
                safeDeleteUnits();
                return Message.KILL_UNIT;
            }
            return Message.COMBAT_SUCCESSFUL;
        }
    }

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

    public void reducePointOfCity() {
    }

    public void cityCapture() {
    }

    public void AttackMode() {
    }

    public void DamageRepair() {
    }
}
