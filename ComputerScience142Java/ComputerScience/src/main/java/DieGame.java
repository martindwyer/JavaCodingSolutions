import java.util.*;

public class DieGame {
    public static void main(String[] args) {
        int winner, sides;
        Random rg = new Random();
        Scanner kb = new Scanner(System.in);

        System.out.println("Game with two players, each rolls six-sided dice");
        Die d1 = new Die();
        Die d2 = new Die();
        int r1 = 0;
        int r2 = 0;
        int s1 = 0;
        int s2 = 0;
        String keepPlaying = "Yes";
        int input;

        while (keepPlaying == "Yes") {
            r1 = d1.Roll();
            r2 = d2.Roll();
            if (r1 > r2) {
                System.out.println("Player 1 wins");
                System.out.println("Player 1 rolled a" + Integer.toString(r1));
                s1 += 1;
            } else if (r2 > r1) {
                System.out.println("Player 2 wins");
                System.out.println("Player 2 rolled " + Integer.toString(r2));
                s2 += 1;
            } else {
                System.out.println("It's a tie!");
                System.out.println("Both players rolled " + Integer.toString(r1));
            }
            System.out.println("Press 1 to continue, 9 to quit");
            input = kb.nextInt();
            if (input == 9) {
                keepPlaying = "No";
            }

        }

        System.out.println("Final score, Player 1: "+s1+" Player 2: "+s2);
    }


}
