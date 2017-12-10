package busreservationsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TicketInterface extends Remote{
     /************
    * Accessors *
    ************/
    public Route getBookedRoute() throws RemoteException;

    public int getSeatNumber() throws RemoteException;
    
    public int getTicketID() throws RemoteException;
    
    /**********
    * Methods *
    **********/
    public void MakeTicket() throws RemoteException;
}
