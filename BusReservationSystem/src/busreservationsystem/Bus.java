package busreservationsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Bus extends UnicastRemoteObject implements BusInterface{
    public static ArrayList<Bus> allBuses = new ArrayList<Bus>();
    //private HashMap<Integer,Boolean> seats = new HashMap<Integer,Boolean>();
    private ArrayList<Integer> seatNumber = new ArrayList<Integer>();
    private ArrayList<Boolean> seatUnavailable = new ArrayList<Boolean>();
    private BusDriver busDriver;
    private int busID;
    
    /***************
    * Constructors *
    ***************/
    public Bus()throws RemoteException{}
    
    public Bus(BusDriver busDriver, int busID)throws RemoteException {
        this.busDriver = busDriver;
        this.busID = busID;
        for(int i = 0; i < 25; i++){
            this.seatNumber.add(i+1);
            this.seatUnavailable.add(true);
        }
    }
    
    /***********
    * Mutators *
    ***********/
    @Override
    public void setBusDriver(BusDriver busDriver)throws RemoteException {
        this.busDriver = busDriver;
    }

    @Override
    public void setBusID(int busID)throws RemoteException {
        this.busID = busID;
    }

    @Override
    public void setSeatUnavailable(int seatNumber,boolean Availability) throws RemoteException{
        this.seatUnavailable.set(seatNumber, Availability);
    }
    
    /************
    * Accessors *
    ************/
    
    @Override
    public ArrayList<Boolean> getSeatUnavailable() throws RemoteException{
        return seatUnavailable;
    }

    @Override
    public BusDriver getBusDriver() throws RemoteException{
        return busDriver;
    }

    @Override
    public int getBusID()throws RemoteException {
        return busID;
    }
    
    /**********
    * Methods *
    **********/
    @Override
    public void BookSeat()throws RemoteException{
    
    }
    
    @Override
    public void UnbookSeat()throws RemoteException{
    
    }
    
    @Override
    public void ViewAllBuses()throws RemoteException{
    
    }
    
    @Override
    public void ViewSeats()throws RemoteException{
    
    }
}