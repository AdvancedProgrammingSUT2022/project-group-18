package messages;

public enum Message {
        INVALID("it is invalid");

    private String regex;

    Message (String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return this.regex;
    }

}
