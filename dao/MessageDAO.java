package dao;

import model.Message;
import java.sql.*;

public class MessageDAO {
    private final String URL = "jdbc:mysql://localhost:3306/chatdb";
    private final String USER = "root";
    private final String PASSWORD = "your_password";

    public void saveMessage(Message msg) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO messages (sender, content) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, msg.getSender());
            stmt.setString(2, msg.getContent());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
