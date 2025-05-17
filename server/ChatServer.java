package server;

import dao.MessageDAO;
import model.Message;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 1234;
    private static Set<PrintWriter> clientWriters = Collections.synchronizedSet(new HashSet<>());
    private static MessageDAO messageDAO = new MessageDAO();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Chat server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket).start();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private String name;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                out = new PrintWriter(socket.getOutputStream(), true);
                clientWriters.add(out);
                out.println("Enter your name:");
                name = in.readLine();

                String message;
                while ((message = in.readLine()) != null) {
                    Message msgObj = new Message(name, message);
                    messageDAO.saveMessage(msgObj); // Save to DB
                    for (PrintWriter writer : clientWriters) {
                        writer.println(name + ": " + message);
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection error: " + e.getMessage());
            } finally {
                clientWriters.remove(out);
                try {
                    socket.close();
                } catch (IOException ignored) {}
            }
        }
    }
}
