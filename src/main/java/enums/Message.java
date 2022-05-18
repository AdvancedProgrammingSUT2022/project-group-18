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
