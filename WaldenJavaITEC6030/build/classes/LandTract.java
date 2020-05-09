import java.util.Scanner;

public class LandTract {
    private int length;
    private int width;

    public LandTract(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int area() {
        return this.length * this.width;

    }

    public boolean equals(LandTract t) {

        if(((this.length == t.length) && (this.width == t.width)) || ((this.length == t.width) && (this.width == t.length)))  {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "LandTract with length "+this.length+", width "+this.width;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter length of first land tract:");
        int l1 = kb.nextInt();
        System.out.print("Enter width of first land tract:");
        int w1 = kb.nextInt();
        LandTract t1 = new LandTract(l1,w1);
        System.out.print("Enter length of second land tract:");
        int l2 = kb.nextInt();
        System.out.print("Enter width of second land tract:");
        int w2 = kb.nextInt();
        LandTract t2 = new LandTract(l2,w2);
        System.out.println(t1.toString() +", and area " + t1.area());
        System.out.println(t2.toString() +", and area " + t2.area());
        if(t1.equals(t2)) {
            System.out.println("The two tracts have the same size.");
        } else {
            System.out.println("The two tracts do not have the same size.");
        }



    }

}
