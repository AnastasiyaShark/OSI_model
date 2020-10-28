package server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server((short) 10658);
        server.start();
    }
}
