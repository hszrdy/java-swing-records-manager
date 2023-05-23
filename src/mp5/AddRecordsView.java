package mp5;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AddRecordsView extends RecordsModifierViewBase
{
    
    public static final int MAX_YEAR = 2023;
    public static final int MIN_YEAR = 1900;
    
    public AddRecordsView()
    {
        super();
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setTitle("Add Record");
        super.init();
        setupComboBoxes();
        init();
    }
    
    @Override
    public void init()
    {
        monthsBox.setSelectedIndex(0);
        yearsBox.setSelectedIndex(0);
        daysBox.setSelectedIndex(0);
        actionGoBtn.setText("Save and Go Back");
        actionMoreBtn.setText("Save & Add Another");
    }
    
    public String getName()
    {
        return nameField.getText();
    }
    
    public String getMonth()
    {
        return monthsBox.getItemAt(monthsBox.getSelectedIndex());
    }
    
    public String getDay()
    {
        return daysBox.getItemAt(daysBox.getSelectedIndex());
    }
    
    public String getYear()
    {
        return yearsBox.getItemAt(yearsBox.getSelectedIndex());
    }
    
    private void setupComboBoxes()
    {
        for(String months : Utilities.months)
            monthsBox.addItem(months);
        
        for(int i = 1; i <= 31; ++i)
            daysBox.addItem(Integer.toString(i));
        
        for(int i = MIN_YEAR; i <= MAX_YEAR; ++i)
            yearsBox.addItem(Integer.toString(i));
            
    }
    
    public void showInvalidDateError()
    {
        JOptionPane.showMessageDialog(this, "An IllegalArgumentException Caught: Invalid Date.");
    }
    
    public void showInvalidNameError()
    {
        JOptionPane.showMessageDialog(this, "An IllegalArgumentException Caught: Invalid Name.");
    }
   
}
