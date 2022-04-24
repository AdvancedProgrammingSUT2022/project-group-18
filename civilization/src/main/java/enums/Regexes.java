package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regexes {
    MENUENTER("^menue\\s+nter\\s+(?<menuName>\\S+)$");


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
