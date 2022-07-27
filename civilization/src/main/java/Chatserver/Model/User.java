package Chatserver.Model;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class User {
    private int id;
    private String nickname;
    private Socket updateSocket;
    private DataOutputStream updateOutputStream;
    private ArrayList<Message> sentMessages = new ArrayList<>();
    private ArrayList<Message> receivedMessages = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ArrayList<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(ArrayList<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public ArrayList<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(ArrayList<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public Socket getUpdateSocket() {
        return updateSocket;
    }

    public void setUpdateSocket(Socket updateSocket) throws IOException {
        this.updateSocket = updateSocket;
        this.updateOutputStream = new DataOutputStream(updateSocket.getOutputStream());
    }

    public DataOutputStream getUpdateOutputStream() {
        return updateOutputStream;
    }
}

