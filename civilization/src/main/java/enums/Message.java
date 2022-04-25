package enums;

public enum Message {
        LOGINERROR("please login first"),
        INVALID("invalid command"),
        IVALIDENTERMENU("menu navigation is not possible"),
        MAINMENU("Main Menu"),
        LOGINMENU("Login Menu"),
        USERCREAT("user create successfully!"),
        USER_EXIST_USERNAME_ONE("user with username "),
        USER_EXIST_USERNAME_TWO(" already exists"),
        USER_EXIST_NICKNAME_ONE("user with nickname "),
        LOGIN_USER("user logged in successfully!"),
        NOT_MATCH("Username and password didn't match!"),

        USER_LOGOUT("user logged out successfully!");


    private String regex;

    Message (String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return this.regex;
    }

}
