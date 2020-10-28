package client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("netology.homework", (short) 10658);
        client.sendMessage("Viacheslav");
    }
}
