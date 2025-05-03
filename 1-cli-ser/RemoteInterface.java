import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    int[] addNumbersAndSort(int[] newNumbers) throws RemoteException;
}