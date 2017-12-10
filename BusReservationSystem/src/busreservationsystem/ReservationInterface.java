package busreservationsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReservationInterface extends Remote{
    
    public void CancelTicket(Ticket t) throws RemoteException;
    
    public void Reserve(String seatNum, String busRoute, String client) throws RemoteException;
}
