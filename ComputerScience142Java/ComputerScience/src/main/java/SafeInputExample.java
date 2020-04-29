
import java.util.*; // for Scanner & Exception classes

public class SafeInputExample {
    public static void main(String [] args) {
        int num=0;      // number to be read from keyboard
        String input;   // holds raw input to transform
        Scanner kb = new Scanner(System.in);
        boolean checkInput = true; 
        // loop control variable; true as long as
        // input needs to be validated
        while (checkInput) {
            System.out.print("Enter the important number: ");
            input = kb.nextLine();
            try {
                num = Integer.parseInt(input);
                checkInput = false;
            }
            catch (NumberFormatException e) {
                System.out.println (input + " invalid. Try again.");
            }
        }
        System.out.printf("The important number is %d\n", num);
        System.out.printf("Its square is %d\n", (num * num));
        System.out.printf("Its square root is %.2f\n", Math.sqrt(num));
    }
}
