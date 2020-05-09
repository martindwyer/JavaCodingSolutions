import java.util.Scanner;

public class TheSpeedOfSound {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String medium;
        String distanceInput;
        double distance;
        double time = 0.0;
        boolean validInput = false;
        System.out.print("Enter one of the following: air, water, or steel: ");
        medium = kb.next();
        if (medium.equals("air") || medium.equals("water") || medium.equals("steel")) {
            validInput = true;
        } else {
            System.out.println("Sorry, you must enter air, water, or steel.");
            System.exit(0);
        }
        
        System.out.print("Enter the distance the sound wave will travel: ");
        distanceInput = kb.next();
        distance = Double.parseDouble(distanceInput);
        
        switch(medium) {
            case "air":
            time = distance/1100;
            break;
            
            case "water":
            time = distance / 4900;
            break;
        
            case "steel":
            time = distance / 16400;
        }
        System.out.println("It will take " + time + " seconds.");
        
        
    }
    
}
