package mp5;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class RecordsController 
{
    CentralRecordsView viewmodel;
    Person personRecord;
    
    //viewmodel for addrecord and removerecord
    
    public RecordsController(CentralRecordsView viewmodel, Person personRecord)
    {
        this.viewmodel = viewmodel;
        this.personRecord = personRecord;
    }
    
    MouseAdapter onClickEvent = new MouseAdapter() 
    {
        @Override
        public void mouseClicked(MouseEvent e) 
        {
            if(!(e.getComponent() instanceof JButton)) return;
            
        }
        
    };
}
