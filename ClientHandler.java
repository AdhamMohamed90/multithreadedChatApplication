package codvedalevel3task1;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private String username;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            out.write("Enter your username:");
            out.newLine();
            out.flush();
            username = in.readLine();
            System.out.println(username + " joined the chat!");

            ChatServer.broadcast(username + " joined the chat!", this);

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                String fullMessage = username + ": " + message;
                System.out.println(fullMessage);
                ChatServer.broadcast(fullMessage, this);
            }
        } catch (IOException e) {
            System.out.println("Connection lost with " + username);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ChatServer.removeClient(this);
            if (username != null) {
                ChatServer.broadcast(username + " left the chat.", this);
                System.out.println(username + " left the chat.");
            }
        }
    }

    public void sendMessage(String message) throws IOException {
        out.write(message);
        out.newLine();
        out.flush();
    }
}
