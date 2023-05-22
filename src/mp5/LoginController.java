package mp5;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginController 
{
    LoginView viewmodel;
    Credentials creds;
    private boolean isLoggedIn = false;
    
    public LoginController(LoginView viewmodel, Credentials creds)
    {
        this.viewmodel = viewmodel;
        this.creds = creds;
        
        this.viewmodel.addBtnListener(loginButtonListener);
    }
    
    public boolean getLoginStatus()
    {
        return isLoggedIn;
    }
    
    MouseAdapter loginButtonListener = new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent e) 
        {
            String u = viewmodel.getUsername();
            String p = viewmodel.getPassword();
            
            if(!creds.checkCredentials(u, p))
            {
                viewmodel.displayLoginError();
                creds.incrementTryCount();
            }
            else
            {
                System.out.println("Login successful");
                isLoggedIn = true;
                viewmodel.closeFrame();
            }
            
            if(creds.getTries() >= 3)
            {
                viewmodel.displayExhaustedTries();
                viewmodel.dispose();
            }
                
        }
    };
}
