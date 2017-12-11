package busreservationsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BusReservationSystemClient {

    public static String currentUsername;
    private static Register registerGUI = new Register();
    private static Login loginGUI = new Login();
    private static AccountInterface a;
    private static RegistrationInterface ri;
    private static Admin_Homepage ah = new Admin_Homepage();
    private static Client_Homepage ch = new Client_Homepage();
    private static Admin_Add_Bus_Driver_Page abd = new Admin_Add_Bus_Driver_Page();
    private static Admin_Add_Bus_Page abp = new Admin_Add_Bus_Page();
    private static Admin_Add_Route_Page arp = new Admin_Add_Route_Page();
    private static Admin_Edit_Bus_Page ebp = new Admin_Edit_Bus_Page();
    private static Client_Route_Bus_Page rbp = new Client_Route_Bus_Page();
    private static Client_Ticket_History_Page thp = new Client_Ticket_History_Page();
    private static Client_Account_Info_Page aip = new Client_Account_Info_Page();
    private static Client_Bus_Page cbp = new Client_Bus_Page();
    
    private static ArrayList<Bus> busArraylist = new ArrayList<Bus>();
    private static Route busRoute;

    public static void main(String[] args) {
        try {
            // Connecting to the RMI Registry created on the server
            Registry registry = LocateRegistry.getRegistry(1099);

            a = (AccountInterface) registry.lookup("acc");
            ri = (RegistrationInterface) registry.lookup("register");

            loginGUI.setLocationRelativeTo(null);
            loginGUI.setVisible(true);

            registerGUI.getRegisterButton().addActionListener(new RegisterButtonListener());
            registerGUI.getLoginButton().addActionListener(new LoginRButtonListener());

            loginGUI.getLoginButton().addActionListener(new LoginButtonListener());
            loginGUI.getRegisterButton().addActionListener(new RegisterPageButtonListener());

            abd.getAddButton().addActionListener(new AddDriverButtonListener());
            abd.getCancelButton().addActionListener(new ReturnToAdminHomePageButtonListener());

            arp.getAddRouteButton().addActionListener(new AddNewRouteButtonListener());
            arp.getCancelButton().addActionListener(new ReturnToAdminHomePageButtonListener());

            abp.getAddBusButton().addActionListener(new AddNewBusButtonListener());
            abp.getCancelButton().addActionListener(new ReturnToAdminHomePageButtonListener());

            ah.getAddBusButton().addActionListener(new AddBusButtonListener());
            ah.getBrowseRoutesButton().addActionListener(new BrowseRouteButtonListener());
            ah.getTicketsSoldButton().addActionListener(new TicketSoldButtonListener());
            ah.getEditBusButton().addActionListener(new EditBusButtonListener());
            ah.getLogoutButton().addActionListener(new LogoutButtonListener());
            ah.getAddDriverButton().addActionListener(new AddBusDriverButtonListener());
            ah.getAddRouteButton().addActionListener(new AddRouteButtonListener());

            ch.getViewProfileButton().addActionListener(new ViewProfileButtonListener());
            ch.getTicketHistoryButton().addActionListener(new TicketHistoryButtonListener());
            ch.getBookRideButton().addActionListener(new BookRideButtonListener());
            ch.getLogoutButton().addActionListener(new LogoutButtonListener());

            abp.getBusDriverComboBox().addActionListener(new ChosenDriverListener());
            
            rbp.getRouteIDComboBox().addActionListener(new ChosenRouteListener());
            rbp.getBackButton().addActionListener(new BackPageButtonListener());
            
            ArrayList<Integer> busArr = new ArrayList<>();
            ArrayList<Integer> busDriverArr = new ArrayList<>();
            ArrayList<Integer> routeArr = new ArrayList<>();
            
            busArr = ConnectToDB.GetBusID();
            for (int i = 0; i < busArr.size(); i++) {
                arp.getBusNumberComboBox().addItem(String.valueOf(busArr.get(i)));
            }
            busDriverArr = ConnectToDB.GetBusDriverIDForBus();
            for (int i = 0; i < busDriverArr.size(); i++) {
                abp.getBusDriverComboBox().addItem(String.valueOf(busDriverArr.get(i)));
            }
            routeArr = ConnectToDB.GetRouteIDSomething();
            for (int i = 0; i < routeArr.size(); i++) {
                rbp.getRouteIDComboBox().addItem(String.valueOf(routeArr.get(i)));
            }

        } catch (Exception ex) {
            System.out.println("Exception occured1");
        }
    }
    
     static class ChosenRouteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Route r = new Route();
                
                r = ConnectToDB.GetRoute(Integer.parseInt(String.valueOf(rbp.getRouteIDComboBox().getSelectedItem())));
                busRoute = r;
                
                rbp.getRouteNameLabel().setText(r.getRouteName());
                rbp.getDepartingLabel().setText(r.getDepartingFrom());
                rbp.getArrivingLabel().setText(r.getArrivingTo());
                
                busArraylist = r.getBuses();
                
                rbp.getBusButton_1().addActionListener(new ChosenBusButtonListener());
                rbp.getBusButton_2().addActionListener(new ChosenBusButtonListener());
                rbp.getBusButton_3().addActionListener(new ChosenBusButtonListener());
                rbp.getBusButton_4().addActionListener(new ChosenBusButtonListener());
                
                
                rbp.getBusButton_1().setText(String.valueOf(r.getBuses().get(0).getBusID()));
                rbp.getBusButton_2().setText(String.valueOf(r.getBuses().get(1).getBusID()));
                rbp.getBusButton_3().setText(String.valueOf(r.getBuses().get(2).getBusID()));
                rbp.getBusButton_4().setText(String.valueOf(r.getBuses().get(3).getBusID()));
            } catch (RemoteException ex) {
                System.out.println("Error setting the bus driver labels");
            }
        }
    }
    
     static class ChosenBusButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                for(int i = 0; i < 4; i++){
                    if(busArraylist.get(i).getBusID() != 0){
                        rbp.dispose();
                        
                        cbp.getBusIdLabel().setText(String.valueOf(busArraylist.get(i).getBusID()));
                        cbp.getDriverNameLabel().setText(busArraylist.get(i).getBusDriver().getDriverName());
                        cbp.getRouteNameLabel().setText(busRoute.getRouteName());
                        
                        cbp.setVisible(true);
                        cbp.setLocationRelativeTo(null);
                    }
                }
            } catch (RemoteException ex) {
                System.out.println("Error setting the bus driver labels");
            }
        }
    }
     
    static class BackPageButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            rbp.dispose();
            cbp.dispose();
            
            if(currentUsername.equals("admin")){
                ah.setVisible(true);
                ah.setLocationRelativeTo(null);
            }
            else{
                ch.setVisible(true);
                ch.setLocationRelativeTo(null);
            }
        }
    }
     
    static class ChosenDriverListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                BusDriver bd = new BusDriver();
                bd = ConnectToDB.GetBusDriver(Integer.parseInt(String.valueOf(abp.getBusDriverComboBox().getSelectedItem())));
                abp.getDriverNameLabel().setText(bd.getDriverName());
                abp.getDriverRatingLabel().setText(String.valueOf(bd.getDriverRateAvg()));
            } catch (RemoteException ex) {
                System.out.println("Error setting the bus driver labels");
            }
        }
    }

    public static void updateBusComboBox() {
        ArrayList<Integer> busArr = new ArrayList<>();
        try {
            arp.getBusNumberComboBox().removeAllItems();
            //arp.getBusNumberComboBox().addItem("---");
            busArr = ConnectToDB.GetBusID();
            for (int i = 0; i < busArr.size(); i++) {
                arp.getBusNumberComboBox().addItem(String.valueOf(busArr.get(i)));
            }
        } catch (RemoteException ex) {
            System.out.println("ERROR in updatebuscombobox");
        }
    }
    
    public static void updateRouteComboBox() {
        ArrayList<Integer> routeArr = new ArrayList<>();
        try {
            for(int i = 0; i < routeArr.size(); i++){
                rbp.getRouteIDComboBox().remove(i);
            }
            //rbp.getRouteIDComboBox().remove(0);
            //rbp.getRouteIDC---boBox().addItem("---");
            routeArr = ConnectToDB.GetBusID();
            for (int i = 0; i < routeArr.size(); i++) {
                arp.getBusNumberComboBox().addItem(String.valueOf(routeArr.get(i)));
            }
        } catch (RemoteException ex) {
            System.out.println("ERROR in updateroutecombobox");
        }
    }

    public static void updateBusDriversComboBox() {
        ArrayList<Integer> busDriverArr = new ArrayList<>();
        try {
            abp.getBusDriverComboBox().removeAll();
            //abp.getBusDriverComboBox().addItem("---");
            busDriverArr = ConnectToDB.GetBusDriverIDForBus();
            for (int i = 0; i < busDriverArr.size(); i++) {
                abp.getBusDriverComboBox().addItem(String.valueOf(busDriverArr.get(i)));
            }
        } catch (RemoteException ex) {
            System.out.println("ERROR in updatebusdrivercombobox");
        }
    }

    static class AddNewRouteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String str = String.valueOf(arp.getBusNumberComboBox().getSelectedItem());
            
            String routeName = arp.getRouteNameTextField().getText();
            String departing = arp.getDepartingTextField().getText();
            String arriving = arp.getArrivingTextField().getText();

            try {
                if (routeName.equals("") && departing.equals("") && arriving.equals("")) {
                    JOptionPane.showMessageDialog(null, "Route has not been added.");
                    System.out.println("Route has not been added.");
                } else {
                    int busID = Integer.parseInt(String.valueOf(arp.getBusNumberComboBox().getSelectedItem()));
                    updateRouteComboBox();
                    Route temp = new Route(busID, routeName, departing, arriving);
                    JOptionPane.showMessageDialog(null, "You have successfully added a Route");

                }
            } catch (RemoteException ex) {

            }
        }
    }

    static class AddNewBusButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String str = String.valueOf(abp.getBusDriverComboBox().getSelectedItem());

            try {
                int busDriverID;
                if(!str.equals("---")){
                    busDriverID = Integer.parseInt(String.valueOf(abp.getBusDriverComboBox().getSelectedItem()));
                    BusDriver busDriver = ConnectToDB.GetBusDriver(busDriverID);
                    
                    Bus temp = new Bus(busDriver);
                    JOptionPane.showMessageDialog(null, "You have successfully added a Bus.");
                }else{
                    JOptionPane.showMessageDialog(null, "Please choose a Bus Driver ID Number.", "No Bus Driver Chosen.", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (RemoteException ex) {
                System.out.println("Bus Driver has not been added.");
            }
        }
    }

    static class AddDriverButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String driverName = abd.getNameTextField().getText();
            try {
                if (driverName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a driver name", "Bus Driver Name Empty", JOptionPane.ERROR_MESSAGE);
                } else {
                    BusDriver x = new BusDriver(driverName);
                    updateBusDriversComboBox();
                    JOptionPane.showMessageDialog(null, "Bus Driver has been added successfully");
                }
            } catch (RemoteException ex) {
                System.out.println("Bus Driver has not been added.");
            }
        }
    }

    static class ReturnToAdminHomePageButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            abd.dispose();
            abp.dispose();
            arp.dispose();
            ebp.dispose();
            thp.dispose();

            ah.setVisible(true);
            ah.setLocationRelativeTo(null);
        }
    }

    static class ReturnToClientHomePageButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            thp.dispose();

            ch.setVisible(true);
            ch.setLocationRelativeTo(null);
        }
    }

    static class RegisterPageButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loginGUI.dispose();
            registerGUI.setVisible(true);
            registerGUI.setLocationRelativeTo(null);
        }
    }

    static class ViewProfileButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ch.dispose();
            aip.setVisible(true);
            aip.setLocationRelativeTo(null);
        }
    }

    static class TicketHistoryButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ch.dispose();
            thp.setVisible(true);
            thp.setLocationRelativeTo(null);
        }
    }

    static class BookRideButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ch.dispose();
            rbp.setVisible(true);
            rbp.setLocationRelativeTo(null);
        }
    }

    static class AddRouteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ah.dispose();
            arp.setVisible(true);
            arp.setLocationRelativeTo(null);
        }
    }

    static class EditBusButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ah.dispose();
            ebp.setVisible(true);
            ebp.setLocationRelativeTo(null);
        }
    }

    static class TicketSoldButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ah.dispose();
            thp.setVisible(true);
            thp.setLocationRelativeTo(null);
        }
    }

    static class BrowseRouteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ah.dispose();
            rbp.setVisible(true);
            rbp.setLocationRelativeTo(null);
        }
    }

    static class LogoutButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ch.dispose();
            ah.dispose();
            loginGUI.setVisible(true);
            loginGUI.setLocationRelativeTo(null);
            try {
                a.Logout(currentUsername);
            } catch (RemoteException ex) {
                System.out.println("Error in LogoutButtonListener!");
            }
        }
    }

    static class AddBusDriverButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ah.dispose();
            abd.setVisible(true);
            abd.setLocationRelativeTo(null);
        }
    }

    static class AddBusButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ah.dispose();
            abp.setVisible(true);
            abp.setLocationRelativeTo(null);
        }
    }

    static class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            currentUsername = loginGUI.getUsernameTextField().getText();
            String password = String.valueOf(loginGUI.getPasswordField().getPassword());

            try {
                if (a.Login(currentUsername, password)) {
                    JOptionPane.showMessageDialog(null, "You have successfully logged in into the system!");
                    loginGUI.dispose();

                    if (currentUsername.equals("admin")) {
                        ah.setVisible(true);
                        ah.setLocationRelativeTo(null);
                    } else {
                        ch.setVisible(true);
                        ch.setLocationRelativeTo(null);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password!", "Username/Password Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (RemoteException ex) {
                Logger.getLogger("Error");
            }

        }
    }

    static class LoginRButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            registerGUI.dispose();
            loginGUI.setVisible(true);
            loginGUI.setLocationRelativeTo(null);
        }
    }

    static class RegisterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = registerGUI.getUsernameTextField().getText();
            String password = String.valueOf(registerGUI.getPasswordField().getPassword());
            String rePassword = String.valueOf(registerGUI.getRePasswordField().getPassword());
            if (!username.isEmpty() && !password.isEmpty() && !rePassword.isEmpty()) {
                if (!password.equals(rePassword)) {
                    JOptionPane.showMessageDialog(null, "password does not match", "Password Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        boolean userChecker = ri.Register(username, password, rePassword);
                        if (userChecker) {
                            JOptionPane.showMessageDialog(null, "You have succesfully registered to the system!");
                            registerGUI.dispose();
                            loginGUI.setVisible(true);
                            loginGUI.setLocationRelativeTo(null);
                        } else {
                            JOptionPane.showMessageDialog(null, "Username Already Exists", "Username Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (RemoteException ex) {
                        System.out.println("resgister function remote client error");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username or Password has not been entered", "Registration Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
