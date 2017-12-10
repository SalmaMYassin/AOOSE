package busreservationsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RouteInterface extends Remote{
    /***********
    * Mutators *
    ***********/
    public void setRouteID(int routeID) throws RemoteException;

    public void setBuses(ArrayList<Bus> buses) throws RemoteException;

    public void setRouteName(String routeName) throws RemoteException;

    public void setDepartingFrom(String departingFrom) throws RemoteException;
    
    public void setArrivingTo(String arrivingTo) throws RemoteException;
    
    /************
    * Accessors *
    ************/
    public int getRouteID() throws RemoteException;
    
    public ArrayList<Bus> getBuses() throws RemoteException;
    
    public String getBusesID() throws RemoteException;

    public String getRouteName() throws RemoteException;

    public String getDepartingFrom() throws RemoteException;

    public String getArrivingTo() throws RemoteException;
    
    /***********
    * Methods *
    **********/
    public void DisplayRoutes() throws RemoteException;
    
    public void AddRoute() throws RemoteException;
    
    public void EditRoute()throws RemoteException;
    
    public void RemoveRoute() throws RemoteException;
}
