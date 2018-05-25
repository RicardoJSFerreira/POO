import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;

public class Save_State
{
    public static void WriteHashMap(HashMap<Integer, ?>l, int ID){
        
        FileOutputStream fileoutput = null;
        ObjectOutputStream objectoutput = null;
        
        try{
            
           if(ID == 1) fileoutput = new FileOutputStream("C_Individuais.txt");
           if(ID == 2) fileoutput = new FileOutputStream("C_Empresas.txt");
        
           objectoutput = new ObjectOutputStream(fileoutput);
           
           objectoutput.writeObject(l);
           objectoutput.flush();
           objectoutput.close();
        }
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
    
        System.out.println("HashMap " + ID + " saved");
    }
    
       public static void ReadHashMap(HashMap<Integer, ?> l, int ID)  {
            HashMap newHash = new HashMap();
            
            FileInputStream fileinput = null;
       ObjectInputStream objectinput = null;
       
        try{
            
            
            if (ID == 1) fileinput = new FileInputStream("C_Individuais.txt");
            if (ID == 2) fileinput = new FileInputStream("C_Empresas.txt");
                
                
            objectinput = new ObjectInputStream(fileinput);
            
            
        
            newHash = (HashMap<String, ?>) objectinput.readObject();
            if (!(newHash instanceof HashMap)){
                newHash = null;
                System.out.println("ERROR - input object is not Hashmap");
            }
            objectinput.close();
        }
       catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
       }
       catch (IOException ioex) {
            ioex.printStackTrace();
       }
       catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
       }

       
       l.putAll(newHash);
    }
    
    
       }

    
    
    
    
    
    
    
    
    
