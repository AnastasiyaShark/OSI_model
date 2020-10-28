package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private String ip;
    private short port;

    public Client(String ip, short port) {
        this.ip = ip;
        this.port = port;
    }

    public void sendMessage(String s) {
        try (Socket clientSocket = new Socket(ip, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            out.println(s);
        } catch (IOException ioException) {
            System.out.println(ioException.toString());
        }
    }
}
