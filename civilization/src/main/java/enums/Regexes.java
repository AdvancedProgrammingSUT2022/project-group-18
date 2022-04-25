package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regexes {
    MENUENTER("^menue\\s+nter\\s+(?<menuName>.*)$"),
    EXITMENU("^menu\\s+exit$"),
    SHOW_CURRENT_MENU("^menu show-current$"),
    CREAT_NEW_USER("^user create --username (?<username>.*) --nickname (?<nickname>.*) --password (?<password>.*)$"),
    USER_LOGIN("^user login --username (?<username>.*) --password (?<password>.*)$"),
    USER_LOGOUT("^user logout$"),

    //profile menu
    CHANGE_NICKNAME("^profile change [-][-]nickname (?<nickname>.*)$"),
    CHANGE_PASSWORD("^profile change [-][-]password [-][-]current (?<currentPass>.*) --new (?<newPass>.*)$"),



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
