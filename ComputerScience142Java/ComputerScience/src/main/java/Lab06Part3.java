import java.io.*;   // provides stream classes
import java.util.*; // for Scanner & Exception classes

/**
 * Martin Dwyer
 * Lab 06: Part 3
 * Reading Random Temps from File, Processing, and Print Results
 * @version 10/12/2017
 */
public class Lab06Part3 {
    public static void main (String [] args) {
        boolean fileNotOpen = true;         // loop control variable
                                    
        Scanner kb = new Scanner(System.in); // for user interaction -
        
        int[] days = new int[50];
        double[] fTemps = new double[50];
        double[] wSpeeds = new double[50];
        double[] cTemps = new double[50];
        double[] wChills = new double[50];
        
        int i = 0;

        String input;
        String inputS1;
        String inputS2;
        String inputS3;
        
        Scanner inFile;     
        FileInputStream in = null;  
        
        while (fileNotOpen) {
            try  {
                in = new FileInputStream("weatherData.txt");
                fileNotOpen = false;
            }
            catch (FileNotFoundException e){
                System.out.println("Could not open file; program exiting");
                System.exit(1);
            }
        }

        inFile = new Scanner(in);
        
        System.out.printf("%5s%12s%12s%12s%12s\n","Day","Degrees F","Degrees C","Wind Speed","Wind Chill");
        
        while (i < 50) {
            input = inFile.nextLine();
            inputS2 = input.substring(3,13);
            inputS3 = input.substring(13,23);
            
            fTemps[i] = Double.parseDouble(inputS2);
            wSpeeds[i] = Double.parseDouble(inputS3);
            
            cTemps[i] = (5.0/9.0)*(fTemps[i] - 32);
            wChills[i] = 35.74 + (0.6215*fTemps[i]) - (35.75*(Math.pow(wSpeeds[i],0.16))) + 0.4275*fTemps[i]*(Math.pow(wSpeeds[i],0.16));

            System.out.printf("%5d%12.2f%12.2f%12.2f%12.2f\n",(i+1),fTemps[i],cTemps[i],wSpeeds[i],wChills[i]);
            
            i++;
            }
        inFile.close();
        }
    }
