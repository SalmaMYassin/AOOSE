package busreservationsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BusDriverInterface extends Remote{
    /***********
    * Mutators *
    ***********/
    public void setDriverID(int driverID) throws RemoteException;

    public void setDriverRatingCount(int driverRatingCount) throws RemoteException;

    public void setDriverRateAvg(float driverRateAvg) throws RemoteException;

    public void setDriverName(String driverName) throws RemoteException;
    
    /************
    * Accessors *
    ************/
    public int getDriverID() throws RemoteException;

    public int getDriverRatingCount() throws RemoteException;

    public float getDriverRateAvg() throws RemoteException;

    public String getDriverName() throws RemoteException;
    
    
    /**********
    * Methods *
    **********/
    public void AddDriver() throws RemoteException;
    
    public void RemoveDriver() throws RemoteException;
    
    public void UpdateDriverRating() throws RemoteException;
    
    public void ViewAllDrivers() throws RemoteException;
}
