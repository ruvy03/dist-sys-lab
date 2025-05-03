import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RMIClient {

    public static void main(String[] args) {
        String host = (args.length < 1) ? "localhost" : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host, 1099);
            RemoteInterface remote = (RemoteInterface) registry.lookup("RemoteService");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Client connected to RMI server on " + host);

            while (true) {
                int count = -1;
                while (count < 0) { // Allow sending 0 numbers to just get the current list
                    System.out.print("\nHow many numbers to send? (Enter 0 to exit, or >= 1): ");
                    try {
                        count = scanner.nextInt();
                        if (count < 0)
                            System.out.println("Please enter 0 or a positive number.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                        scanner.next(); // Consume invalid input
                    }
                }

                if (count == 0) {
                    break; // Exit main loop
                }

                // Get numbers from user
                int[] numbersToSend = new int[count];
                System.out.println("Enter " + count + " integer(s):");
                for (int i = 0; i < count; i++) {
                    while (true) { // Loop until valid integer is entered
                        System.out.print("Number " + (i + 1) + ": ");
                        try {
                            numbersToSend[i] = scanner.nextInt();
                            break; // Exit inner loop
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an integer.");
                            scanner.next(); // Consume invalid input
                        }
                    }
                }
                scanner.nextLine(); // Consume leftover newline

                System.out.println("Sending numbers: " + Arrays.toString(numbersToSend));

                // --- RMI Call ---
                int[] combinedSortedList = remote.addNumbersAndSort(numbersToSend);
                // --- End RMI Call ---

                System.out.println("Server returned combined sorted list: " + Arrays.toString(combinedSortedList));

            } // End of while loop

            scanner.close();
            System.out.println("Client exiting.");

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}