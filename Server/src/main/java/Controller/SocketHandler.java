package Controller;

import Model.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class SocketHandler extends Thread{
    private final Socket socket;
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;
    private User user;

    public SocketHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.inputStream = new DataInputStream(socket.getInputStream());
        this.outputStream = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                Request request = Request.fromJson(inputStream.readUTF());
                System.out.println("New request from " + socket);
                Response response = handleRequest(request);
                outputStream.writeUTF(response.toJson());
                outputStream.flush();
            }
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }

    private Response handleRequest(Request request) throws IOException {
        Response response = new Response();
        response.setStatus(200);
        switch (request.getHeader()) {
            case "register" -> {
                String nickname = (String) request.getData().get("nickname");
                this.user = Database.getInstance().newUserConnected(nickname);
                response.addData("id", user.getId());
                response.addData("message", "ok");
            }
            case "register_reader" -> {
                String nickname = (String) request.getData().get("nickname");
                User user = UserController.getUserByNickname(nickname);
                System.out.println("Registered update socket for " + nickname);
                user.setUpdateSocket(socket);
            }
            case "send" -> {
                int receiverId = (int)Math.floor((double)request.getData().get("chatId"));
                String text = (String) request.getData().get("text");
                ChatController.addMessage(text, receiverId, user.getId());
                response.addData("message", "ok");
            }
            case "get_messages" -> {
                int chatId = (int) Math.floor((double) request.getData().get("chatId"));
                ArrayList<Message> messages = ChatController.getMessagesOfChat(user.getId(), chatId);
                response.addData("messages", messages);
            }
            case "get_chats" -> {
                ArrayList<Chat> chats = ChatController.getChats();
                response.addData("chats", chats);
            }
            default -> {
                response.setStatus(400);
                response.addData("error", "invalid command");
            }
        }
        return response;
    }
}
