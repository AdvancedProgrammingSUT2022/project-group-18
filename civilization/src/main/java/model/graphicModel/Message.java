package model.graphicModel;

public class Message {
    private String senderName;
    private String receiverName;
    private Integer sendTime;
    private String text;
    private String profileAddress;
    private Boolean isSend;
    private Boolean isReceived;



    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public void setSendTime(Integer sendTime) {
        this.sendTime = sendTime;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setProfileAddress(String profileAddress) {
        this.profileAddress = profileAddress;
    }

    public void setSend(Boolean send) {
        isSend = send;
    }

    public void setReceived(Boolean received) {
        isReceived = received;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public Integer getSendTime() {
        return sendTime;
    }

    public String getText() {
        return text;
    }

    public String getProfileAddress() {
        return profileAddress;
    }

    public Boolean getSend() {
        return isSend;
    }

    public Boolean getReceived() {
        return isReceived;
    }
}
