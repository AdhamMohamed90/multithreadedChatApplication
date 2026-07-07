package codvedalevel3task1;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {
    private static final int PORT = 5555;
    private static CopyOnWriteArrayList<ClientHandler> clientHandlers = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Chat Server Started ===");
        System.out.println("Listening on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                ClientHandler handler = new ClientHandler(clientSocket);
                clientHandlers.add(handler);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    public static void broadcast(String message, ClientHandler sender) {
         
            for (ClientHandler client : clientHandlers) {
                if (client != sender) {
                    try {
                        client.sendMessage(message);
                    } catch (IOException ex) {
                        ex.printStackTrace();                  }
                }
            }
        
    }

    public static void removeClient(ClientHandler client) {
        clientHandlers.remove(client);
    }
}
