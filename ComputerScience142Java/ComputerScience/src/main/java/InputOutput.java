import java.io.*;   // provides stream classes
import java.util.*; // for Scanner & Exception classes

/**
 * Demo class to illustrate reading from and writing
 * out to text files
 * @author Cate Sheller
 * @version 10/3/2012
 */
public class InputOutput {
    public static void main (String [] args) {
        boolean fileNotOpen = true; // loop control variable
                                    // to ensure that a valid
                                    // filename is entered by
                                    // user
        Scanner kb = new Scanner(System.in); // for user interaction -
                                             // comment out if file name(s)
                                             // hard-coded
        String input;       // used for all input in program
        Scanner inFile;     // object for reading data from file
        PrintWriter outFile;    // object for writing data out to file
        FileInputStream in = null;  // stream objects for opening files
        FileOutputStream out = null;
        
        // open input file; shows both versions, with interactive 
        // version in comments
        
        while (fileNotOpen) {
            // System.out.println("Enter full path name of input file below:");
            // input = kb.nextLine();
            try  {
                // in = new FileInputStream(input);
                in = new FileInputStream("InAndOut.java");
                fileNotOpen = false;
            }
            catch (FileNotFoundException e){
               // System.out.println(input + " not valid.  Please try again.");
                System.out.println("Could not open file; program exiting");
                System.exit(1);
            }
        }

        inFile = new Scanner(in);
        








        // repeat process for output file 
        fileNotOpen = true;
        while (fileNotOpen) {
           // System.out.println("Enter full path name of output file below:");
           // input = kb.nextLine();
            try {
                // out = new FileOutputStream(input);
                out = new FileOutputStream("result.txt");
                fileNotOpen = false;
            }
            catch (FileNotFoundException e) {
						// System.out.println(input + " not valid.  Please try again.");
                System.out.println("Could not open file; program exiting");
                System.exit(1);
            }
        }
        outFile = new PrintWriter(out);
        
        // Read data from input file & write out to output file
        // Just for variety, I'm only going to write out lines that end
        // in semicolons, and I'm right-justifying all output
        
        while (inFile.hasNextLine()) {
            input = inFile.nextLine();
            int end = input.length()-1;
            if (end > 0 && input.charAt(end) == ';') {
                outFile.printf("%80s\n", input);
                // Writing to screen so programmer can see what's happening;
                // Can eliminate this line once program is working properly
                System.out.printf("%80s\n", input);
            }
        }
        
        // Close files:
        inFile.close();
        outFile.close();
    }
}
