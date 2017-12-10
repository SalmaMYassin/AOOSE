package busreservationsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Ticket extends UnicastRemoteObject implements TicketInterface{
    private int ticketID;
    public static int counterticketID = 0;
    private Route bookedRoute;
    private int seatNumber;
    
    /***************
    * Constructors *
    ***************/
    public Ticket(Route bookedRoute, int seatNumber) throws RemoteException{
        this.bookedRoute = bookedRoute;
        this.seatNumber = seatNumber;
        this.ticketID = counterticketID + 1;
    }
    
    /************
    * Accessors *
    ************/
    @Override
    public Route getBookedRoute() throws RemoteException {
        return bookedRoute;
    }

    @Override
    public int getSeatNumber() throws RemoteException {
        return seatNumber;
    }
    
    @Override
    public int getTicketID() throws RemoteException{
        return ticketID;
    }
    
    /**********
    * Methods *
    **********/
    @Override
    public void MakeTicket() throws RemoteException{
    
    }
}
