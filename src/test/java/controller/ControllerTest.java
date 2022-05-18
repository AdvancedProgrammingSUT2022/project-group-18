package controller;

import enums.Message;
import enums.Regexes;
import model.User;
import model.techs.Technology;

import org.junit.Test;

import org.mockito.Mock;
import view.LoginMenuView;
import view.View;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.*;


public class ControllerTest {

    @Test
    public void findTechByNameTest1() {
        Technology tech = new Technology("Archery", 35, "Agriculture", "Mathematics", "Archer");
        Technology.setTechnologies(tech);
        LoginMenuController controller = new LoginMenuController();
        assertEquals(controller.findTechnologyByName("Archery"), tech);
    }

    @Test
    public void findTechByNameTest2() {
        LoginMenuController controller = new LoginMenuController();
        assertNull(controller.findTechnologyByName("Archer"));
    }

    @Test
    public void enterMenuTest1() {
        LoginMenuController controller = new LoginMenuController();
        View.setIsLoggedIn(null);
        assertEquals(controller.enterMenu(Regexes.getCommand("menu enter game menu", Regexes.MENU_ENTER)), Message.LOGINERROR);
    }

    @Test
    public void enterMenuTest2() {
        LoginMenuController controller = new LoginMenuController();
        User user = new User("name", "pass", "nick");
        View.setIsLoggedIn(user);
        //when(View.getInMenu()).thenReturn("game menu");
        View.setInMenu("game menu");
        assertEquals(controller.enterMenu(Regexes.getCommand("menu enter game menu", Regexes.MENU_ENTER)), Message.IVALIDENTERMENU);
    }

    @Test
    public void enterMenuTest3() {
        LoginMenuController controller = new LoginMenuController();
        User user = new User("name", "pass", "nick");
        View.setInMenu("main menu");
        View.setIsLoggedIn(user);
        assertEquals(controller.enterMenu(Regexes.getCommand("menu enter game menu", Regexes.MENU_ENTER)), Message.GAME_WITH_NO_PLAYER);
    }

    @Test
    public void enterMenuTest4() {
        LoginMenuController controller = new LoginMenuController();
        User user = new User("name", "pass", "nick");
        View.setIsLoggedIn(user);
        assertEquals(controller.enterMenu(Regexes.getCommand("menu enter any menu", Regexes.MENU_ENTER)), Message.INVALID_MENU_NAME);
    }

    @Test
    public void showCurrentMenuTest1() {
        LoginMenuController controller = new LoginMenuController();
        View.setInMenu("Main Menu");
        assertEquals(controller.showCurrentMenu(), "Main Menu");
    }

    @Test
    public void showCurrentMenuTest2() {
        LoginMenuController controller = new LoginMenuController();
        View.setInMenu("Login Menu");
        assertEquals(controller.showCurrentMenu(), "Login Menu");
    }

    @Test
    public void showCurrentMenuTest3() {
        LoginMenuController controller = new LoginMenuController();
        View.setInMenu("Profile Menu");
        assertEquals(controller.showCurrentMenu(), "Profile Menu");
    }

    @Test
    public void showCurrentMenuTest4() {
        LoginMenuController controller = new LoginMenuController();
        View.setInMenu("Game Menu");
        assertEquals(controller.showCurrentMenu(), "Game Menu");
    }





}
