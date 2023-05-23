package mp5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.sound.sampled.DataLine;

public class Utilities 
{
    public static String[] months = {
    "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
    };
    
    public static HashMap<String, String> getLoginCredentials(String address)
    {
        File file = new File(address);

        if(!file.exists())
        {
            System.err.println("GETTING LOGIN CREDENTIALS ERROR: File / Directory does not exist.");
            System.exit(1);
        }

        BufferedReader reader;
        ArrayList<String> tempBuffer = new ArrayList<>();

        try
        {
            reader = new BufferedReader(new FileReader(file));
            while(true)
            {
                String buffer = reader.readLine();
                if(buffer == null)
                    break;
                
                tempBuffer.add(buffer);            
            }
            reader.close();
        }
        catch(FileNotFoundException fnf)
        {
            System.err.println("File not found.");
            System.exit(1);
        }
        catch(IOException io)
        {
            System.err.println("IOException has occured.");
            System.exit(1);
        }

        HashMap<String, String> uMap = new HashMap<>();
        for(int i = 0; i < tempBuffer.size(); ++i)
        {
            if(i % 2 == 0)
                uMap.put(tempBuffer.get(i), tempBuffer.get(i+1));
        }
        
        return uMap;
    }
    
    public static void writeToCSV(ArrayList<Person> list)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime d = LocalDateTime.now();
        String fileName = dtf.format(d)
                .replace("/", "")
                .replace(" ", "")
                .replace(":", "");
        
        File f = new File(fileName+".csv");
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(f)))
        {
            for(Person p : list)
            {
                writer.write(p.getName() + "," + p.getBDay() + "," + p.getAge() + "\n");
            }
        } catch (Exception e) 
        {
            System.err.println("Error Writing To File.");
        }
        
        System.out.println(f + " saved");
    }
    
    public static LinkedHashMap<String, Integer> getMonthsMap()
    {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        
        for(int i = 0; i < months.length; ++i )
        {
            map.put(months[i], (i+1));
        }
        
        return map;
    }
}
