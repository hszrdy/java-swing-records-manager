package mp5;

import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import javax.swing.*;

public class RecordsModifierViewBase extends JFrame
{
    protected JLabel nameLabel, birthDayLabel, mmLabel, ddLabel, yyyyLabel;
    protected JTextField nameField;
    protected JButton actionGoBtn, actionMoreBtn, backBtn;
    protected JComboBox<String> monthsBox;
    protected JComboBox<String> daysBox;
    protected JComboBox<String> yearsBox;

    public RecordsModifierViewBase()
    {
        nameLabel = new JLabel();
        birthDayLabel = new JLabel();
        mmLabel = new JLabel();
        ddLabel = new JLabel();
        yyyyLabel = new JLabel();
        nameField = new JTextField();
        actionGoBtn = new JButton();
        actionMoreBtn = new JButton();
        backBtn = new JButton();
    }
    
    public void init()
    {
        
    }
    
    public void setVisibility(boolean state)
    {
        this.setVisible(state);
    }
    
    public void addBtnListener(MouseAdapter onClickEvent)
    {
        actionGoBtn.addMouseListener(onClickEvent);
        actionMoreBtn.addMouseListener(onClickEvent);
        backBtn.addMouseListener(onClickEvent);
    }
}
