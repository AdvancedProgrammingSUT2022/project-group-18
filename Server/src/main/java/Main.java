import Controller.SocketHandler;
import Model.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Listening on port 8080");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection made");
            SocketHandler handler = new SocketHandler(socket);
            handler.start();
        }
    }
}
