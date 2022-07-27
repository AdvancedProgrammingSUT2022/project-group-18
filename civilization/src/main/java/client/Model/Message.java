package client.model;

public class Message {
    private int senderId;
    private String text;

    public int getSenderId() {
        return senderId;
    }

    public String getText() {
        return text;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public void setText(String text) {
        this.text = text;
    }
}

