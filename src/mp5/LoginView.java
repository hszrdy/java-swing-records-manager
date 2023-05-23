package mp5;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class LoginView extends JFrame
{
    private JPanel panel, btnPanel;
    private JTextField userField;
    private JPasswordField passField;
    private JLabel userLabel, passLabel;
    private JButton loginBtn;
    
    public LoginView()
    {
        panel = new JPanel();
        userField = new JTextField();
        passField = new JPasswordField();
        passLabel = new JLabel();
        userLabel = new JLabel();
        loginBtn = new JButton();
        btnPanel = new JPanel();
        init();
    }
    
    public void init()
    {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 200);
        this.setLocation(500, 400);
        this.setLayout(new GridLayout(2,1));
        panel.setLayout(new GridLayout(2, 2));
        
        loginBtn.setText("Login");
        loginBtn.setPreferredSize(new Dimension(100, 30));
        
        userLabel.setText("Username:");
        passLabel.setText("Password:");
        passField.setEchoChar('*');
        
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        btnPanel.add(loginBtn);
        
        this.add(panel);
        this.add(btnPanel);
        
        this.setVisible(true);
    }
    
    public String getUsername()
    {
        return userField.getText();
    }
    
    public String getPassword()
    {
        return new String(passField.getPassword());
    }
    
    public void addBtnListener(MouseAdapter onClickEvent)
    {
        loginBtn.addMouseListener(onClickEvent);
    }
    
    public void displayLoginError()
    {
        JOptionPane.showMessageDialog(this, "Wrong Username / Password.");
    }
    
    public void displayExhaustedTries()
    {
        JOptionPane.showMessageDialog(this, "Sorry, you have reached the limit of 3 tries, good bye!");
    }
    
    public void closeFrame()
    {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
