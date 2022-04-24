package enums;

public enum Message {
        INVALID("invalid command"),
        IVALIDENTERMENU("menu navigation is not possible");

    private String regex;

    Message (String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return this.regex;
    }

}
