import java.util.*;
import java.math.*;
import java.io.*;

public class Die {

    private int sides;
    private int inputSides;
    private int roll;
    private String stringSides;
    Random rg = new Random();

    public Die(int inputSides) {
        if (inputSides > 40 || inputSides < 2) {
            sides = 6;
        } else {
            sides = inputSides;
        }
    }


    public Die() {
        this(6);
    }

    public int numSides() {
        return sides;
    }

    public int Roll() {
        roll = rg.nextInt(sides)+1;
        return roll;
    }
    public String sidesToString() {
        stringSides = "a " +Integer.toString(sides) + " sided die";
        return stringSides;
    }
    public static void main(String[] args) {
        int winner, sides;
        Random rg = new Random();
        Scanner kb = new Scanner(System.in);

        Die d1 = new Die();
        winner = d1.Roll();
        System.out.println("Roll of default six-sided dice:  " + winner);

        Die d2 = new Die(rg.nextInt(39)+2);
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
