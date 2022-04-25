package view;

import model.User;

import java.util.Locale;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);
    private static String inMenu = null;
    private static User isLogedIn = null;

    public static void setIsLogedIn(User isLogedIn) {
        View.isLogedIn = isLogedIn;
    }

    public static User getIsLogedIn() {
        return isLogedIn;
    }

    protected static Scanner getScanner() {
        return View.scanner;
    }

    protected String getInput() {
        return View.getScanner().nextLine().trim().toLowerCase(Locale.ROOT);
    }

    public static void setInMenu(String inMenu) {
        View.inMenu = inMenu;
    }

    public static String getInMenu() {
        return inMenu;
    }
}
