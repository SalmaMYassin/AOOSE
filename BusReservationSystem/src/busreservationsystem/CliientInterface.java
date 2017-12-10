package busreservationsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CliientInterface extends Remote{
    /***********
    * Mutators *
    ***********/
    public void setClientAccount(Account clientAccount) throws RemoteException;

    public void setCurrentReservation(Ticket currentReservation) throws RemoteException;
    
    public void setReservationHistory(ArrayList<Ticket> Ticket)throws RemoteException;
    
    /************
    * Accessors *
    ************/
    public Account getClientAccount() throws RemoteException;

    public Ticket getCurrentReservation() throws RemoteException;
    
    public ArrayList<Ticket> getReservationHistory() throws RemoteException;
    
    /**********
    * Methods *
    **********/
    public void ViewAllClients() throws RemoteException;
    
    public void ViewDriverProfiles() throws RemoteException;
    
    public void viewProfile() throws RemoteException;
    
    public void ViewReservationHistory() throws RemoteException;
}
