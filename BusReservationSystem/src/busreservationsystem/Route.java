package busreservationsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Route extends UnicastRemoteObject implements RouteInterface{
    public static ArrayList<Route> allRoutes = new ArrayList<Route>();
    private ArrayList<Bus> buses = new ArrayList<>();
    
    private int routeID;    
    private String routeName;
    private String departingFrom;
    private String arrivingTo;

    /***************
    * Constructors *
    ***************/
    public Route() throws RemoteException{
    
    }

    public Route(int busID, String routeName, String departingFrom, String arrivingTo) throws RemoteException {
        this.routeID = ConnectToDB.GetRouteID() + 1;
        this.routeName = routeName;
        this.departingFrom = departingFrom;
        this.arrivingTo = arrivingTo;
        
        buses.add(ConnectToDB.GetBus(busID));
        
        Bus temp = new Bus();
        for(int i = 1; i < 4; i++)
            this.buses.add(temp);
        
        ConnectToDB.insertRecord(this, "Route");
    }
    
    public Route(ArrayList<Bus> b, String routeName, String departingFrom, String arrivingTo) throws RemoteException{
        try {
            this.routeID = ConnectToDB.GetRouteID() + 1;
        } catch (RemoteException ex) {
            Logger.getLogger(Route.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.routeName = routeName;
        this.departingFrom = departingFrom;
        this.arrivingTo = arrivingTo;
        buses = b;
        
    }
    
    /***********
    * Mutators *
    ***********/
    @Override
    public void setRouteID(int routeID) throws RemoteException {
        this.routeID = routeID;
    }

    @Override
    public void setBuses(ArrayList<Bus> buses) throws RemoteException {
        this.buses = buses;
    }

    @Override
    public void setRouteName(String routeName) throws RemoteException {
        this.routeName = routeName;
    }

    @Override
    public void setDepartingFrom(String departingFrom) throws RemoteException {
        this.departingFrom = departingFrom;
    }
    
    @Override
    public void setArrivingTo(String arrivingTo) throws RemoteException {
        this.arrivingTo = arrivingTo;
    }
    
    /************
    * Accessors *
    ************/
    @Override
    public int getRouteID() throws RemoteException {
        return routeID;
    }
    
    @Override
    public ArrayList<Bus> getBuses() throws RemoteException {
        return buses;
    }
    
    @Override
    public String getBusesID()  throws RemoteException{
        String temp = new String();
        
        for(int i = 0; i < buses.size(); i++){
            temp += buses.get(i).getBusID() + "/";
        }
        
        return temp;
    }

    @Override
    public String getRouteName() throws RemoteException {
        return routeName;
    }

    @Override
    public String getDepartingFrom() throws RemoteException{
        return departingFrom;
    }

    @Override
    public String getArrivingTo()  throws RemoteException{
        return arrivingTo;
    }
    
    /***********
    * Methods *
    **********/
    @Override
    public void DisplayRoutes() throws RemoteException{
        
    }
    
    @Override
    public void AddRoute() throws RemoteException{
    
    }
    
    
    @Override
    public void EditRoute() throws RemoteException{
    
    }
    
    @Override
    public void RemoveRoute() throws RemoteException{
    
    }
}
