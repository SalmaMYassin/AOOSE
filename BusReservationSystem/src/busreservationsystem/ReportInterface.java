package busreservationsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReportInterface extends Remote{
    /**********
    * Methods *
    **********/
    public void AddDriverToLowRatedDrivers(int busDriverID) throws RemoteException;
    
    public void RateDriver(int busDriverID) throws RemoteException;
    
    public void ViewAllLowRatedDrivers() throws RemoteException;
}
