import java.io.*;   // provides stream classes
import java.util.*; // for Scanner & Exception classes

/**
 * CSC 142:  Homework #2
 * 
 * A program in Java code to read student names and test scores in from 
 * a file, compile them to calculate the average test score, and assign
 * final grades based on stated grading scale.  
 * 
 * Program is inteded to read data from file input by the user.  The 
 * user will be notified if the file is not found and prompted for
 * another file name.  Output for this program is printed to the text
 * file studentResults.txt
 * 
 * @author Martin Dwyer
 * @version 10/21/2017
 */
public class StudentData {
    public static void main (String [] args) {
        final int TESTS = 4;        // Constant: # of tests per student
        final int STUDENTS = 25;    // Constant: # of students in class
        String name;                // Variable used to read in name string
        String firstName = null;    // First name of each student
        String lastName = null;     // Last name of each student
        String printName = null;    // Name in lastName, firstName format
        String test;                // Variable used to read in test score
        String grade;               // Assigned letter grade based on scale
        int sum = 0;                // Sum of student scores
        int i = 0;                  // Counter variables used below
        double sumScores = 0.0;         // Sum of scores for each student
        double studentAverage = 0.0;    // Average of the student test scores
        double[] scores = {0,0,0,0};    // Student scores as integer data
        double[] classSumT = {0,0,0,0}; // Class sum of scores
        double[] classAvgT = {0,0,0,0}; // Class average by test
        boolean fileNotOpen = true;     // file opening loop control variable
        String studentData=null;        // To store student data file name
        String resultData=null;         // To store results data file name
        Scanner kb = new Scanner(System.in);  // Scanner object user input
        FileInputStream in = null;   // stream object for reading input file
        FileOutputStream out = null; // stream object for output to file
        Scanner inFile;              // object for reading student data file
        PrintWriter outFile;         // object for writing data out to file

        // The following section obtains the student data file name from the 
        // user, verifies the existence of the file, and offers opportunity for
        // the user to try again is the file name entered incorrectly.

        while (fileNotOpen) {
            System.out.println("Enter a file name with your student data:");
            try  {
                studentData = kb.nextLine();
                in = new FileInputStream(studentData); 
                fileNotOpen = false;                  
            }
            catch (FileNotFoundException e){
                System.out.println("The file " + studentData + 
                                                    " is invalid, try again");
            }
        }
        inFile = new Scanner(in);  
        
        // The following section obtains the desired output file name from the 
        // user, verifies the existence of the file, and offers opportunity for
        // the user to try again is the file name entered incorrectly.

        fileNotOpen = true;
        while (fileNotOpen) {
            try {
                out = new FileOutputStream("studentResults.txt");
                fileNotOpen = false;
            }
            catch (FileNotFoundException e) {
                System.out.println("Invalid output file. Program terminating.");
                System.exit(1);
            }
        }
        outFile = new PrintWriter(out);

        // The following section reads in student data, processes the data,
        // calculating the average test scores and assigned letter grade for
        // each student.  Output is writting both to the screen and to the
        // specified output file.  

        // Printing headings for the student results output
        System.out.println("");
        System.out.printf("%-20s%-20s%-20s\n","Student Name",
                                           "Test Score Average","Letter Grade");
        outFile.printf("%-20s%-20s%-20s\n","Student Name",
                                           "Test Score Average","Letter Grade");

        while (inFile.hasNext()) {
            for (i=0; i < 2; i++) {             // Gathering student name data
                name = inFile.next();           // from the data now accessible
                if (i==0) {                     // through the inFile object
                    firstName = name;           // Getting name data first
                } else {
                    lastName = name;
                }
                printName = lastName + ", " + firstName;
            }
            for (i=0; i<4; i++) {               // Now gathering test data
                scores[i] = Double.parseDouble(inFile.next());
                sumScores += scores[i];
                classSumT[i] += scores[i];
            }
            
            // Calculate student average and assign grade
            studentAverage = sumScores / TESTS; 
            
            // The control structure for assigning grades cascades down starting
            // from the highest possible grades to the lowest, making it 
            // possible to capture the correct grade and move on asap.
            if (studentAverage >= 91) {
                grade = "A";
            } 
            else if (studentAverage >= 90) {
                grade = "A-";
            }
            else if (studentAverage >= 89) {
                grade = "B+";
            }
            else if (studentAverage >= 81) {
                grade = "B";
            }
            else if (studentAverage >= 80) {
                grade = "B-";
            }
            else if (studentAverage >= 79) {
                grade = "C+";
            }
            else if (studentAverage >= 71) {
                grade = "C";
            }
            else if (studentAverage >= 70) {
                grade = "C-";
            }
            else if (studentAverage >= 69) {
                grade = "D+";
            }
            else if (studentAverage >= 61) {
                grade = "D";
            }
            else if (studentAverage >= 60) {
                grade = "D-";
            }
            else {
                grade = "F";
            }

            // printing results each time around the while loop to capture 
            // each student's grade before moving on to the class averages.
            System.out.printf("%-25s%-20.1f%-20s\n",printName,
                                                    studentAverage,grade);
            outFile.printf("%-25s%-20.1f%-20s\n",printName,
                                                    studentAverage,grade);

            // resetting the student accumulator variables before getting 
            // the next student data
            sumScores = 0.0;
            studentAverage = 0.0;
        }
        
        // Calculate and output test score averages for each of 4 tests
        for (i=0; i < 4; i++) {
            classAvgT[i] = classSumT[i]/STUDENTS;
        }
        
        // Outputing data to screen and file with instructions where the
        // file can be found.
        System.out.println("");
        System.out.println("");
        System.out.println("Class Averages");
        
        System.out.printf("%10s%10s%10s%10s\n","Test 1","Test 2","Test 3",
                                                                 "Test 4");
        System.out.printf("%10.1f%10.1f%10.1f%10.1f\n",classAvgT[0],
                                   classAvgT[1],classAvgT[2],classAvgT[3]);
        System.out.println("");
        System.out.println(""); 
        System.out.println("Report has been printed to studentResults.txt"); 

        outFile.println("");
        outFile.println("");
        outFile.println("Class Averages");
      
        outFile.printf("%10s%10s%10s%10s\n","Test 1","Test 2","Test 3","Test 4");
        outFile.printf("%10.1f%10.1f%10.1f%10.1f\n",classAvgT[0],classAvgT[1],
                                                      classAvgT[2],classAvgT[3]);
        outFile.println("");
        outFile.println(""); 
        outFile.println("This report can be found in studentResults.txt");
        
        // Close files:
        inFile.close();
        outFile.close();
    }
}
