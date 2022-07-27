package Chatserver.Controller;



import Chatserver.Model.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class ChatController {
    public static void addMessage(String text, int receiverId, int senderId) throws IOException {
        Message message = new Message();
        message.setReceiverId(receiverId);
        message.setSenderId(senderId);
        message.setSentAt(LocalDateTime.now());
        message.setText(text);

        User receiver = Database.getInstance().getUserById(receiverId);
        receiver.getReceivedMessages().add(message);

        User sender = Database.getInstance().getUserById(senderId);
        sender.getSentMessages().add(message);

        Database.getInstance().getMessages().add(message);

        Response update = new Response();
        update.addData("message", message);
        update.addData("fromId", senderId);
        receiver.getUpdateOutputStream().writeUTF(update.toJson());
        receiver.getUpdateOutputStream().flush();
        System.out.println("update sent");
    }

    public static ArrayList<Message> getMessagesOfChat(int sourceId, int destId) {
        ArrayList<Message> messages = Database.getInstance().getMessages();
        ArrayList<Message> result = new ArrayList<>();
        for (Message message : messages) {
            if ((message.getSenderId() == destId && message.getReceiverId() == sourceId) || (message.getSenderId() == sourceId && message.getReceiverId() == destId)) {
                result.add(message);
            }
        }
        result.sort(Comparator.comparing(Message::getSentAt));
        return result;
    }

    public static ArrayList<Chat> getChats() {
        ArrayList<Chat> chats = new ArrayList<>();
        for (User user : Database.getInstance().getUsers()) {
            chats.add(new Chat(user.getId(), user.getNickname()));
        }
        return chats;
    }
}

