package Chatserver.Model;

import java.time.LocalDateTime;

public class Message {
    private int id;
    private int senderId;
    private int receiverId;
    private LocalDateTime sentAt;
    private String text;

    public int getSenderId() {
        return senderId;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public String getText() {
        return text;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }
}
