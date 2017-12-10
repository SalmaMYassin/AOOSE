package busreservationsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Client  extends UnicastRemoteObject implements CliientInterface{
    public static ArrayList<Client> allClients = new ArrayList<Client>();
    private ArrayList<Ticket> reservationHistory = new ArrayList<Ticket>();
    
    private Account clientAccount;
    private Ticket currentReservation;

    
    
    /***************
    * Constructors *
    ***************/
    public Client() throws RemoteException{
        this.clientAccount = null;
        this.currentReservation = null;
    }
    
    public Client(Account clientAccount, Ticket currentReservation) throws RemoteException{
        this.clientAccount = clientAccount;
        this.currentReservation = currentReservation;
    }

    /***********
    * Mutators *
    ***********/
    @Override
    public void setClientAccount(Account clientAccount) throws RemoteException{
        this.clientAccount = clientAccount;
    }

    @Override
    public void setCurrentReservation(Ticket currentReservation) throws RemoteException{
        this.currentReservation = currentReservation;
    }
    @Override
    public void setReservationHistory(ArrayList<Ticket> Ticket) throws RemoteException{
        this.reservationHistory = Ticket;
    }
    
    /************
    * Accessors *
    ************/
    @Override
    public Account getClientAccount() throws RemoteException{
        return clientAccount;
    }

    @Override
    public Ticket getCurrentReservation() throws RemoteException{
        return currentReservation;
    }
    @Override
    public ArrayList<Ticket> getReservationHistory() throws RemoteException{
        return reservationHistory;
    }
    
    /**********
    * Methods *
    **********/
    @Override
    public void ViewAllClients() throws RemoteException{
    
    }
    
    @Override
    public void ViewDriverProfiles() throws RemoteException{
    
    }
    
    @Override
    public void viewProfile() throws RemoteException{
    
    }
    
    @Override
    public void ViewReservationHistory() throws RemoteException{
    
    }
}
