package mp5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import javax.swing.*;

public class CentralRecordsView extends JFrame
{
    private JTextArea recordArea;
    private JScrollPane scrollPane;
    private JComboBox<String> dropMenu;
    private JRadioButton rAscending, rDescending;
    private JButton addRecordBtn, removeRecordBtn, exportBtn;
    private JPanel tblPanel, optionContainer, btnContainer, radioContainer;
    private ButtonGroup rBtnGroup;
    private JLabel label;
    
    private static final String[] sortOptions = 
        { "Name", "Birthday", "Age" };
    
    private static final String header = 
            "\tNAME\t BIRTHDAY\t AGE";
    
    public CentralRecordsView()
    {
        dropMenu = new JComboBox<>(sortOptions);
        recordArea = new JTextArea(header,15,30);
        rBtnGroup = new ButtonGroup();
        rAscending = new JRadioButton();
        rDescending = new JRadioButton();
        addRecordBtn = new JButton();
        removeRecordBtn = new JButton();
        exportBtn = new JButton();
        scrollPane = new JScrollPane(recordArea);
        label = new JLabel();
        optionContainer = new JPanel();
        tblPanel = new JPanel();
        btnContainer = new JPanel();
        radioContainer = new JPanel();
        
        init();
    }
    
    public void init()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setTitle("Records");
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        recordArea.setEditable(false);
        rDescending.setText("Descending");
        rAscending.setText("Ascending");
        exportBtn.setText("Export to CSV");
        addRecordBtn.setText("Add record");
        removeRecordBtn.setText("Remove record");
        label.setText("Sort By: ");
        
        rBtnGroup.add(rAscending);
        rBtnGroup.add(rDescending);
        
        optionContainer.setBackground(Color.red);
        tblPanel.setBackground(Color.BLUE);
        
        tblPanel.add(scrollPane);
        optionContainer.add(label);
        optionContainer.add(dropMenu);
        optionContainer.add(rAscending);
        optionContainer.add(rDescending);
        btnContainer.add(addRecordBtn);
        btnContainer.add(removeRecordBtn);
        btnContainer.add(exportBtn);
        
        
        this.add(tblPanel);
        this.add(optionContainer);
        this.add(btnContainer);
    }
    
    public void addBtnListener(MouseAdapter onClickEvent)
    {
        addRecordBtn.addMouseListener(onClickEvent);
        removeRecordBtn.addMouseListener(onClickEvent);
        exportBtn.addMouseListener(onClickEvent);
    }
    
    public void appendRecord(String record)
    {
        recordArea.append("\n"+ record);
    }
}
