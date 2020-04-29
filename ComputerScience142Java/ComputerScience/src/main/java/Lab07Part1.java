public class Lab07Part1 {
    public static void main(String [] args) {
        int num = 2;
        int sum = 0;
        while (num <= 20) {
            sum += num;
            if (num < 20)
                System.out.print (num + " + ");
            else 
                System.out.print ("20 = " + sum);
            num += 1;
        }
    }
}