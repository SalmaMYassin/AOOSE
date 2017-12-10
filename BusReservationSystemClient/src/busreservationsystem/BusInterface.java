package busreservationsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface BusInterface extends Remote{
    /***********
    * Mutators *
     * @param busDriver
    ***********/
    public void setBusDriver(BusDriver busDriver) throws RemoteException;

    public void setBusID(int busID) throws RemoteException;

    public void setSeatUnavailable(int seatNumber,boolean Availability) throws RemoteException;
    
    /************
    * Accessors *
     * @throws java.rmi.RemoteException
    ************/
    
    public ArrayList<Boolean> getSeatUnavailable() throws RemoteException;

    public BusDriver getBusDriver() throws RemoteException;

    public int getBusID() throws RemoteException;
    
    /**********
    * Methods *
    **********/
    public void BookSeat() throws RemoteException;
    
    public void UnbookSeat() throws RemoteException;
    
    public void ViewAllBuses() throws RemoteException;
    
    public void ViewSeats() throws RemoteException;
}
