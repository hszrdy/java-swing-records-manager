package mp5;

import java.util.Date;

public class Person 
{
    private String name;
    private Date birthDay;
    private int age;
    
    public Person() {}
    public Person(String name, Date birthDay)
    {
        this.name = name;
        this.birthDay = birthDay;
    }
    
    public void setBirthDay(Date date)
    {
        birthDay = date;
        age = computeAge();
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
    
    private int computeAge()
    {
        //to be implemented
        return age;
    }
    
    public String toString()
    {
        return name + " " + birthDay.toString() + " " + age;
    }
    
}
