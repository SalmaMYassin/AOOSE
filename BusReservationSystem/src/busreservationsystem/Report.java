package busreservationsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Report extends UnicastRemoteObject implements ReportInterface{
    public static ArrayList<BusDriver> lowRatedDrivers = new ArrayList<BusDriver>();

    public Report() throws RemoteException{
    }
    
    /**********
    * Methods *
    **********/
    @Override
    public void AddDriverToLowRatedDrivers(int busDriverID) throws RemoteException{
    
    }
    
    @Override
    public void RateDriver(int busDriverID) throws RemoteException{
        
    }
    
    @Override
    public void ViewAllLowRatedDrivers() throws RemoteException{
    
    }
}
