package controller;

import enums.Message;
import model.BaseCivilization;
import model.City;
import model.unit.Unit;

import java.util.ArrayList;

public class GameController extends Controller {

    public ArrayList<String> showNotificationsHistory() {
        return BaseCivilization.getNotifications();
    }
}
