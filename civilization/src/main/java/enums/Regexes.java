package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regexes {
    MENU_ENTER("^menu\\s+enter\\s+(?<menuName>.*)$"),
    EXIT_MENU("^exit menu$"),
    SHOW_CURRENT_MENU("^menu show-current$"),
    CREAT_USER1("^user create --username (?<username>.*) --nickname (?<nickname>.*) --password (?<password>.*)$"),
    CREAT_USER2("^user create --username (?<username>.*) --password (?<password>.*) --nickname (?<nickname>.*)$"),
    CREAT_USER3("^user create --password (?<password>.*) --nickname (?<nickname>.*) --username (?<username>.*)$"),
    CREAT_USER4("^user create --password (?<password>.*) --username (?<username>.*) --nickname (?<nickname>.*)$"),
    CREAT_USER5("^user create --nickname (?<nickname>.*) --username (?<username>.*) --password (?<password>.*)$"),
    CREAT_USER6("^user create --nickname (?<nickname>.*) --password (?<password>.*) --username (?<username>.*)$"),
    CREAT_USER11("^user create -u (?<username>.*) -n (?<nickname>.*) -p (?<password>.*)$"),
    CREAT_USER12("^user create -u (?<username>.*) -p (?<password>.*) -n (?<nickname>.*)$"),
    CREAT_USER13("^user create -n (?<nickname>.*) -p (?<password>.*) -u (?<username>.*)$"),
    CREAT_USER14("^user create -n (?<nickname>.*) -u (?<username>.*) -p (?<password>.*)$"),
    CREAT_USER15("^user create -p (?<password>.*) -n (?<nickname>.*) -u (?<username>.*)$"),
    CREAT_USER16("^user create -p (?<password>.*) -u (?<username>.*) -n (?<nickname>.*)$"),
    USER_LOGIN1("^user login --username (?<username>.*) --password (?<password>.*)$"),
    USER_LOGIN2("^user login --password (?<username>.*) --username (?<password>.*)$"),
    USER_LOGIN3("^user login -p (?<username>.*) -u (?<password>.*)$"),
    USER_LOGIN4("^user login -u (?<username>.*) -p (?<password>.*)$"),
    USER_LOGOUT("^user logout$"),

    //profile menu
    CHANGE_NICKNAME("^change [-][-]nickname (?<nickname>.*)$"),
    CHANGE_USERNAME("^change --username (?<username>.*)$"),
    CHANGE_PASSWORD1("^change [-][-]password [-][-]current (?<currentPass>.*) --new (?<newPass>.*)$"),
    CHANGE_PASSWORD2("^change [-][-]password [-][-]new (?<newPass>.*) --current (?<currentPass>.*)$"),
    CHANGE_PASSWORD3("^change [-][-]current (?<currentPass>.*) [-][-]password --new (?<newPass>.*)$"),
    CHANGE_PASSWORD4("^change [-][-]current (?<currentPass>.*) [-][-]new (?<newPass>.*) --password$"),
    CHANGE_PASSWORD5("^change [-][-]new (?<newPass>.*) [-][-]current (?<currentPass>.*) --password$"),
    CHANGE_PASSWORD6("^change [-][-]new (?<newPass>.*) [-][-]password --current (?<currentPass>.*)$"),
    CHANGE_PASSWORD11("^change -p -c (?<currentPass>.*) -n (?<newPass>.*)$"),
    CHANGE_PASSWORD12("^change -p -n (?<newPass>.*) -c (?<currentPass>.*)$"),
    CHANGE_PASSWORD13("^change -c (?<currentPass>.*) -p -n (?<newPass>.*)$"),
    CHANGE_PASSWORD14("^change -c (?<currentPass>.*) -n (?<newPass>.*) -p$"),
    CHANGE_PASSWORD15("^change -n (?<newPass>.*) -c (?<currentPass>.*) -p$"),
    CHANGE_PASSWORD16("^change -n (?<newPass>.*) -p -c (?<currentPass>.*)$"),





    //game menu regexes
    PLAY_GAME("^play game [([-][-]player[0-9] \\S+)]+$"),
    //kod haye taghalob
    INCREASE_TURN("^increase --turn (?<amount>\\d+)$"),
    INCREASE_GOLD("^increase --gold (?<amount>\\d+)$"),
    INCREASE_BEAKERS("^increase --beakers (?<amount>\\d+)$"),

    //dastourat bazi
    RESEARCH("^research$"),
    UNITS("units"),
    CITIES("cities"),
    DIPLOMACY("diplomacy"),
    VICTORY("victory"),
    DEMOGRAPHICS("demographics"),
    NOTIFICATIONS("notification history"),
    MILITARY("military"),
    ECONOMIC("economics"),
    DIPLOMATIC("diplomatic"),//what is differences between diplomatic and diplomacy?
    DEALS("deals"),
    UNIT_COMBAT_POSITION("unit combat position (?<amount>\\d[,]\\d{2})"),
    UNIT_NONCOMBAT_POSITION("unit noncombat position (?<amount>\\d[,]\\d{2})"),
    CITY_NAME("city (?<name>\\S+)"),
    CITY_POSITION("city position (?<amount>\\d[,]\\d{2})"),
    MOVETO_POSITION("move to position (?<amount>\\d[,]\\d{2})"),
    SLEEP("sleep"),
    ALERT("alert"),
    FORTIFY("fortify"),
    FORTIFY_HEAL("fortify heal"),
    GARRISON("garrison"),
    SETUP_RANGED("setup ranged"),
    ATTACK_POSITION("attack position (?<amount>\\d[,]\\d{2})"),
    FOUND_CITY("found city"),
    CANCEL_MISSION("cancel mission"),
    WAKE("wake"),
    DELETE("delete"),
    BUILD_ROAD("build road"),
    BUILD_RAILROAD("build railroad"),
    BUILD_FARM("build farm"),
    BUILD_MINE("build mine"),
    BUILD_TRADING_POST("build trading post"),
    BUILD_LUMBER_MILL("build lumber mill"),
    BUILD_PASTURE("build pasture"),
    BUILD_CAMP("build camp"),
    BUILD_PLANTATION("build plantation"),
    BUILD_QUARRY("build quarry"),
    REMOVE_JUNGLE("build jungle"),
    REMOVE_ROUTE("remove route"),
    REPAIR("repair"),
    SHOW_POSITION("show position \\d[,]\\d{2}"),
    SHOW_CITY_NAME("show city (?<name>\\S+)"),
    MOVE_RIGHT("move right (?<amount>\\d+)"),
    MOVE_LEFT("move left (?<amount>\\d+)"),
    MOVE_UP("move up (?<amount>\\d+)"),
    MOVE_DOWN("move down (?<amount>\\d+)");





    private String regex;
    Regexes(String regex) {
        this.regex = regex;
    }
    public static Matcher getCommand (String input, Regexes command) {
        Matcher matcher = Pattern.compile(command.regex).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
