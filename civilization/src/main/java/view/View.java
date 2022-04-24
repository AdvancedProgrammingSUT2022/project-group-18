package view;

import java.util.Locale;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);
    private static String inMenu = null;


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
