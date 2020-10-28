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

    public void start (){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true){
                Socket clientSocket = serverSocket.accept();
                //PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    String s;
                    while ((s = in.readLine()) != null) {
                        System.out.printf("Msg: %s, Port: %d%n", s, clientSocket.getPort());
                    }
                    clientSocket.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } catch (IOException ioException){
            System.out.println(" Error " + ioException );
        }

    }
}
