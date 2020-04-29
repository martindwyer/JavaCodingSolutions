/**
 * This calculator project is constructed for completion of Advanced Software
 * Development, ITEC 6130, Walden University, Spring 2019
 *
 * Name: Martin Dwyer
 * Date: April 25, 2019
 */
import java.util.Scanner;

/**
 * This class provides a text-based user interface for the CalculatorLogic class.
 * The text interface requires only that the user enter a valid integer operation.
 *
 * @author Martin Dwyer
 */
public class TextCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorLogic logic = new CalculatorLogic();

        String input = "";
        String inputClean = "";
        String answer = "";
        boolean keepPlaying = true;

        System.out.println(getWelcomeMessage());
        while (keepPlaying) {
            System.out.print("Enter a valid integer math operation or 'n' to quit: ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("n")) {
                keepPlaying = false;
            } else {
                inputClean = input.replaceAll("=","");
                inputClean = inputClean.replaceAll(" ","");
                
                logic.setEventString(inputClean);
                answer = logic.process('=');
                System.out.println("Completed solution: " + answer + "\n\n");
            }
        }
        System.out.println("Thank you for using our calculator.  Good bye.");

    }

    private static String getWelcomeMessage() {
        String output = "";
        output += "Welcome to the calculator text based interface!\n\n";
        output += "This calculator interface only requires the user to\n";
        output += "enter a formula to get the desired results.  There are\n";
        output += "two requirements:\n\n";
        output += "\t1. You must use integers (e.g. 1,2,3...).\n";
        output += "\t2. Use the following operators:\n\n";
        output += "\tAddition (+)\n";
        output += "\tSubtraction (-)\n";
        output += "\tMultiplication (*)\n";
        output += "\tDivision (/)\n";
        output += "Examples:\n";
        output += "\t1 plus 4 is '1+4'\n";
        output += "\t15 minus 4 is '15-4'\n";
        output += "\t7 times 4 is '7*4'\n";
        output += "\t8 divided by 4 is '8/4\n";
        output += "\tMultiple operations are ok, e.g. '1+4+15-4/2'\n\n";

        return output;

    }

}
