import java.io.*;   
import java.util.*; 

/**
 * Lab 6: Part 2
 * Sending random numbers to a text file
 * @author Martin Dwyer
 * @version 10/14/2017
 */
public class Lab06Part2 {
    public static void main (String [] args) {
        boolean fileNotOpen = true;         // loop control variable
                                    
        Scanner kb = new Scanner(System.in); // for user interaction -
        
        double[] fTemps = new double[50];
        double[] wSpeeds = new double[50];
        int i = 0;
        
        PrintWriter outFile;    
        FileOutputStream out = null;

        while (fileNotOpen) {
            try {
                out = new FileOutputStream("weatherData.txt");
                fileNotOpen = false;
            }
            catch (FileNotFoundException e) {
                System.out.println("Could not open file; program exiting");
                System.exit(1);
            }
        }

        outFile = new PrintWriter(out);
        
        while (i<50) {
            fTemps[i] = (Math.random()*80) - 30.0;
            wSpeeds[i] = (Math.random()*50) + 0.0;
 
            outFile.printf("%3d%10.2f%10.2f\n",i,fTemps[i],wSpeeds[i]);
                        
            i ++;
            }
            
        outFile.close();
        
        }
    }
    