package controller;

import enums.Message;
import model.BaseCivilization;
import model.City;
import model.unit.Melee;
import model.unit.Ranged;
import model.unit.Unit;

import java.util.ArrayList;

public class GameController extends Controller {
    public int Score;
    public ArrayList<String> showNotificationsHistory() {
        ArrayList<String> notifs = new ArrayList<>();
        if (BaseCivilization.getNotifications().size() == 0)
            notifs.add(Message.NO_NOTIFICATIONS.toString());
        for (String string : BaseCivilization.getNotifications()) {
            notifs.add(string);
        }
        return notifs;
    }
    public City getCityByName(String name){
        for (City city : City.allCitis){
            if (city.getCityName().equals(name)) return city;
        }
        return null;
    }

    public Unit getUnitByGPS(float x , float y) {
        for (Unit unit : Unit.allUnits){
            if (unit.getX()==x && unit.getY()==y) return unit;
        }
        return null;
    }

    public Unit getUnMilitaryUnitByGPS(int x, int y) {
        for (Unit unit : Unit.allUnits){
            if (unit.getX()==x && unit.getY()==y && (unit instanceof Ranged || unit instanceof Melee)) return unit;
        }
        return null;
    }

    public Unit getMilitaryUnitByGPS(int x, int y) {
        for (Unit unit : Unit.allUnits){
            if (unit.getX()==x && unit.getY()==y && !(unit instanceof Ranged || unit instanceof Melee)) return unit;
        }
        return null;
    }
    public City getCityByGps(int x, int y){
        for (City city : City.allCitis){
            if (city.getOriginTile().getX()==x && city.getOriginTile().getY()==y) return city;
        }
        return null;
    }
}
