
# Java Chat Application (Client-Server with GUI & MySQL Storage)

## 📌 Overview

This project is a basic client-server chat application in Java with a graphical user interface (GUI) and MySQL database integration. It allows users to send and receive messages in real time, and stores all chat messages in a database for persistence.

## 🧱 Project Structure

* **ChatServer.java**: Handles incoming client connections and message broadcasting to all connected clients.
* **ChatClient.java**: A client-side class that connects to the server and sends/receives messages via console.
* **ChatClientGUI.java**: A Swing-based GUI client that allows sending and receiving messages with a user-friendly interface.
* **Message.java**: A data model representing a message object (sender, content, timestamp).
* **MessageDAO.java**: Data Access Object (DAO) responsible for interacting with the MySQL database to store and retrieve messages.
* **db.sql**: SQL script to set up the `chatdb` database and `messages` table.

## 🛠️ Requirements

* Java 8 or higher
* MySQL Server
* JDBC Driver (Connector/J)
* An IDE like IntelliJ or Eclipse (optional)

## 🚀 Getting Started

### 1. Database Setup

* Start MySQL server.
* Run the `db.sql` script to create the database and table:

```sql
CREATE DATABASE chatdb;
USE chatdb;

CREATE TABLE messages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sender VARCHAR(50),
    content TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

* Update your DB credentials in `MessageDAO.java`:

```java
String url = "jdbc:mysql://localhost:3306/chatdb";
String user = "your_username";
String password = "your_password";
```

### 2. Compile and Run

1. **Start the Server**:

   ```bash
   javac ChatServer.java
   java ChatServer
   ```

2. **Run a Console Client**:

   ```bash
   javac ChatClient.java
   java ChatClient
   ```

3. **Run a GUI Client**:

   ```bash
   javac ChatClientGUI.java
   java ChatClientGUI
   ```

## 🧪 Features

* Real-time chat among multiple clients
* Console-based and GUI-based client options
* All messages stored in a MySQL database
* Timestamps for each message

## 📎 Notes

* Ensure the server is running before connecting clients.
* All clients must connect to the same host and port.
* The server broadcasts every incoming message to all clients.

## 🔒 License

This project is open-source and free to use for educational purposes.

