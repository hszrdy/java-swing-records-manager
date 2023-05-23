package mp5;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RemoveRecordsView extends RecordsModifierViewBase
{
    
    private JPanel fieldPanel, btnPanel;
    
    public RemoveRecordsView()
    {
        super();
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setTitle("Remove Records");
        super.init();
        init();
    }
    
    @Override
    public void init()
    {
        actionGoBtn.setText("Remove and Go Back");
        actionMoreBtn.setText("Save & Remove Another");
        this.remove(datePanel);
    }
    
    public String getNameForRemoval()
    {
        return nameField.getText();
    }

    public void displayNameNotFound() 
    {
        JOptionPane.showMessageDialog(this, "An IllegalArgumentException Caught: Name Not Found!");
    }
    
    
}
