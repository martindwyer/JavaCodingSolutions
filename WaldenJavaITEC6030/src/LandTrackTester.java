import java.util.Scanner;

public class LandTrackTester {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the length of first land tract:");
        int l1 = kb.nextInt();
        System.out.print("Enter the width of first land tract:");
        int w1 = kb.nextInt();
        LandTract t1 = new LandTract(w1,l1);
        System.out.print("Enter the length of second land tract:");
        int l2 = kb.nextInt();
        System.out.print("Enter the width of second land tract:");
        int w2 = kb.nextInt();
        LandTract t2 = new LandTract(w2,l2);
        System.out.println(t1.toString() +" and area " + t1.area());
        System.out.println(t1.toString() +" and area " + t1.area());
        if(t1.equals(t2)) {
            System.out.println("The two tracts have the same size.");
        } else {
            System.out.println("The two tracts do not have the same size.");
        }



    }
}
