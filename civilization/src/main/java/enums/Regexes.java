package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regexes {
    MENUENTER("^menu\\s+enter\\s+(?<menuName>.*)$"),
    EXITMENU("^menu\\s+exit$"),
    SHOW_CURRENT_MENU("^menu show-current$"),
    CREAT_USER1("^user create --username (?<username>.*) --nickname (?<nickname>.*) --password (?<password>.*)$"),
    CREAT_USER2("^user create --username (?<username>.*) --password (?<password>.*) --nickname (?<nickname>.*)$"),
    CREAT_USER3("^user create --password (?<password>.*) --nickname (?<nickname>.*) --username (?<username>.*)$"),
    CREAT_USER4("^user create --password (?<password>.*) --username (?<username>.*) --nickname (?<nickname>.*)$"),
    CREAT_USER5("^user create --nickname (?<nickname>.*) --username (?<username>.*) --password (?<password>.*)$"),
    CREAT_USER6("^user create --nickname (?<nickname>.*) --password (?<password>.*) --username (?<username>.*)$"),
    CREAT_USER7("^user create -u (?<username>.*) -n (?<nickname>.*) -p (?<password>.*)$"),
    USER_LOGIN1("^user login --username (?<username>.*) --password (?<password>.*)$"),
    USER_LOGIN2("^user login --password (?<username>.*) --username (?<password>.*)$"),
    USER_LOGIN3("^user login -p (?<username>.*) -u (?<password>.*)$"),
    USER_LOGIN4("^user login -u (?<username>.*) -p (?<password>.*)$"),
    USER_LOGOUT("^user logout$"),

    //profile menu
    CHANGE_NICKNAME("^profile change [-][-]nickname (?<nickname>.*)$"),
    CHANGE_PASSWORD1("^profile change [-][-]password [-][-]current (?<currentPass>.*) --new (?<newPass>.*)$"),
    CHANGE_PASSWORD2("^profile change [-][-]password [-][-]new (?<newPass>.*) --current (?<currentPass>.*)$"),
    CHANGE_PASSWORD3("^profile change [-][-]current (?<currentPass>.*) [-][-]password --new (?<newPass>.*)$"),
    CHANGE_PASSWORD4("^profile change [-][-]current (?<currentPass>.*) [-][-]new (?<newPass>.*) --password$"),
    CHANGE_PASSWORD5("^profile change [-][-]new (?<newPass>.*) [-][-]current (?<currentPass>.*) --password$"),
    CHANGE_PASSWORD6("^profile change [-][-]new (?<newPass>.*) [-][-]password --current (?<currentPass>.*)$"),



    //game menu regexes
    PLAY_GAME("^play game [([-][-]player[0-9] \\S+)]+$"),
    INCREASE_TURN("^increase --turn (?<amount>\\d+)$"),
    INCREASE_GOLD("^increase --gold (?<amount>\\d+)$");

    private String regex;
    Regexes(String regex) {
        this.regex = regex;
    }
    public static Matcher getCommand (String input, Regexes comand) {
        Matcher matcher = Pattern.compile(comand.regex).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
