package client.controller;

import client.view.View;
import enums.Message;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import model.BaseCivilization;
import model.City;
import model.unit.Melee;
import model.unit.Ranged;
import model.unit.Unit;

import java.io.IOException;
import java.util.ArrayList;

public class GameController {
    public static int turn = 0;
    public int Score;

    public ArrayList<String> showNotificationsHistory() {
        ArrayList<String> notify = new ArrayList<>();
        if (BaseCivilization.getNotifications().size() == 0)
            notify.add(Message.NO_NOTIFICATIONS.toString());
        notify.addAll(BaseCivilization.getNotifications());
        return notify;
    }

    public City getCityByName(String name) {
        for (City city : City.allCities) {
            if (city.getCityName().equals(name)) return city;
        }
        return null;
    }

    public Unit getUnitByGPS(float x, float y) {
        for (Unit unit : Unit.allUnits) {
            if (unit.getX() == x && unit.getY() == y) return unit;
        }
        return null;
    }

    public Unit getUnMilitaryUnitByGPS(int x, int y) {
        for (Unit unit : Unit.allUnits) {
            if (unit.getX() == x && unit.getY() == y && (unit instanceof Ranged || unit instanceof Melee)) return unit;
        }
        return null;
    }

    public Unit getMilitaryUnitByGPS(int x, int y) {
        for (Unit unit : Unit.allUnits) {
            if (unit.getX() == x && unit.getY() == y && !(unit instanceof Ranged || unit instanceof Melee)) return unit;
        }
        return null;
    }

    public City getCityByGps(int x, int y) {
        for (City city : City.allCities) {
            if (city.getOriginTile().getX() == x && city.getOriginTile().getY() == y) return city;
        }
        return null;
    }

    public void saveGame(int miliSecond) {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(-1);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(miliSecond), (actionEvent -> {
            try {
                View.getIsLoggedIn().saveCivilization(View.getCivilization());
            } catch (IOException e) {
                e.printStackTrace();
            }
        })));
    }
}
