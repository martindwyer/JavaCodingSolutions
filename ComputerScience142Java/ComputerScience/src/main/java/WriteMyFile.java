import java.io.*;
import java.util.*;
public class WriteMyFile {
    public static void main (String [] args) throws FileNotFoundException {
        Scanner kb = new Scanner(System.in);
        String fName, s;
        boolean append = true;
        System.out.print("Enter output file name:");
        fName = kb.nextLine();
        System.out.print("Do you want to append or overwrite? (A/O): ");
        s = kb.nextLine();
        PrintWriter pw = null;
        char dec = s.charAt(0);
        if (dec == 'O' || dec == 'o')
            append = false;
        pw = new PrintWriter(new FileOutputStream(fName, append));
        System.out.println("Here it is on the screen");
        pw.println("Boo!");
        pw.close();
    }
}