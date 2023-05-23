package mp5;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main 
{
    LoginView loginView;
    Credentials creds;
    LoginController loginController;
    CentralRecordsView recordsView;
    RecordsController recordsController;
    Person person;
    
    private void start()
    {
       loginView = new LoginView();
       creds = new Credentials();
       loginController = new LoginController(loginView, creds); 
       
       recordsView = new CentralRecordsView();
       person = new Person();
       recordsController = new RecordsController(recordsView, person);
       
       init();   
    }
    
    private void init()
    {
        loginView.addWindowListener(windowEvent);
    }
    
    public static void main(String[] args) 
    {
        Main app = new Main();
        app.start();
    }
    
    WindowAdapter windowEvent = new WindowAdapter() 
    {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                if(!loginController.getLoginStatus()) return;
                recordsView.setVisible(true);
            }
            
    };
}
