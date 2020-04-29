import java.util.Scanner;
public class GuessingGame
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        boolean keepPlaying = true; 
        System.out.println("Let's play a guessing game!");
        while (keepPlaying) 
        {
            boolean validInput; 
            int number = 0;
            int guess = 999;
            int tries = 0;
            String answer;
            // Pick a random number
            number = (int)(Math.random() * 10) + 1; 
            // Get the guess
            System.out.println("\nI'm thinking of a number "
                + "between 1 and 10.");

            while (guess != number) {
                do  
                {
                    System.out.print("What is your guess? ");
                    guess = sc.nextInt();
                    validInput = true;

                    if ( (guess < 1) || (guess > 10) )
                    {
                        System.out.print
                        ("I said, between 1 and 10. "
                            + "Try again: ");
                        validInput = false;
                    }
                } while (!validInput);  
                // Check the guess
                tries += 1;
                if (guess > number) 
                    System.out.println("Too high!");
                else if (guess < number)
                    System.out.println("Too low!");
             
                if (guess == number) {   
                    System.out.println("Great Guess!  Youre right!");
                    System.out.println("It took you " + tries +" tries.");

                }

            }
            // Play again?
            do  
            {
                System.out.print("\nPlay again? (Y or N)");
                answer = sc.next();
                validInput = true;
                if (answer.equalsIgnoreCase("Y"));
                else if (answer.equalsIgnoreCase("N"))
                    keepPlaying = false;
                else
                    validInput = false;
            } while (!validInput);  
        }   
        System.out.println("\nThank you for playing!");
    }
}