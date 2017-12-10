package busreservationsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Account extends UnicastRemoteObject implements AccountInterface{    
    private int ssn;
    private int age;
    private boolean loggedIn;
    private String email;
    private String name;
    
    private String username;
    private String password;

    /***************
    * Constructors *
    ***************/
    public Account()throws RemoteException {
        this.ssn = 0;
        this.age = 0;
        this.loggedIn = false;
        this.email = "";
        this.name = "";
        this.username = "";
        this.password = "";
    }
    
    public Account(String Username, String Password) throws RemoteException{
        this.username = Username;
        this.password = Password;
        this.loggedIn = false;
        ConnectToDB.insertRecord(this, "Accounts");
    }
    
    /***********
    * Mutators *
    ***********/

    @Override
    public void setAge(int age) throws RemoteException{
        this.age = age;
    }

    @Override
    public void setLoggedIn(boolean loggedIn)throws RemoteException{
        this.loggedIn = loggedIn;
    }

    @Override
    public void setEmail(String email)throws RemoteException {
        this.email = email;
    }

    @Override
    public void setName(String name)throws RemoteException {
        this.name = name;
    }

    @Override
    public void setUsername(String username)throws RemoteException {
        this.username = username;
    }

    @Override
    public void setPassword(String password) throws RemoteException{
        this.password = password;
    }
    
    /************
    * Accessors *
    ************/
    @Override
    public int getSsn()throws RemoteException {
        return ssn;
    }

    @Override
    public int getAge()throws RemoteException {
        return age;
    }

    @Override
    public boolean isLoggedIn() throws RemoteException{
        return loggedIn;
    }

    @Override
    public String getEmail() throws RemoteException{
        return email;
    }

    @Override
    public String getName() throws RemoteException{
        return name;
    }

    @Override
    public String getUsername() throws RemoteException{
        return username;
    }

    @Override
    public String getPassword()throws RemoteException {
        return password;
    }
    
    /**********
    * Methods *
    **********/
    @Override
    public boolean Login(String user, String pass)throws RemoteException{
        
        if(ConnectToDB.PasswordChecker(user, pass)){
            ConnectToDB.updateLoggedIn(user, "true");
            return true;
        }
        return false;
    }
    
    @Override
    public void Logout(String username)throws RemoteException{
        ConnectToDB.updateLoggedIn(username, "false");
    }
}