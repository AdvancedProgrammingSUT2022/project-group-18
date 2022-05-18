package controller;

import enums.Message;
import enums.Regexes;
import model.User;
import org.junit.Test;

import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class LoginMenuControllerCreatUserTest {

    @Test
    public void creatUserTest1() {
        LoginMenuController controller = new LoginMenuController();
        Matcher matcher = Regexes.getCommand("user create --username (?<us --nickname ni --password pas", Regexes.CREAT_USER1);
        assertEquals(controller.creatUser(matcher), Message.USER_CREAT.toString());
    }

    @Test
    public void creatUserTest2() {
        LoginMenuController controller = new LoginMenuController();
        Matcher matcher = Regexes.getCommand("user create --username (.*) --nickname nickkkkkk --password pass", Regexes.CREAT_USER1);
        controller.creatUser(matcher);
        assertEquals(controller.creatUser(matcher), Message.USER_EXIST_USERNAME_ONE + matcher.group("username") + Message.USER_EXIST_USERNAME_TWO);
    }

    @Test
    public void creatUserTest3() {
        LoginMenuController controller = new LoginMenuController();
        Matcher matcher = Regexes.getCommand("user create --username (?<username>.*) --nickname nick --password pass", Regexes.CREAT_USER1);
        controller.creatUser(matcher);
        Matcher matcher1 = Regexes.getCommand("user create --username (?<username> --nickname nick --password pass", Regexes.CREAT_USER1);
        assertEquals(controller.creatUser(matcher1), Message.USER_EXIST_NICKNAME_ONE + matcher1.group("nickname") + Message.USER_EXIST_USERNAME_TWO);
    }
    @Test
    public void matcherCreateUserTest1() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create --username (?<username>.*) --nickname (?<nickname>.*) --password (?<password>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }

    @Test
    public void matcherCreateUserTest2() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create --username (?<username>.*) --password (?<password>.*) --nickname (?<nickname>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }

    @Test
    public void matcherCreatUserTest3() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create --password (?<password>.*) --nickname (?<nickname>.*) --username (?<username>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }
    @Test
    public void matcherCreatUserTest4() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create --password (?<password>.*) --username (?<username>.*) --nickname (?<nickname>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }

    @Test
    public void matcherCreatUserTest5() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create --nickname (?<nickname>.*) --username (?<username>.*) --password (?<password>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }

    @Test
    public void matcherCreatUserTest6() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create --nickname (?<nickname>.*) --password (?<password>.*) --username (?<username>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }
    @Test
    public void matcherCreatUserTest7() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create -u (?<username>.*) -n (?<nickname>.*) -p (?<password>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }
    @Test
    public void matcherCreatUserTest8() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create -u (?<username>.*) -p (?<password>.*) -n (?<nickname>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }

    @Test
    public void matcherCreatUserTest9() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create -n (?<nickname>.*) -p (?<password>.*) -u (?<username>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }

    @Test
    public void matcherCreatUserTest10() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create -n (?<nickname>.*) -u (?<username>.*) -p (?<password>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }

    @Test
    public void matcherCreatUserTest11() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create -p (?<password>.*) -n (?<nickname>.*) -u (?<username>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }

    @Test
    public void matcherCreatUserTest12() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user create -p (?<password>.*) -u (?<username>.*) -n (?<nickname>.*)";
        assertNotNull(controller.matchCreateUser(input));
    }

    @Test
    public void matcherCreatUserTest13() {
        LoginMenuController controller = new LoginMenuController();
        String input = "user creat --p pass -u nick -n us";
        assertNull(controller.matchCreateUser(input));
    }

    @Test
    public void matchLoginTest1() {
        LoginMenuController controller = new LoginMenuController();
        String input  = "user login --username (?<username>.*) --password (?<password>.*)";
        assertNotNull(controller.matchLogin(input));
    }

    @Test
    public void matchLoginTest2() {
        LoginMenuController controller = new LoginMenuController();
        String input  = "user login --password (?<username>.*) --username (?<password>.*)";
        assertNotNull(controller.matchLogin(input));
    }

    @Test
    public void matchLoginTest3() {
        LoginMenuController controller = new LoginMenuController();
        String input  = "user login -p (?<username>.*) -u (?<password>.*)";
        assertNotNull(controller.matchLogin(input));
    }

    @Test
    public void matchLoginTest4() {
        LoginMenuController controller = new LoginMenuController();
        String input  = "user login -u (?<username>.*) -p (?<password>.*)";
        assertNotNull(controller.matchLogin(input));
    }

    @Test
    public void matchLoginTest5() {
        LoginMenuController controller = new LoginMenuController();
        String input  = "user login -u (?<username>.*) --p (?<password>.*)";
        assertNull(controller.matchLogin(input));
    }

    @Test
    public void loginUserTest1() {
        LoginMenuController controller = new LoginMenuController();
        new User("usernameee", "passsss", "nicknameeee");
        Matcher matcher = Regexes.getCommand("user login -u (?<username>.*) -p (?<password>.*)", Regexes.USER_LOGIN4);
        assertEquals(controller.loginUser(matcher), Message.NOT_MATCH);
    }

    @Test
    public void loginUserTest2() {
        LoginMenuController controller = new LoginMenuController();
        new User("usernameee", "passsss", "nicknameeee");
        Matcher matcher = Regexes.getCommand("user login -u usernameee -p (?<password>.*)", Regexes.USER_LOGIN4);
        assertEquals(controller.loginUser(matcher), Message.NOT_MATCH);
    }

    @Test
    public void loginUserTest3() {
        LoginMenuController controller = new LoginMenuController();
        new User("usernameee", "passsss", "nicknameeee");
        Matcher matcher = Regexes.getCommand("user login -u usernameee -p passsss", Regexes.USER_LOGIN4);
        assertEquals(controller.loginUser(matcher), Message.LOGIN_USER);
    }


}

