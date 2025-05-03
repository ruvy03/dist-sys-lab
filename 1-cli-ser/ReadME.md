# Experiment 1: Multi-threaded RMI Client/Server (Shared List)

Demonstrates multiple clients using Java RMI to send integers to a server. The server maintains a single, shared list containing all numbers from all clients, returning the combined sorted list after each addition.

## Files

- `RemoteInterface.java`: Remote service contract (`addNumbersAndSort`).
- `RemoteImpl.java`: Server-side implementation (manages the shared list).
- `RMIServer.java`: Starts the server and RMI registry.
- `RMIClient.java`: Client application to send numbers.

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
    - Follow the prompts: Enter how many numbers to send, then enter the numbers themselves (0 count to exit).

4.  **Observe Shared State & Multi-threading:**

    - As different clients send numbers, notice how the "Server returned combined sorted list" on each client grows, containing numbers submitted by _all_ clients.
    - Check the **RMIServer terminal output**. Different `Thread: ID` numbers show RMI handling clients concurrently, all accessing the shared list.

5.  **Stop:**
    - Enter `0` for the count in client terminals to exit.
    - Press `Ctrl+C` in the RMIServer terminal to stop the server.
