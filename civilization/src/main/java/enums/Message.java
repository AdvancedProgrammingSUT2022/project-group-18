package enums;

public enum Message {
    LOGINERROR("please login first"),
    INVALID("invalid command"),
    IVALIDENTERMENU("menu navigation is not possible"),
    MAINMENU("Main Menu"),
    LOGINMENU("Login Menu"),
    INVALID_MENU_NAME("menu name is invalid"),
    USER_CREAT("user create successfully!"),
    USER_EXIST_USERNAME_ONE("user with username "),
    USER_EXIST_USERNAME_TWO(" already exists"),
    USER_EXIST_NICKNAME_ONE("user with nickname "),
    LOGIN_USER("user logged in successfully!"),
    NOT_MATCH("Username and password didn't match!"),
    USER_NOT_EXIST("one of players username dose not exists!"),
    PLAY_GAME("finally welcome to the game!\n" +
            "We will recommend you that do not play this game " +
            "because this is the useless less less less game you ever saw:)"),
    USER_LOGOUT("user logged out successfully!"),
    CHANGE_NICKNAME("nickname changed successfully!"),
    CHANGE_PASSWORD("password changed successfully!"),
    PASS_INVALID("current password is invalid"),
    SAME_PASS("your new password shouldn't be the same with current pass"),
    CANT_CHANG_USERNAME("you can't chang your username!"),
    GAME_WITH_NO_PLAYER("you don't choose any player to play game!"),
    NO_NOTIFICATIONS("no notifications yet..."),
    MAKE_UNIT("the unit was made"),
    POSITION_INVALID(""),
    COMBAT_UNIT_DONT_EXIST(""),
    NONCOMBAT_UNIT_DONT_EXIST(""),
    UNIT_NOT_EXIST("no units exists with this name"),
    CITY_NOT_EXIST_WITH_NAME("no city exists with this name"),
    COMBAT_SUCCESSFUL("combat was successful!"),
    DESTROYED_CITY("you destroyed the city!"),
    KILL_UNIT("you killed a unit!"),
    STRENGTHS("strengths on until you don't move"),
    UNIT_CANT_STRENGTHS("strengths isn't for this kind of units!"),
    SLEEP("sleep mode was turned on"),
    ALERT("ready mode was turned on"),
    FORTIFY("unit defensive power increased"),
    FORTIFY_HEAL("unit health increased"),
    GARRISON("the unit is ready to defensive it's city"),
    SETUP_RANGED("the unit chose it's enemy"),
    ATTACK_POSITION("enter your command"),
    FOUND_CITY("the settler unit found a new city"),
    CANCEL_COMMAND("This mission canceled"),
    WAKE("This unit woke up"),
    DELETE("This unit was removed"),
    BUILD_ROAD("the road was built"),
    BUILD_RAILWAY("the railway was built"),
    BUILD_FARM("the farm was built"),
    BUILD_MINE("the mine was built"),
    BUILD_TRADING_POST("the trading post was built"),
    BUILD_LUMBER_MILL("the lumber mill was built"),
    BUILD_PASTURE("the pasture was built"),
    BUILD_CAMP("the camp was built"),
    BUILD_PLANTATION("the plantation was built"),
    BUILD_QUARRY("the quarry was built"),
    REMOVE_JUNGLE("the jungle was removed"),
    REMOVE_FOREST("the forest was removed"),
    REMOVE_MARSH("the marsh was removed"),
    REMOVE_ROAD("the road was removed"),
    REPAIR("the worker is repairing"),
    CITY_NOT_EXIST_IN_POSITION("");




    private String regex;

    Message (String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return this.regex;
    }

}
