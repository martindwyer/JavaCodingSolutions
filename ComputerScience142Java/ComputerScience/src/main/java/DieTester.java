import java.util.*;

public class DieTester {
    // instance variables - replace the example below with your own
    public static void main(String[] args) {
        int winner, sides;
        Random rg = new Random();
        Scanner kb = new Scanner(System.in);

        Die d1 = new Die();
        winner = d1.Roll();
        System.out.println("Roll of default six-sided dice:  " + winner);

        Die d2 = new Die(rg.nextInt(999)+1);
        System.out.println("The number of sides on random die:  "+d2.numSides());
        winner = d2.Roll();
        System.out.println("The roll of the dice equals:  "+ winner);

        System.out.println("How many sides on the dice for your game? ");
        sides = kb.nextInt();
        Die d3 = new Die(sides);
        winner = d3.Roll();
        System.out.println("The number of sides on your die:  "+sides);
        System.out.println("The roll of the dice equals:  "+ winner);
        System.out.println(d3.sidesToString());
    }

}
