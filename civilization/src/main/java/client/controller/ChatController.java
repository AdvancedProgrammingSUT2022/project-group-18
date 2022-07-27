package client.controller;

import client.Model.Chat;
import client.Model.Message;
import client.view.ChatPage;
import client.view.Database;
import javafx.application.Platform;

import java.util.ArrayList;

public class ChatController {
    public static ArrayList<Message> getMessagesOfChat(int chatId) {
        ArrayList<Chat> chats = Database.getInstance().getChats();
        for (Chat chat : chats) {
            if (chat.getId() == chatId) {
                return chat.getMessages();
            }
        }
        return new ArrayList<>();
    }

    public static void addMessageToChat(int chatId, Message message) {
        ArrayList<Chat> chats = Database.getInstance().getChats();
        for (Chat chat : chats) {
            if (chat.getId() == chatId) {
                chat.addMessage(message);
                Platform.runLater(() -> ((ChatPage)SceneController.getController()).showMessages());
            }
        }
    }

    public static void setMessagesOfChat(int chatId, ArrayList<Message> messages) {
        ArrayList<Chat> chats = Database.getInstance().getChats();
        for (Chat chat : chats) {
            if (chat.getId() == chatId) {
                chat.setMessages(messages);
            }
        }
    }

    public static void addNewMessage(String text, int chatId) {
        Message message = new Message();
        message.setText(text);
        message.setSenderId(Database.getInstance().getUserId());
        for (Chat chat : Database.getInstance().getChats()) {
            if (chat.getId() == chatId) {
                chat.addMessage(message);
            }
        }
    }
}

