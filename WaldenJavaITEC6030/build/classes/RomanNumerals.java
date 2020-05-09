import java.util.Scanner;

public class RomanNumerals {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int numberInput = 0;
        boolean validInput = false;
        System.out.print("Enter a number in the range of 1 - 10: ");
        while (!validInput) {
            numberInput = kb.nextInt();
            if (numberInput <= 10 && numberInput >= 1) {
                validInput = true;
            }else {
                System.out.println("Enter a number in the range of 1 - 10: ");
            }
        }
        switch(numberInput) {
            case 1:
            System.out.println("I");
            break;
            
            case 2: 
            System.out.println("II");
            break;
            
            case 3:
            System.out.println("III");
            break;    
            
            case 4:
            System.out.println("IV");
            break;
            
            case 5: 
            System.out.println("V");
            break;
            
            case 6:
            System.out.println("VI");
            break;
            
            case 7:
            System.out.println("VII");
            break;
            
            case 8:
            System.out.println("VIII");
            break;
            
            case 9:
            System.out.println("IX");
            break;
            
            case 10:
            System.out.println("X");
            break;
           
        }
    }
    
}
