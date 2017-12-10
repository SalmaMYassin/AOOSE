/** **********************************************
 * Advanced Object Oriented Software Engineering *
 * Project - Final Phase                         *
 * Group 12                                      *
 *********************************************** */
package busreservationsystem;

import com.mongodb.*;
import java.rmi.RemoteException;

public class ConnectToDB {

    public static MongoClient mongo = new MongoClient("localhost", 27017);
    public static final DB db = mongo.getDB("BusReservationSystem");

    public static final DBCollection collectionAccount = db.getCollection("Accounts");
    public static final DBCollection collectionBus = db.getCollection("Bus");
    public static final DBCollection collectionBusDriver = db.getCollection("BusDriver");
    public static final DBCollection collectionClient = db.getCollection("Client");
    public static final DBCollection collectionRoute = db.getCollection("Route");
    public static final DBCollection collectionTicket = db.getCollection("Ticket");

    public ConnectToDB() {
    }

    public static void insertRecord(Object obj, String collectionName) throws RemoteException {
        if (collectionName.equals("Accounts")) {
            Account A = (Account) obj;
            DBObject account = new BasicDBObject("Username", A.getUsername())
                    .append("Password", A.getPassword())
                    .append("is_Logged_In", String.valueOf(A.isLoggedIn()));
            collectionAccount.insert(account);
        } else if (collectionName.equals("Client")) {
            Client C = (Client) obj;
            int[] tempTicketHistory = new int[C.getReservationHistory().size()];
            for (int i = 0; i < tempTicketHistory.length; i++) {
                tempTicketHistory[i] = C.getReservationHistory().get(i).getTicketID();
            }
            DBObject client = new BasicDBObject("Client_Username", C.getClientAccount().getUsername())
                    .append("Current_Reservation", C.getCurrentReservation().getTicketID())
                    .append("Reserved_Route_Name", C.getCurrentReservation().getBookedRoute().getRouteName())
                    .append("Ticket_Reservation_History", tempTicketHistory);
            collectionClient.insert(client);
        } else if (collectionName.equals("Route")) {
            Route R = (Route) obj;
            DBObject route = new BasicDBObject("Route_ID", R.getRouteID())
                    .append("Buses", R.getBusesID())
                    .append("Route_Name", R.getRouteName())
                    .append("Departed_From", R.getDepartingFrom())
                    .append("Arriving_To", R.getArrivingTo());
            collectionRoute.insert(route);
        } else if (collectionName.equals("Bus")) {
            Bus B = (Bus) obj;
            DBObject bus;
            String[] tempSeats = new String[25];

            for (int i = 0; i < 24; i++) {
                tempSeats[i] = (i + 1) + "/" + String.valueOf(B.getSeatUnavailable().get(i + 1));
            }
            bus = new BasicDBObject("Bus_ID", B.getBusID())
                    .append("Bus_Driver", B.getBusDriver().getDriverName())
                    .append("Seat_Number_Availability", tempSeats);
            collectionBus.insert(bus);
        } else if (collectionName.equals("BusDriver")) {
            BusDriver BD = (BusDriver) obj;
            DBObject busDriver;
            busDriver = new BasicDBObject("Driver_ID", BD.getDriverID())
                    .append("Driver_Name", BD.getDriverName())
                    .append("Driver_Rating", BD.getDriverRateAvg());
            collectionBusDriver.insert(busDriver);
        } else if (collectionName.equals("Ticket")) {
            Ticket T = (Ticket) obj;
            DBObject ticket;
            ticket = new BasicDBObject("Ticket_ID", T.getTicketID())
                    .append("Booked_Route", T.getBookedRoute().getRouteName())
                    .append("Seat_Number", T.getSeatNumber());
        }
    }

    public static void updateRecord(Object collectionName, String searchTerm, String replaceTerm, int routeBusPositionNum) throws RemoteException {

        if (collectionName.getClass().getSimpleName().equals("Account")) {
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("Username", searchTerm);

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("Password", replaceTerm);

            BasicDBObject updateObj = new BasicDBObject();
            updateObj.put("$set", newDocument);

            collectionAccount.update(searchQuery, updateObj);
        } else if (collectionName.getClass().getSimpleName().equals("Bus")) {
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("Bus_ID", searchTerm);

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("Bus_Driver", replaceTerm);

            BasicDBObject updateObj = new BasicDBObject();
            updateObj.put("$set", newDocument);

            collectionAccount.update(searchQuery, updateObj);
        }/*else if (collectionName.getClass().getSimpleName().equals("Route")) {
            Route R = (Route)collectionName;
            
            BasicDBObject searchQuery = new BasicDBObject(); // Search By
            searchQuery.put("Route_ID", searchTerm);
            Bus B = new Bus();
            
            R.getBuses().set(routeBusPositionNum, B);
                    
            BasicDBObject newDocument = new BasicDBObject(); //Replace with
            newDocument.put("Bus_ID",R.getBusesID());

            BasicDBObject updateObj = new BasicDBObject(); // Update the record
            updateObj.put("$set", newDocument);

            collectionAccount.update(searchQuery, updateObj);
        }*/
    }

    boolean AccountChecker(String searchTerm) throws RemoteException {
        BasicDBObject searchQuery = new BasicDBObject("Username", searchTerm);

        DBCursor cursor = collectionAccount.find(searchQuery);

        try {
            while (cursor.hasNext()) {
                return true;
            }
        } finally {
            cursor.close();
        }
        return false;
    }

    public static int GetBusDriverID() throws RemoteException {
        int driverID = 0;
        
        DBCursor cursor = collectionBusDriver.find();
        try {
            while (cursor.hasNext()) {
                driverID = Integer.parseInt(String.valueOf(cursor.next().get("Driver_ID")));
            }
        } finally {
            cursor.close();
        }
        return driverID;
    }
    
    public static int GetRouteID() throws RemoteException {
        int routeID = 0;
        
        DBCursor cursor = collectionRoute.find();
        try {
            while (cursor.hasNext()) {
                routeID = Integer.parseInt(String.valueOf(cursor.next().get("Route_ID")));
            }
        } finally {
            cursor.close();
        }
        return routeID;
    }
    
    boolean isLoggedInChecker(String searchTerm, String isLoggedIn) throws RemoteException {
        BasicDBObject searchQuery = new BasicDBObject("Username", searchTerm);

        BasicDBObject field = new BasicDBObject();

        DBCursor cursor = collectionAccount.find(searchQuery, field);
        try {
            while (cursor.hasNext()) {
                if (cursor.next().get("is_Logged_In").equals(isLoggedIn)) {
                    return true;
                }
            }
        } finally {
            cursor.close();
        }
        return false;
    }

    public static boolean PasswordChecker(String searchTerm, String password) throws RemoteException {
        ConnectToDB temp = new ConnectToDB();
        if (temp.AccountChecker(searchTerm)) {
            BasicDBObject searchQuery = new BasicDBObject("Username", searchTerm);

            DBCursor cursor = collectionAccount.find(searchQuery);
            try {
                while (cursor.hasNext()) {
                    if (cursor.next().get("Password").equals(password)) {
                        return true;
                    }
                }
            } finally {
                cursor.close();
            }
        }
        return false;
    }

    public static void updateLoggedIn(String searchTerm, String replaceTerm) {

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("Username", searchTerm);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("is_Logged_In", replaceTerm);

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        collectionAccount.update(searchQuery, updateObj);
    }

    public static void deleteRecord(String collectionName, String searchTerm) throws RemoteException {
        BasicDBObject searchQuery = new BasicDBObject();
        if (collectionName.equals("Accounts")) {
            searchQuery.put("Username", searchTerm);
            collectionAccount.remove(searchQuery);
        } else if (collectionName.equals("Client")) {
            searchQuery.put("Client_Username", searchTerm);
            collectionClient.remove(searchQuery);
        } else if (collectionName.equals("Bus")) {
            searchQuery.put("Bus_ID", Integer.parseInt(searchTerm));
            collectionBus.remove(searchQuery);
        } else if (collectionName.equals("BusDriver")) {
            searchQuery.put("Driver_ID", Integer.parseInt(searchTerm));
            collectionBusDriver.remove(searchQuery);
        } else if (collectionName.equals("Route")) {
            searchQuery.put("Route_ID", Integer.parseInt(searchTerm));
            collectionRoute.remove(searchQuery);
        } else if (collectionName.equals("Ticket")) {
            searchQuery.put("Ticket_ID", Integer.parseInt(searchTerm));
            collectionTicket.remove(searchQuery);
        }
    }
}
