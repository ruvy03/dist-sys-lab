import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class RemoteImpl extends UnicastRemoteObject implements RemoteInterface {

    // Shared state: List to hold ALL numbers from ALL clients
    // Must be synchronized for thread safety!
    private final List<Integer> allNumbers = Collections.synchronizedList(new ArrayList<>());
    // Note: Using Collections.synchronizedList provides basic thread safety for
    // add/get operations.
    // For more complex operations (like iterating and modifying), explicit
    // synchronization might still be needed,
    // but for adding and then sorting a snapshot, this is often sufficient and
    // simpler.

    public RemoteImpl() throws RemoteException {
        super();
    }

    @Override
    public int[] addNumbersAndSort(int[] newNumbers) throws RemoteException {
        long threadId = Thread.currentThread().getId();
        System.out.println("Server Thread " + threadId + ": Received numbers: " + Arrays.toString(newNumbers));

        // Add the new numbers to the synchronized list
        if (newNumbers != null) {
            for (int number : newNumbers) {
                this.allNumbers.add(number);
            }
        }

        // Create a snapshot, sort it, and return it
        // Synchronize block ensures atomicity of getting the current list state and
        // preparing the result
        int[] sortedSnapshot;
        synchronized (allNumbers) { // Synchronize on the list object itself
            System.out
                    .println("Server Thread " + threadId + ": Current total numbers count: " + this.allNumbers.size());
            // Create a copy to sort and return (don't sort the shared list directly if
            // reads happen concurrently)
            List<Integer> currentListSnapshot = new ArrayList<>(this.allNumbers);
            Collections.sort(currentListSnapshot); // Sort the copy
            // Convert List<Integer> to int[]
            sortedSnapshot = currentListSnapshot.stream().mapToInt(Integer::intValue).toArray();
        } // End synchronized block

        System.out.println("Server Thread " + threadId + ": Returning sorted list: " + Arrays.toString(sortedSnapshot));
        return sortedSnapshot;
    }
}