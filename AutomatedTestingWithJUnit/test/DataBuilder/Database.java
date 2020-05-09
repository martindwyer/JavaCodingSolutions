package DataBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Martin Dwyer
 */
public class Database {
    
    
    public static void main(String[] args) {
        
        ArrayList<String[]> subStringData = SubStringTestData.getTestData();
        writeDatabase(subStringData,"substring");
        
        ArrayList<String[]> askForCharData = AskForCharTestData.getTestData();
        writeDatabase(askForCharData,"askforchar");
        
        ArrayList<String[]> askForStringData = AskForStringTestData.getTestData();
        writeDatabase(askForStringData,"askforstring");
        
        ArrayList<String[]> charCountData = CharCountTestData.getTestData();
        writeDatabase(charCountData,"charcount");
        
        ArrayList<String[]> goData = GoTestData.goTestData();
        writeDatabase(goData,"go");
        
        ArrayList<String[]> invertStringData = InvertStringTestData.getTestData();
        writeDatabase(invertStringData,"invert");
        
        ArrayList<String[]> toLowercaseData = ToLowerCaseTestData.getTestData();
        writeDatabase(toLowercaseData,"tolowercase");
        
        ArrayList<String[]> uniqueData = UniqueOccurrencesTestData.getTestData();
        writeDatabase(uniqueData,"unique");
        
        
        ArrayList<String[]> vowelCaseData = VowelCaseTestData.getVowelCaseData();
        writeDatabase(vowelCaseData,"vowelcase");
               
    }
    
    
    
    public static void writeDatabase(ArrayList<String[]> database, String fileName) {
        
            File folder = new File("test\\data\\");

        try {
            
            
            String folder_location = folder.toString() + "\\";
            File file = new File(folder_location + fileName.toString() + ".obj");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            
            o.writeObject(database);
            
            o.close();
            f.close();
            
        } catch (IOException e) {
            System.err.println("Cannot find file!");
        }
    }
        
        
    
    
    public static ArrayList<String[]> readDatabase() {
        
        ArrayList<String[]> database =  new ArrayList<String[]>();
        
        
        return database;
    }

    public static String get1000CharString() {

        String val = " !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~";

        return val;
    }

    public static String get1001CharString() {

        String char1001 = " !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~ !\"#$%&'()*+,-./0123456789 :;<=>?@ABCDEF GHIJKLMNOP QRSTUVWXYZ [\\]^_`abcdef ghijklmnopqrstuvwxyz{|}~Z";

        return char1001;
    }

    public static ArrayList<String[]> getCharCountTestData() {

        return CharCountTestData.getTestData();
    }
    
    public static ArrayList<String[]> getSubStringTestData() {

        return SubStringTestData.getTestData();
    }

    public static ArrayList<String[]> getGoTestData() {

        ArrayList<String[]> testData = GoTestData.goTestData();

        return testData;
    }

    public static ArrayList<String[]> getAskForStringTestData() {

        ArrayList<String[]> testData = AskForStringTestData.getTestData();

        return testData;
    }

    public static ArrayList<String[]> getCharTestData() {

        ArrayList<String[]> testData = AskForCharTestData.getTestData();

        return testData;
    }

    public static ArrayList<String[]> getUniqueOccurrencesTestData() {

        ArrayList<String[]> testData = UniqueOccurrencesTestData.getTestData();

        return testData;
    }

    public static ArrayList<String[]> getVowelCaseTestData() {

        return VowelCaseTestData.getVowelCaseData();

    }
    
    public static ArrayList<String[]> getToLowerCaseTestData() {

        return ToLowerCaseTestData.getTestData();

    }
    
    public static ArrayList<String[]> getInvertStringData() {

        return InvertStringTestData.getTestData();

    }
    

}
