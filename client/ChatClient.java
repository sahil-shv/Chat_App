package client;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Read from server
        Thread readerThread = new Thread(() -> {
            try {
                String msg;
                while ((msg = input.readLine()) != null) {
                    System.out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        readerThread.start();

        // Send to server
        String userMessage;
        // Prompt for name
        System.out.print(input.readLine() + " ");
        String name = userInput.readLine();
        out.println(name);
        while ((userMessage = userInput.readLine()) != null) {
            out.println(userMessage);
        }
    }
}
