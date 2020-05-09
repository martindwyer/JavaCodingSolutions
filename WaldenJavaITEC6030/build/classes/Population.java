
package population;

import java.util.Scanner;

public class Population {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String promptResponse = null;
        double population = 0.0;
        double growthRate = 0.0;
        int daysToGrow = 0;
        boolean validPopulation = false;
        boolean validGrowthRate = false;
        boolean validDays = false;
        
        System.out.print("Enter the starting number organisms: ");
        while (!validPopulation) {
            promptResponse = stdin.next();
            population = Double.parseDouble(promptResponse);
            if (population >= 2) {
                validPopulation = true;
            } else {
                System.out.print("Invalid. Must be at least 2. Re-enter: ");
            }
        }
        
        System.out.print("Enter the daily increase: ");
        while (!validGrowthRate) {
            promptResponse = stdin.next();
            growthRate = Double.parseDouble(promptResponse);
            if (growthRate >= 0) {
                validGrowthRate = true;
            } else {
                System.out.print("Invalid. Enter a non-negative number: ");
            }
        }
        
        System.out.print("Enter the number of days the organisms will multiply: ");
        while (!validDays) {
            promptResponse = stdin.next();
            daysToGrow = Integer.parseInt(promptResponse);
            if (daysToGrow >= 1) {
                validDays = true;
            } else {
                System.out.print("Invalid. Enter 1 or more: ");
            }
        }
        System.out.println("Day"+"\t\t"+"Organisms");
        System.out.println("-----------------------------");
        for (int i = 1; i <= daysToGrow; i++) {
            System.out.print(i);
            System.out.print("\t\t");
            System.out.print(population);
            System.out.print("\n");
            population = population + (growthRate*population);
        }
        
        
        
       
    }
    
}

