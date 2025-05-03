# Experiment 1: Multi-threaded RMI Client/Server

Demonstrates array sorting using Java RMI, showcasing the server handling multiple clients concurrently via threads.

## Files

- `RemoteInterface.java`: Remote service contract.
- `RemoteImpl.java`: Server-side implementation (sorting logic).
- `RMIServer.java`: Starts the server and RMI registry.
- `RMIClient.java`: Client application to request sorting.

## Running the Experiment

1.  **Compile:**

    - Open a terminal in the project directory.
    - Run: `javac *.java`

2.  **Start Server:**

    - In the same terminal, run: `java RMIServer`
    - The server will print "Server is running...". Keep this terminal open.

3.  **Start Client(s):**

    - Open one or more **new terminals**. Navigate to the same project directory.
    - Run: `java RMIClient`
    - Follow the prompts (enter array size, 0 to exit).

4.  **Observe Multi-threading:**

    - Run multiple clients simultaneously.
    - Check the **RMIServer terminal output**. Different `Thread: ID` numbers for concurrent requests confirm multi-threading handled by RMI.

5.  **Stop:**
    - Enter `0` in client terminals to exit.
    - Press `Ctrl+C` in the RMIServer terminal to stop the server.
