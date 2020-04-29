
public class DoubleLessTrouble {
    public static void main (String [] args) {
        double n1 = 0.1;
        double n2 = 1/10.0;
        int fudgeFactor = 1000;
        boolean judge = (int)n1*fudgeFactor == (int)n2*fudgeFactor;
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        System.out.println("judge = " + judge);
        n1 = n1 * 0.1;
        n2 = n2 / 10.0;
        judge = (int)n1*fudgeFactor == (int)n2*fudgeFactor;
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        System.out.println("judge = " + judge);
    }
}
