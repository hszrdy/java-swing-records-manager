package mp5;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Person 
{
    private String name;
    private LocalDate birthDay;
    private LocalDate dateToday;
    private int age;
    private Period p;
    
    public Person() {}
    public Person(String name, LocalDate birthDay)
    {
        this.name = name;
        setBirthDay(birthDay);
        
    }
    
    public void setBirthDay(LocalDate date)
    {
        birthDay = date;
        computeAge();
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    private void computeAge()
    {
        p = Period.between(birthDay, dateToday);
        age = p.getYears();
    }
    
    public String toString()
    {
        return name + "\t" + birthDay.toString() + "\t" + age;
    }
    
}
