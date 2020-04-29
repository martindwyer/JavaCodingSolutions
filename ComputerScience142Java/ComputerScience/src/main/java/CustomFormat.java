
/*********************************** NEW FILE ******************************/
import java.util.Scanner;
public class CustomFormat {
    public static void main (String [] args) {
        double num = Math.random()*10;
        int digs;
        int wid;
        Scanner kb = new Scanner(System.in);
        System.out.println("Your random value is " + num);
        System.out.print("How many significant digits do you want? ");
        digs = Math.abs(kb.nextInt());
        System.out.print("What is the field width? ");
        wid = Math.abs(kb.nextInt());
        String format = new String("%" + wid + "." + digs + "f");
        System.out.println("Fixed decimal format:");
        System.out.printf(format, num);
        System.out.println();
        format = "%" + wid + "." + digs + "e";
        System.out.println("Scientific notation:");
        System.out.printf(format, num);
        System.out.println();
        format = "%" + wid + "." + digs + "g";
        System.out.println("format string: " + format);
        System.out.println("System chooses format:");
        System.out.printf(format, num);
        System.out.println();
        System.out.printf("Right justified" + format + " in context\n", num);
        format = "%" + "-" + wid + "." + digs + "g";
        System.out.printf("Left justified " + format + "in context\n", num);
    }
}
