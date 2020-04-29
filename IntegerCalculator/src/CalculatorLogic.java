/**
 * This calculator project is constructed for completion of Advanced Software
 * Development, ITEC 6130, Walden University, Spring 2019
 * 
 * Name: Martin Dwyer
 * Date: April 25, 2019
 */
import java.util.Arrays;


/**
 * This class provides the operational logic for a nine-digit integer calculator
 * 
 * @author Martin Dwyer
 */
public class CalculatorLogic {

    /**
     * The only attribute of objects in this class consists of a String, which is
     * the accumulation of char objects submitted through the user interface
     */
    private String eventString = "";

    /**
     * Default constructor for CalculatorLogic objects
     */
    public CalculatorLogic() {

    }

    /**
     * An instance method to set the event string 
     * 
     * @param eventString an integer math formula as text, e.g. '1+5'
     */
    public void setEventString(String eventString) {
        this.eventString = eventString;
    }

    /**
     * This is the primary method for handling calculator input.
     *
     * @param input, a char input from a button click on the calculator GUI
     * @return a String to be presented on the calculator screen
     */
    public String process(char input) {
        switch (input) {
            
            // Clear all input from the eventString attribute
            case 'c':
                this.eventString = "";
                break;

            // Clear only the last entry from the eventString attribute
            case 'e':
                this.eventString = eventString.substring(0, eventString.length() - 1);
                break;
                
            // Change sign on input
            case 'n':
                if (this.eventString.contains("=")) {
                    this.eventString = "";
                } else if (this.eventString.indexOf('-') == 0) {
                    this.eventString = this.eventString.substring(1, eventString.length());
                } else {
                    this.eventString = "-" + this.eventString;
                }
                break;

            // Calculation requested
            case '=':
                this.eventString = getTheSolution(this.eventString);
                break;
                
            // Handles all input not related to calcuating or clearing
            default:
                if (this.eventString.contains("=")) {
                    this.eventString = "" + input;
                } else {
                    this.eventString += input;
                }
                break;
        }
        return this.eventString;
    }

    /**
     * This class initiates the computation of the desired result 
     * 
     * @param eventString, the series of characters entered into the calculator
     * @return the original event String with the result concatenated on the end
     */
    private String getTheSolution(String eventString) {
        String solution = "";

        // Setting up object for the number of operations required and answer
        int answer = 0;
        int numberOfOps = 0;

        // Array opIndex will hold the index location of all operations in the request    
        int[] opIndex = new int[100];
        Arrays.fill(opIndex, 0);
        String operation = eventString;

        // Identify operations requested and store index locations in OpIndex
        for (int i = 1; i < operation.length(); i++) {
            if (operation.charAt(i) == '+' || operation.charAt(i) == '-' || operation.charAt(i) == '/' || operation.charAt(i) == '*') {
                opIndex[numberOfOps] = i;
                numberOfOps++;
            }
        }

        // The next several lines parse the next operation to be performed and perform the next operation
        // If there is an error parsing to integers, or dividing by zero, a message is produced for the user
        // and they are instructed to review and try again. This process is repeated for up to the number
        // of operations formerly identified
        int lastIndex = 0;
        int firstIndex = 0;
        String nextOp = "";
        boolean isError = false;
        boolean divisionByZero = false;
        for (int j = 0; j < numberOfOps; j++) {
            if (j == 0) {
                firstIndex = 0;
            } else {
                firstIndex = opIndex[j];
            }

            if (opIndex[j + 1] != 0) {
                lastIndex = opIndex[j + 1];

                if (j == 0) {
                    nextOp = operation.substring(firstIndex, lastIndex);
                } else {
                    nextOp = answer + operation.substring(firstIndex, lastIndex);
                }
            } else {
                if (j == 0) {
                    nextOp = operation.substring(firstIndex);
                } else {
                    nextOp = answer + operation.substring(firstIndex);
                }
            }

            try {
                answer = getNextOperation(nextOp);
            } catch (NumberFormatException e) {
                isError = true;
                break;
            } catch (ArithmeticException e) {
                divisionByZero = true;
                break;
            }
        }
        if (isError) {
            solution = eventString + " = INPUT ERROR";
        } else if (divisionByZero) {
            solution = eventString + " = DIVISION BY ZERO";
        } else {
            solution = eventString + " = " + answer;
        }

        return solution;
    }

    /**
     * This method parses an integer arithmetic operation from text form into
     * integers, computes the answer, and returns the result in integer form
     *
     * @param op an operation with two integers and one operand, in String form
     * @return the answer to the operation, an integer
     * @throws NumberFormatException if user has entered input which cannot be
     * parsed to an integer
     * @throws ArithmeticException if user has entered input which requires
     * division by zero
     */
    private int getNextOperation(String op) throws NumberFormatException, ArithmeticException {
        // Establish integer objects for each number an the answer
        int firstNumber = 0;
        int secondNumber = 0;
        int answer = 0;
        int subtract = 0;

        // Determine index of possible operators
        if (op.indexOf('-') == 0) {
            subtract = op.substring(1).indexOf('-') + 1;
        } else {
            subtract = op.indexOf('-');
        }

        int add = op.indexOf('+');
        int divide = op.indexOf('/');
        int multiply = op.indexOf('*');

        // Perform calculation based on operator identified
        if (add > 0) {
            try {
                firstNumber = Integer.parseInt(op.substring(0, op.indexOf('+')));
                secondNumber = Integer.parseInt(op.substring(op.indexOf('+') + 1, op.length()));
                answer = firstNumber + secondNumber;
            } catch (NumberFormatException e) {
                System.out.println(e);
                throw e;
            }
        } else if (subtract > 0) {
            try {
                if (op.indexOf('-') == 0) {
                    System.out.println("first number substring " + op.substring(1, subtract));

                    firstNumber = Integer.parseInt(op.substring(1, subtract)) * -1;
                } else {
                    firstNumber = Integer.parseInt(op.substring(0, subtract));
                }

                secondNumber = Integer.parseInt(op.substring(subtract + 1, op.length()));
                answer = firstNumber - secondNumber;
            } catch (NumberFormatException e) {
                
                throw e;
            }
        } else if (divide > 0) {
            try {
                firstNumber = Integer.parseInt(op.substring(0, op.indexOf('/')));
                secondNumber = Integer.parseInt(op.substring(op.indexOf('/') + 1, op.length()));
                answer = firstNumber / secondNumber;
            } catch (NumberFormatException e) {
                
                throw e;
            }
        } else if (multiply > 0) {
            try {
                firstNumber = Integer.parseInt(op.substring(0, op.indexOf('*')));
                secondNumber = Integer.parseInt(op.substring(op.indexOf('*') + 1, op.length()));
                answer = firstNumber * secondNumber;
            } catch (NumberFormatException e) {
                
                throw e;
            } catch (ArithmeticException f) {
                throw f;
            }
        }

        return answer;
    }

}
