package controller;

import enums.Message;
import model.BaseCivilization;

import java.util.ArrayList;

public class GameController extends Controller {

    public ArrayList<String> showNotificationsHistory() {
        ArrayList<String> notifs = new ArrayList<>();
        if (BaseCivilization.getNotifications().size() == 0)
            notifs.add(Message.NO_NOTIFICATIONS.toString());
        for (String string : BaseCivilization.getNotifications()) {
            notifs.add(string);
        }
        return notifs;
    }
}
