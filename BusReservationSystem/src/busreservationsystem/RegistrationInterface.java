package busreservationsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RegistrationInterface extends Remote{
    public boolean Register(String user, String pass, String rePass) throws RemoteException;
}
