package busreservationsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountInterface extends Remote{
    
    /***********
    * Mutators *
    ***********/

    public void setAge(int age) throws RemoteException;

    public void setLoggedIn(boolean loggedIn) throws RemoteException;

    public void setEmail(String email) throws RemoteException;

    public void setName(String name) throws RemoteException;

    public void setUsername(String username) throws RemoteException;

    public void setPassword(String password) throws RemoteException;
    
    /************
    * Accessors *
    ************/
    public int getSsn() throws RemoteException;

    public int getAge() throws RemoteException;

    public boolean isLoggedIn() throws RemoteException;

    public String getEmail() throws RemoteException;

    public String getName() throws RemoteException;

    public String getUsername() throws RemoteException;

    public String getPassword() throws RemoteException;
    
    /**********
    * Methods *
    **********/
    public boolean Login(String user, String pass) throws RemoteException;
    
    public void Logout(String username) throws RemoteException;
}
