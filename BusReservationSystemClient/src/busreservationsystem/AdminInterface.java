package busreservationsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdminInterface extends Remote{
    /**********
   * Methods *
   **********/
   public void AddBus(Bus bus)throws RemoteException;
   
   public void AddBusDriver(BusDriver busDriver)throws RemoteException;
   
   public void AddBusRoute(Route busRoute)throws RemoteException;
   
   public void ViewAllReservationHistory()throws RemoteException;
}
