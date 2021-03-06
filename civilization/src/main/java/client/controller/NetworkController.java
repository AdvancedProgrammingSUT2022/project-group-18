package client.controller;

import client.model.Message;
import client.model.Request;
import client.model.Response;
import client.view.Database;
import com.google.gson.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkController {

    private static Socket socket;
    private static Socket readerSocket;
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;

    public static boolean connect() {
        try {
            socket = new Socket("localhost", 8080);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ignored) {
            ignored.printStackTrace();
            return false;
        }
        return true;
    }

    public static void listenForUpdates() throws IOException {
        readerSocket = new Socket("localhost", 8000);
        DataOutputStream outputStream = new DataOutputStream(readerSocket.getOutputStream());
        DataInputStream inputStream = new DataInputStream(readerSocket.getInputStream());
        Request request = new Request();
        request.setHeader("register_reader");
        request.addData("nickname", Database.getInstance().getNickname());
        outputStream.writeUTF(request.toJson());
        outputStream.flush();
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Waiting for update");
                    Response response = Response.fromJson(inputStream.readUTF());
                    System.out.println("update received");
                    handleUpdate(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void handleUpdate(Response response) {
        String messageJson = new Gson().toJson(response.getData().get("message"));
        Message message = new Gson().fromJson(messageJson, Message.class);
        int fromId = (int) Math.floor((Double) response.getData().get("fromId"));
        ChatController.addMessageToChat(fromId, message);
    }

    public static Response send(Request request) {
        try {
            outputStream.writeUTF(request.toJson());
            outputStream.flush();
            return Response.fromJson(inputStream.readUTF());
        } catch (IOException ignored) {

        }
        return null;
    }
}

