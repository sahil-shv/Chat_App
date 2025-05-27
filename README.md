**Java Chat Application (Client-Server with GUI & Text File Storage)**

📌 Overview
This project is a basic client-server chat application in Java with a graphical user interface (GUI). It allows users to send and receive messages in real time, and stores all chat messages in a local file (messages.txt) for persistence.

🧱 Project Structure
ChatServer.java: Handles incoming client connections and message broadcasting to all connected clients.
ChatClient.java: A client-side class that connects to the server and sends/receives messages via console.
ChatClientGUI.java: A Swing-based GUI client that allows sending and receiving messages with a user-friendly interface.
Message.java: A data model representing a message object (sender, content).
MessageDAO.java: Data Access Object (DAO) responsible for saving messages to a local file (messages.txt).
🛠️ Requirements
Java 8 or higher
An IDE like IntelliJ, Eclipse, or VS Code (optional)
🚀 Getting Started
Compile and Run

Start the Server:
  javac server/ChatServer.java
  java server.ChatServer

Run a Console Client:
  javac client/ChatClient.java
  java client.ChatClient

Run a GUI Client:
  javac client/ChatClientGUI.java
  java client.ChatClientGUI

🧪 Features
Real-time chat among multiple clients
Console-based and GUI-based client options
All messages stored in a local file with timestamps
Timestamps for each message
📎 Notes
Ensure the server is running before connecting clients.
All clients must connect to the same host and port.
The server broadcasts every incoming message to all clients.

