package mp5;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.JButton;

public class RecordsController 
{
    private CentralRecordsView viewmodel;
    private Person personRecord;
    private RemoveRecordsView removeRecordsView;
    private AddRecordsView addRecordsView;
    
    private ArrayList<Person> listOfPersons = new ArrayList<>();
    private LinkedHashMap<String, Integer> monthMap = Utilities.getMonthsMap();
    
    public RecordsController(CentralRecordsView viewmodel, Person personRecord)
    {
        this.viewmodel = viewmodel;
        this.personRecord = personRecord;
        removeRecordsView = new RemoveRecordsView();
        addRecordsView = new AddRecordsView();
        
        viewmodel.openRemoveRecBtnListener(openRemoveRecordBtn);
        viewmodel.openAddRecBtnListener(openAddRecordBtn);
        viewmodel.exportBtnListener(exportBtn);
        
        removeRecordsView.addActionGoBtnListener(removalGoBtn);
        removeRecordsView.addActionMoreBtnListener(removalMoreBtn);
        removeRecordsView.addBackBtnListener(backBtnR);
        
        addRecordsView.addActionGoBtnListener(addGoBtn);
        addRecordsView.addActionMoreBtnListener(addMoreBtn);
        addRecordsView.addBackBtnListener(backBtnA);
    }
    
    public void clearRecordsView()
    {
        viewmodel.clearRecordArea();
    }
    
    public void populateRecordsView()
    {
        for (Person person : listOfPersons) 
        {
            System.out.println(person.toString());
            viewmodel.appendRecord(person.toString());
        }
    }
    
    public void updateRecordView()
    {
        clearRecordsView();
        populateRecordsView();
        viewmodel.updateFrame();
        System.out.println(listOfPersons);
    }
    
    public int indexOf(String name)
    {
        for(Person p : listOfPersons)
        {
            if (p.getName().equals(name))
                return listOfPersons.indexOf(p);
        }
        
        return -1;
    }
    //prompt for removing record
    MouseAdapter openRemoveRecordBtn = new MouseAdapter() 
    {
        @Override
        public void mouseClicked(MouseEvent e) 
        {
            if(!(e.getComponent() instanceof JButton)) return;
            
            removeRecordsView.setVisible(true);
            
        }
        
    };
    //prompt for adding record
    MouseAdapter openAddRecordBtn = new MouseAdapter() 
    {
        @Override
        public void mouseClicked(MouseEvent e) 
        {
            if(!(e.getComponent() instanceof JButton)) return;
            
            addRecordsView.setVisible(true);
        }
        
    };
    //export record
    MouseAdapter exportBtn = new MouseAdapter() 
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(!(e.getComponent() instanceof JButton)) return;
            Utilities.writeToCSV(listOfPersons);
            viewmodel.fileSavedDialogue();
        }
    };
    //close record remover from back btn
    MouseAdapter backBtnR = new MouseAdapter() 
    {
        @Override
        public void mouseClicked(MouseEvent e) 
        {
            removeRecordsView.dispose();
        }
        
    };
    //close record adder from back btn
    MouseAdapter backBtnA = new MouseAdapter() 
    {
        @Override
        public void mouseClicked(MouseEvent e) 
        {
            addRecordsView.dispose();
        }
        
    };
    //remove and return back
    MouseAdapter removalGoBtn = new MouseAdapter() 
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(!(e.getComponent() instanceof JButton)) return;
            
            String buffer = removeRecordsView.getNameForRemoval();
            int index = indexOf(buffer);
            
            try 
            {
                if(index == -1)
                    throw new IllegalArgumentException();
                
            } catch (Exception ex) 
            {
                removeRecordsView.displayNameNotFound();
                return;
            }
            
            if(buffer.equals(null)) return;
            
            listOfPersons.remove(index);
            updateRecordView();
            removeRecordsView.dispose();
        }
    };
    //remove but do not return back
    MouseAdapter removalMoreBtn = new MouseAdapter() 
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(!(e.getComponent() instanceof JButton)) return;
            
            String buffer = removeRecordsView.getNameForRemoval();
            int index = indexOf(buffer);
            
            try 
            {
                if(index == -1)
                    throw new IllegalArgumentException();
                
            } catch (Exception ex) 
            {
                removeRecordsView.displayNameNotFound();
                return;
            }
            
            if(buffer.equals(null)) return;
            
            listOfPersons.remove(index);
            updateRecordView();
        }
    };
    //add and return back
    MouseAdapter addGoBtn = new MouseAdapter() 
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(!(e.getComponent() instanceof JButton)) return;
            
            String name = addRecordsView.getName();
            int mm = monthMap.get(addRecordsView.getMonth());
            int yyyy = Integer.parseInt(addRecordsView.getYear());
            int dd = Integer.parseInt(addRecordsView.getDay());
            LocalDate bday = LocalDate.of(yyyy, mm, dd);
            
            Person p = new Person(name, bday);
            
            try
            {
                if(yyyy > addRecordsView.MAX_YEAR)
                    throw new IllegalArgumentException();
                if(yyyy < addRecordsView.MIN_YEAR)
                    throw new IllegalArgumentException();
            }
            catch(Exception ex)
            {
                addRecordsView.showInvalidDateError();
                return;
            }
            
            
            try 
            {
                if(name.isBlank())
                    throw new IllegalArgumentException();
                if(name.equals(null)) 
                    throw new IllegalArgumentException();
                
            } 
            catch (Exception ex) 
            {
                addRecordsView.showInvalidNameError();
                return;
            }
            
            listOfPersons.add(p);
            updateRecordView();
            
            addRecordsView.dispose();
        }
    };
    //add but do not return back
    MouseAdapter addMoreBtn = new MouseAdapter() 
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(!(e.getComponent() instanceof JButton)) return;
            
            String name = addRecordsView.getName();
            int mm = monthMap.get(addRecordsView.getMonth());
            int yyyy = Integer.parseInt(addRecordsView.getYear());
            int dd = Integer.parseInt(addRecordsView.getDay());
            LocalDate bday = LocalDate.of(yyyy, mm, dd);
            
            Person p = new Person(name, bday);
            
            try
            {
                if(yyyy > addRecordsView.MAX_YEAR)
                    throw new IllegalArgumentException();
                if(yyyy < addRecordsView.MIN_YEAR)
                    throw new IllegalArgumentException();
            }
            catch(Exception ex)
            {
                addRecordsView.showInvalidDateError();
                return;
            }
            
            
            try 
            {
                if(name.isBlank())
                    throw new IllegalArgumentException();
                if(name.equals(null)) 
                    throw new IllegalArgumentException();
                
            } 
            catch (Exception ex) 
            {
                addRecordsView.showInvalidNameError();
                return;
            }
            
            
            listOfPersons.add(p);
            updateRecordView();
        }
    };
}
