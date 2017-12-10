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
    private static Client_Ticket_History_Page thp = new Client_Ticket_History_Page();
    private static Client_Route_Browser_Page rbp = new Client_Route_Browser_Page();
    private static Client_Account_Info_Page aip = new Client_Account_Info_Page();
    
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
            
            
            
            ArrayList<Integer> busArr = new ArrayList<>();
            busArr = ConnectToDB.GetBusID();
            for(int i = 0; i < busArr.size(); i++){
                arp.getBusNumberComboBox().addItem(String.valueOf(busArr.get(i)));
            }
        } catch (Exception ex) {
            System.out.println("Exception occured");
        }
    }
    
    static class AddNewRouteButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            int busID = Integer.parseInt(String.valueOf(arp.getBusNumberComboBox().getSelectedItem()));
            String routeName = arp.getRouteNameTextField().getText();
            String departing = arp.getDepartingTextField().getText();
            String arriving = arp.getArrivingTextField().getText();
            
            try {
                Route temp = new Route(busID, routeName, departing, arriving);
            } catch (RemoteException ex) {
                System.out.println("Error");
            }
        }
    }
    
    static class AddDriverButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String driverName = abd.getNameTextField().getText();
            try {
                if(driverName.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter a driver name", "Bus Driver Name Empty", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    BusDriver x = new BusDriver(driverName);
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
            
            abd.setVisible(false);
            abp.setVisible(false);
            arp.setVisible(false);
            ebp.setVisible(false);
            thp.setVisible(false);
            rbp.setVisible(false);
            
            ah.setVisible(true);
            ah.setLocationRelativeTo(null);
        }
    }
    
    static class ReturnToClientHomePageButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            thp.setVisible(false);
            rbp.setVisible(false);
            
            ch.setVisible(true);
            ch.setLocationRelativeTo(null);
        }
    }

    static class RegisterPageButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loginGUI.setVisible(false);
            registerGUI.setVisible(true);
            registerGUI.setLocationRelativeTo(null);
        }
    }
    
    static class ViewProfileButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ch.setVisible(false);
            aip.setVisible(true);
            aip.setLocationRelativeTo(null);
        }
    }
    
    static class TicketHistoryButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ch.setVisible(false);
            thp.setVisible(true);
            thp.setLocationRelativeTo(null);
        }
    }

    static class BookRideButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ch.setVisible(false);
            rbp.setVisible(true);
            rbp.setLocationRelativeTo(null);
        }
    }
    
    static class AddRouteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ah.setVisible(false);
            arp.setVisible(true);
            arp.setLocationRelativeTo(null);
        }
    }
    
    static class EditBusButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ah.setVisible(false);
            ebp.setVisible(true);
            ebp.setLocationRelativeTo(null);
        }
    }
    
    static class TicketSoldButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ah.setVisible(false);
            thp.setVisible(true);
            thp.setLocationRelativeTo(null);
        }
    }
    
    static class BrowseRouteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ah.setVisible(false);
            rbp.setVisible(true);
            rbp.setLocationRelativeTo(null);
        }
    }
    
    static class LogoutButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ch.setVisible(false);
            ah.setVisible(false);
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
            
            ah.setVisible(false);
            abd.setVisible(true);
            abd.setLocationRelativeTo(null);
        }
    }

    static class AddBusButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ah.setVisible(false);
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
                    loginGUI.setVisible(false);
                    
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
            registerGUI.setVisible(false);
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
                            registerGUI.setVisible(false);
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
