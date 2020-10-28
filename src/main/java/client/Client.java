package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private String ip;
    private short port;

    public Client(String ip, short port) {
        this.ip = ip;
        this.port = port;
    }

    public void sendMessage(String fromName) {
        try (Socket clientSocket = new Socket(ip, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String question = in.readLine();
            System.out.println(question);
            if (question.equals("Write your name")) {
                out.println(fromName);
                question = in.readLine();
                System.out.println(question);
                if (question.equals("Are you child? (yes/no)")) {
                    out.println("yes");
                    String answer = in.readLine();
                    System.out.println(answer);
                    question = in.readLine();
                    System.out.println(question);
                    if (question.equals("Are you playing on PC? (yes/no)")) {
                        out.println("yes");
                        answer = in.readLine();
                        System.out.println(answer);
                    }
                }
            }
        } catch (IOException ioException) {
            System.out.println(ioException.toString());
        }
    }
}
