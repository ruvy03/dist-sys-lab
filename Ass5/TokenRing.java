import java.util.*;
import java.util.concurrent.TimeUnit;

class TokenRing {
    public static void main(String args[]) throws Throwable {
        Scanner scan = new Scanner(System.in);

        // Get and print all nodes
        System.out.println("Enter the number of nodes:");
        int nodes = scan.nextInt();

        System.out.print("Nodes: ");
        for (int i = 0; i < nodes; i++) {
            System.out.print(i + " ");
        }
        System.out.println("0");  // to show ring structure

        // Get sender, receiver, and data, and initialize token to node 0
        int token = 0;
        int sender, receiver;

        System.out.println("Enter sender node:");
        sender = scan.nextInt();
        System.out.println("Enter receiver node:");
        receiver = scan.nextInt();

        // Input validation
        if (sender >= nodes || receiver >= nodes || sender < 0 || receiver < 0) {
            System.out.println("Invalid sender or receiver node.");
            scan.close();
            return;
        }
        if (sender == receiver) {
            System.out.println("Sender and receiver cannot be the same.");
            scan.close();
            return;
        }

        scan.nextLine(); // clear newline
        System.out.println("Enter Data (String or Numeric):");
        String data = scan.nextLine();  // Allows full line input

        // Keep passing the token until sender is found
        System.out.print("Token passing: ");
        for (int i = token; (i % nodes) != sender; i++) {
            System.out.print(i % nodes + " -> ");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(sender);  // Token reaches sender

        // Now passing data
        System.out.println("-------------------- TOKEN WITH SENDER NOW PASSING DATA -------------------");
        System.out.println("Sender " + sender + " sending data: " + data);

        // Passing the data to the receiver
        int i = (sender + 1) % nodes;
        while (i != (receiver + 1) % nodes) {
            System.out.print("data " + i + " -> ");
            TimeUnit.SECONDS.sleep(1);
            i = (i + 1) % nodes;
        }

        System.out.println();
        System.out.println("------------------- Receiver " + receiver + " received data: " + data + " ----------------------");

        // Final token position
        token = sender;

        scan.close();
    }
}

