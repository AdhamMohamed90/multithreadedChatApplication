# Java Chat Application

A real-time multi-client chat system built in Java using **Socket Programming** and **Multithreading**. This application allows multiple users to connect to a server, communicate instantly, and receive notifications when users join or leave the chat.

---

## 🚀 Features

* ✅ Multi-client support (multiple users can connect simultaneously)
* ✅ Real-time messaging between connected clients
* ✅ Username system (users choose a username upon joining)
* ✅ Broadcast messaging to all connected clients
* ✅ Join/leave notifications
* ✅ Thread-safe client management using `CopyOnWriteArrayList`
* ✅ Object-Oriented Design (OOP)
* ✅ Lightweight and console-based implementation

---

## 🛠️ Technologies Used

* Java
* Socket Programming
* Multithreading
* Object-Oriented Programming (OOP)

---

## 📂 Project Structure

```text
Java Chat Application/
│
├── ChatServer.java      # Handles incoming client connections and broadcasts messages
├── ChatClient.java      # Connects to the server and sends/receives messages
└── ClientHandler.java   # Manages individual client communication on the server side
```

### File Descriptions

#### ChatServer.java

The main server application that:

* Listens for incoming client connections
* Maintains the list of connected clients
* Broadcasts messages to all users
* Handles user join and leave events

#### ChatClient.java

The client application that:

* Connects to the chat server
* Sends messages to other users
* Receives incoming messages in real time
* Allows users to disconnect using the `exit` command

#### ClientHandler.java

A dedicated thread for each connected client that:

* Handles communication between the server and a specific client
* Processes incoming messages
* Notifies other users when a client joins or leaves

---

## ⚙️ How It Works

1. The server starts and listens for incoming client connections.
2. Each client connects to the server and enters a username.
3. A dedicated thread (`ClientHandler`) is created for every connected client.
4. Messages sent by a client are broadcast to all connected users.
5. Users receive notifications when someone joins or leaves the chat.
6. Typing `exit` disconnects the client from the server.

---

## ▶️ How to Run

### 1. Compile the Project

```bash
javac codvedalevel3task1/*.java
```

### 2. Start the Server

Open a terminal and run:

```bash
java codvedalevel3task1.ChatServer
```

### 3. Start One or More Clients

Open separate terminals and run:

```bash
java codvedalevel3task1.ChatClient
```

### 4. Enter a Username

When prompted, enter a username and start chatting.

### 5. Disconnect

Type:

```text
exit
```

to leave the chat and disconnect from the server.

---

## 📸 Example Workflow

```text
Server started...

User1 joined the chat.
User2 joined the chat.

[User1]: Hello everyone!
[User2]: Hi User1!

User2 left the chat.
```

---

## 🔒 Thread Safety

The project uses Java's `CopyOnWriteArrayList` to safely manage connected clients in a concurrent environment, preventing issues when multiple threads access the client list simultaneously.

---

## 🎯 Learning Objectives

This project demonstrates:

* TCP Socket Communication
* Client-Server Architecture
* Java Multithreading
* Concurrent Collections
* Real-Time Messaging Systems
* Object-Oriented Programming Principles
