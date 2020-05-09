package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * DataInterface provides testers access to the Java object files.  Methods exist 
 * for to retrieve data for each method and test case.  
 * 
 * @author Martin Dwyer
 */
public class DataInterface {
    
    /**
     * This method retrieves an ArrayList object from file
     * 
     * @param fileName, the file name of the object
     * 
     * @return a database as ArrayList<String[]> object
     * 
     */
    public static ArrayList<String[]> getDatabase(String fileName) {
        
        ArrayList<String[]> database = new ArrayList<String[]>();
        
        File folder = new File("test\\data\\");
        String folder_location = folder.toString() + "\\";
        File file = new File(folder_location + fileName.toString() + ".obj");
        
        try {
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream o = new ObjectInputStream(f);

	// Read objects
		database = (ArrayList<String[]>) o.readObject();
		
                o.close();
		f.close();
         
         } catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return database;
        
    }
    
    public static ArrayList<String[]> askForChar() {
        
        return getDatabase("askforchar");
        
    }
    
    public static ArrayList<String[]> askForString() {
        
        return getDatabase("askforstring");
        
    }
    
    public static ArrayList<String[]> charCount() {
        
        return getDatabase("charcount");
        
    }
    
    public static ArrayList<String[]> go() {
        
        return getDatabase("go");
        
    }
    
    public static ArrayList<String[]> invert() {
        
        return getDatabase("invert");
        
    }
    public static ArrayList<String[]> subString() {
        
        return getDatabase("substring");
        
    }
    public static ArrayList<String[]> toLowercase() {
        
        return getDatabase("tolowercase");
        
    }
    public static ArrayList<String[]> subStringTestData() {
        
        return getDatabase("substring");
        
    }
    public static ArrayList<String[]> uniqueOccurrences() {
        
        return getDatabase("unique");
        
    }
    public static ArrayList<String[]> vowelCase() {
        
        return getDatabase("vowelcase");
        
    }
    
    public static String get1000CharString() {

        String val = " !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~";

        return val;
    }

    public static String get1001CharString() {

        String char1001 = " !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~Z";

        return char1001;
    }
    
}
