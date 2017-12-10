package busreservationsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Admin extends UnicastRemoteObject implements AdminInterface{
   private static Admin adminInstance;
   private static Account adminAccount;
   
   /***************
   * Constructors *
   ***************/
   private Admin()throws RemoteException{         //singleton
   }
   
   public static Admin getAdminInstance() throws RemoteException{
        if(adminInstance == null){
           adminInstance = new Admin();
        }
        return adminInstance;
   }
   
   /**********
   * Methods *
   **********/
   @Override
   public void AddBus(Bus bus)throws RemoteException{
   
   }
   
   @Override
   public void AddBusDriver(BusDriver busDriver)throws RemoteException{
   
   }
   
   @Override
   public void AddBusRoute(Route busRoute) throws RemoteException{
   
   }
   
   @Override
   public void ViewAllReservationHistory() throws RemoteException{
   
   }
}