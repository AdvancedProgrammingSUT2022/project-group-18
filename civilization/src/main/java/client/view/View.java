package client.view;

import javafx.application.Application;
import client.model.BaseCivilization;
import client.model.City;
import client.model.graphicModel.User;
import client.model.unit.Unit;

import java.util.Locale;
import java.util.Scanner;

public abstract class View extends Application {
    private static final Scanner scanner = new Scanner(System.in);
    private static String inMenu = "Login Menu";
    private static User isLoggedIn = null;
    private static City inCity = new City(500, 500);
    private static BaseCivilization civilization = null;
    private static Unit selectedUnit = null;

    public static void setIsLoggedIn(User isLoggedIn) {View.isLoggedIn = isLoggedIn;}
    public static User getIsLoggedIn() {return isLoggedIn;}
    public void removeIsLoggedIn() { View.isLoggedIn = null;}
    public static Scanner getScanner() {
        return View.scanner;
    }
    protected static String getInput() {
        return View.getScanner().nextLine().trim().toLowerCase(Locale.ROOT);
    }
    public static void setInMenu(String inMenu) {
        View.inMenu = inMenu;
    }
    public static String getInMenu() {
        return inMenu;
    }

    public static void setSelectedUnit(Unit selectedUnit) {
        View.selectedUnit = selectedUnit;
    }

    public static Unit getSelectedUnit() {
        return selectedUnit;
    }

    public static void setCivilization(BaseCivilization civilization) {View.civilization = civilization;}
    public static BaseCivilization getCivilization() {return civilization;}
    public static void setInCity(City inCity) {View.inCity = inCity;}
    public static City getInCity() {return inCity; }
}
