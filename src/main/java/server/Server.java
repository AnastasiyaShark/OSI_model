package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private short port;

    public Server(short port) {
        this.port = port;
    }

    public short getPort() {
        return port;
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();


                try (
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {

                    out.println("Write your name");
                    String name = in.readLine();
                    System.out.println(name);
                    out.println("Are you child? (yes/no)");
                    String isChild = in.readLine();
                    System.out.println(isChild);
                    if (isChild.equals("yes")) {
                        out.printf("Welcome to the kids area, %s! Let's play!%n", name);
                    } else {
                        if (isChild.equals("no")) {
                            out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!%n", name);
                        } else {
                            out.println(" Wrong answer!");
                        }
                    }
                    out.println("Are you playing on PC? (yes/no)");
                    String onPC = in.readLine();
                    System.out.println(onPC);
                    if (onPC.equals("yes")) {
                        out.printf("Please, visit netology.ru%n");
                    } else {
                        if (onPC.equals("no")) {
                            out.println("Go play on PC");
                        } else {
                            out.println(" Wrong answer!");
                        }
                    }
                    clientSocket.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } catch (IOException ioException) {
            System.out.println(" Error " + ioException);
        }

    }
}
