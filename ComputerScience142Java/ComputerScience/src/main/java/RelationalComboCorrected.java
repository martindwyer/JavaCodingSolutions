
import java.util.Random;
public class RelationalComboCorrected {
    public static void main(String [] args) {
        int x, y, z;
        Random rg = new Random();
        x = rg.nextInt();
        y = rg.nextInt();
        z = rg.nextInt();
        System.out.printf("x=%d\ny=%d\nz=%d\n", x, y, z);
        boolean truth = x > y && x > z;
        System.out.println("Truth is revealed to be: " + truth);
    }
}