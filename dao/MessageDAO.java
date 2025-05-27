package dao;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Message;

public class MessageDAO {
    private final String FILE_PATH = "messages.txt";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void saveMessage(Message msg) {
        String timestamp = LocalDateTime.now().format(formatter);
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("[" + timestamp + "] " + msg.getSender() + ": " + msg.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
