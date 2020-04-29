
public class FormatDemo {	
	public static void main (String [] args) {
        double dtst = Math.random();            // random double value 0 .. 1
        int itst = (int)(dtst * 10000) % 900;   // random int value 0 .. 899
        System.out.println("*** Double formatting demo ***");
        System.out.println("dtst=" + dtst);
        System.out.printf("value of dtst is %.2f and also %.20f\n", dtst, dtst);
        System.out.println("*** Field width demo ***");
        System.out.printf("%10s%10s\n%10d%10.6f\n", "int value", "double", itst, dtst);
        dtst = Math.random(); 
        itst = (int)(dtst * 10000) % 900;
        System.out.printf("%10s%10s\n%10d%10.6f\n", "int value", "double", itst, dtst);
        System.out.printf("%10s%10s\n%10d%10.6f\n", "int value", "double", itst, dtst);
        dtst = Math.random(); 
        itst = (int)(dtst * 10000) % 900;
        System.out.printf("%10s%10s\n%10d%10.6f\n", "int value", "double", itst, dtst);
    }
}
