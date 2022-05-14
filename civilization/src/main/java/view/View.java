package view;

import model.User;

import java.util.Locale;
import java.util.Scanner;

public abstract class View {
    private static final Scanner scanner = new Scanner(System.in);
    private static String inMenu = "Login Menu";
    private static User isLoggedIn = null;

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

    public abstract void run();
}
