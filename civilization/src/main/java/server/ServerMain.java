package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) {
        int SERVER_PORT = 7889;
        ServerController controller = new ServerController();

        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {

                        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                        while (true) {
                            String input = dataInputStream.readUTF();
                            String output = controller.getInput(input);
                            dataOutputStream.writeUTF(output);
                            dataOutputStream.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }).start();

            }
        } catch (IOException s) {
            s.printStackTrace();
        }


    }
}
