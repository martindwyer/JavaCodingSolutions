import java.util.*;

/**
 * Write a description of class Lab7Part5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab7Part5
{
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        String input = null;
        String dChar = null;
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("Please choose an option:");
            System.out.println("1. Draw a diamond");
            System.out.println("2. Draw an hourglass");
            System.out.println("3. Draw a hollow rectangle");
            System.out.println("4. Quit");

            input = kb.nextLine();
            if (input.equals("4")) {
                keepPlaying = false;
            } else {

                System.out.println("Enter the character for drawing:");

                dChar = kb.nextLine();

                if (input.equals("3")) {
                    // draw a rectangle
                    for(int x=0; x<10; x++) {
                        for (int y=0; y<15; y++) {
                            if(((x > 0) && (x < 9)) && ((y > 0) && (y < 14))) {
                                System.out.print("  ");
                            } else {
                                System.out.print(dChar + " ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                }

                if (input.equals("2")) {
                    // draw an hourglass
                    for(int x=0; x<5; x++) {
                        for (int y=0; y<x; y++) {
                            System.out.print(" ");
                        } 
                        for (int z=5; z>x; z--) {
                            System.out.print(dChar + " ");
                        }
                        System.out.println();
                    }
                    for(int x=4; x>=0; x--) {
                        for (int y=0; y<x; y++) {
                            System.out.print(" ");
                        } 
                        for (int z=5; z>x; z--) {
                            System.out.print(dChar + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }

                if (input.equals("1")) {
                    // draw a diamond
                    for(int x=4; x>=0; x--) {
                        for (int y=0; y<x; y++) {
                            System.out.print(" ");
                        } 
                        for (int z=5; z>x; z--) {
                            System.out.print(dChar + " ");
                        }
                        System.out.println();
                    }
                    for(int x=0; x<5; x++) {
                        for (int y=0; y<x; y++) {
                            System.out.print(" ");
                        } 
                        for (int z=5; z>x; z--) {
                            System.out.print(dChar + " ");
                        }
                        System.out.println();
                    }
                }}
        }
        System.out.println("Thanks for trying out our drawing game.");
        System.out.println("Come again soon.");
    }

}
