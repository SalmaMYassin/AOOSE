package busreservationsystem;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class BusReservationSystemServer {
    public static void main(String[] args) {
        try {
            // My remote object [Skeleton]
            AccountInterface a = new Account();
            RegistrationInterface ri = new Registration();
            // My RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);
            
            //Add my object to the RMI Registry
            registry.bind("acc", a);
            registry.bind("register", ri);
            System.out.println("My serverino is ready...");   
        } catch (Exception ex) {
           System.out.println("Exception occured");
        }
        
        
        
        //ConnectToDB.insertRecord(A, "Accounts");
        
        //ConnectToDB.updateRecord(", "Omar", "Hello");
        
        //ArrayList<Ticket> TEST = new ArrayList<Ticket>();
        
        /*Bus B = new Bus();
        Route R = new Route(1,B,"RouteName","Ana aho","Ana henak");
        Ticket T = new Ticket(R,"10");
        
        Client C = new Client(A,T);
        TEST.add(T);
        C.setReservationHistory(TEST);
        
        
        ConnectToDB.deleteRecord("Client", "Test");
        */
        //ConnectToDB.insertRecord(C, "Client");
        
        
        //BusDriver salma = new BusDriver();
        //Bus B = new Bus(salma,200);
        //Account A = new Account();
        //
        
        //ConnectToDB.insertRecord(B,"Bus");
        //ConnectToDB.deleteRecord("Bus", "200");
        //ConnectToDB.insertRecord(A,"Accounts");
        //ConnectToDB.deleteRecord("Accounts","AnaEsmy Ali");
    }
    
}
