package busreservationsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BusDriver extends UnicastRemoteObject implements BusDriverInterface{
    public static ArrayList<BusDriver> allDrivers = new ArrayList<BusDriver>();

    private int driverID;
    private int driverRatingCount;
    private float driverRateAvg;

    private String driverName;
    
    /***************
    * Constructors *
    ***************/
    public BusDriver() throws RemoteException {
        this.driverID = ConnectToDB.GetBusDriverID() + 1;
        this.driverRatingCount = 0;
        this.driverRateAvg = 5;
        this.driverName = "";
    }
    
    public BusDriver(String driverName) throws RemoteException {
        this.driverID = ConnectToDB.GetBusDriverID() + 1;
        this.driverName = driverName;
        this.driverRateAvg = 5;
        ConnectToDB.insertRecord(this, "BusDriver");
    }
    
    public BusDriver(int ID, String driverName, float driverAvg) throws RemoteException {
        this.driverID = ID;
        this.driverName = driverName;
        this.driverRateAvg = driverAvg;
    }
    
    /***********
    * Mutators *
    ***********/
    @Override
    public void setDriverID(int driverID)throws RemoteException {
        this.driverID = driverID;
    }

    @Override
    public void setDriverRatingCount(int driverRatingCount) throws RemoteException {
        this.driverRatingCount = driverRatingCount;
    }

    @Override
    public void setDriverRateAvg(float driverRateAvg) throws RemoteException {
        this.driverRateAvg = driverRateAvg;
    }

    @Override
    public void setDriverName(String driverName) throws RemoteException{
        this.driverName = driverName;
    }
    
    /************
    * Accessors *
    ************/
    @Override
    public int getDriverID() throws RemoteException{
        return driverID;
    }

    @Override
    public int getDriverRatingCount() throws RemoteException{
        return driverRatingCount;
    }

    @Override
    public float getDriverRateAvg()throws RemoteException {
        return driverRateAvg;
    }

    @Override
    public String getDriverName() throws RemoteException{
        return driverName;
    }
    
    
    /**********
    * Methods *
    **********/
    @Override
    public void AddDriver()throws RemoteException{
    
    }
    
    @Override
    public void RemoveDriver()throws RemoteException{
    
    }
    
    @Override
    public void UpdateDriverRating()throws RemoteException{
    
    }
    
    @Override
    public void ViewAllDrivers()throws RemoteException{
    
    }
}
