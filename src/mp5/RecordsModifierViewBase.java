package mp5;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
    protected JPanel fieldPanel, btnPanel, datePanel;
    

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
        monthsBox = new JComboBox<>();
        daysBox = new JComboBox<>();
        yearsBox = new JComboBox<>();
        fieldPanel = new JPanel();
        btnPanel = new JPanel();
        datePanel = new JPanel();
        
        nameLabel.setText("Name: ");
        backBtn.setText("Back");
        
        frameInit(600, 200);
    }
    
    public void frameInit(int x, int y)
    {
        this.setResizable(false);
        this.setSize(x, y);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public void init()
    {
        fieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        nameField.setPreferredSize(new Dimension(300, 30));
        
        fieldPanel.add(nameLabel);
        fieldPanel.add(nameField);
        
        btnPanel.add(actionGoBtn);
        btnPanel.add(actionMoreBtn);
        btnPanel.add(backBtn);
        
        datePanel.add(monthsBox);
        datePanel.add(daysBox);
        datePanel.add(yearsBox);
        
        this.add(fieldPanel);
        this.add(datePanel);
        this.add(btnPanel);
    }

    public void addActionGoBtnListener(MouseAdapter onClickEvent)
    {
        actionGoBtn.addMouseListener(onClickEvent);
    }
    
    public void addActionMoreBtnListener(MouseAdapter onClickEvent)
    {
        actionMoreBtn.addMouseListener(onClickEvent);
    }
    
    public void addBackBtnListener(MouseAdapter onClickEvent)
    {
        backBtn.addMouseListener(onClickEvent);
    }
}
