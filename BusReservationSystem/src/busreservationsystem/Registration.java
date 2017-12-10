package busreservationsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Registration extends UnicastRemoteObject implements RegistrationInterface{

    public Registration() throws RemoteException {
        
    }
    
    
    @Override
    public boolean Register(String user, String pass, String rePass) throws RemoteException{
        ConnectToDB temp = new ConnectToDB();
        if(!temp.AccountChecker(user)){
            Account newAccount = new Account(user, pass);
            return true;
        }
        else{
            return false;
        }
    }
}
