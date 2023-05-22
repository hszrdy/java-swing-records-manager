package mp5;

import java.util.HashMap;

public class Credentials 
{
    private static final String DEFAULT_LOGIN_CREDENTIALS_FILE = ".\\loginCredentials.txt";

    private HashMap<String, String> userCredentialsMap = 
            Utilities.getLoginCredentials(DEFAULT_LOGIN_CREDENTIALS_FILE);
    
    private int tries = 0;
    private boolean loginStatus = false;
    
    
    public boolean checkCredentials(String username, String password)
    {
        if(!userCredentialsMap.containsKey(username)) return false;
        if(!userCredentialsMap.get(username).equals(password)) return false;
        
        return true;
    }
    
    public boolean getLoginStatus()
    {
        return loginStatus;
    }
    
    public int getTries()
    {
        return tries;
    }
    
    public void incrementTryCount()
    {
        tries++;
    }
}
