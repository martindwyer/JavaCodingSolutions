/**
 * Student:     Martin Dwyer
 * Class:       ITEC 6130, Walden University, Spring 2019
 * Week:        4
 *
 * Description: This project includes the Hammurabi game written in Java and
 * tested with JUnit testing.  The tests can be found in HammurabiTest.java
 */
package hammurabi;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The Hammurabi game.
 *
 * @author Martin Dwyer
 */
public class Hammurabi {

    // save in a file named Hammurabi.java
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    /**
     * The main() method starts the game controller method playGame()
     *
     * @param args a String array
     */
    public static void main(String[] args) {
        new Hammurabi().playGame();
    }

    /**
     * playGame() is the main controller method for the game, with game
     * variables defined there along with the user interface controls.
     *
     */
    void playGame() {

        // define local variables here: grain, population, etc.
        int population = 100;
        int grainBushels = 2800;
        int acresLand = 1000;
        int acresPurchased = 0;
        int acresToSell = 0;
        int acresToPlant = 0;
        int foodForThePeople = 0;
        int plagueDeaths = 0;
        int starvationDeaths = 0;
        int harvest = 0;
        int cropYield = 0;
        int immigrants = 0;
        int ratGrain = 0;
        boolean uprising;
        int landValue = 19;

        boolean gameGoesOn = true;
        int yearNumber = 0;
        System.out.println(welcomeMessage());
        while (gameGoesOn) {
            yearNumber++;

            // Getting user inputs and adjusting inventories of land and grain
            acresPurchased = askHowManyAcresToBuy(landValue, grainBushels);
            acresLand += acresPurchased;
            grainBushels -= acresPurchased * landValue;

            // If not buying land, ask if selling and make adjustments to land and grain
            if (acresPurchased == 0) {
                acresToSell = askHowManyAcresToSell(acresLand);
                acresLand -= acresToSell;
                grainBushels += landValue * acresToSell;
            }

            // Determine people food allocation and amount of land to plant
            foodForThePeople = askHowMuchGrainToFeedPeople(grainBushels);
            acresToPlant = askHowManyAcresToPlant(acresLand, population, grainBushels);

            // Calculating the harvest and crop yield
            harvest = harvest(acresToPlant);
            if (acresToPlant > 0) {
                cropYield = harvest / acresToPlant;
            }

            // Check on rats, plagues, and starvation
            ratGrain = grainEatenByRats(grainBushels);
            plagueDeaths = plagueDeaths(population);
            starvationDeaths = starvationDeaths(population, foodForThePeople);

            // Check for uprising
            uprising = uprising(population, starvationDeaths);

            // Calculate immigration
            immigrants = immigrants(population, acresLand, grainBushels);

            // Making adustments to population and grain levels for harvest, feeding, rats, plague and starvation
            grainBushels = grainBushels + harvest - foodForThePeople - ratGrain;
            population = population - plagueDeaths - starvationDeaths + immigrants;

            // Recalculate land value at end of year
            landValue = newCostOfLand();

            // print out end of year report
            System.out.println(printSummary(yearNumber, starvationDeaths, immigrants, population, harvest, cropYield, ratGrain, grainBushels, acresLand, landValue));

            // Get ready for next year
            acresPurchased = 0;
            acresToSell = 0;
            acresToPlant = 0;
            foodForThePeople = 0;
            plagueDeaths = 0;
            starvationDeaths = 0;
            harvest = 0;
            cropYield = 0;
            immigrants = 0;
            ratGrain = 0;

            // End of 10 year term
            if (yearNumber == 10) {
                gameGoesOn = false;
                System.out.println(printFinalReport(acresLand, grainBushels, population));
                // Or uprising    
            } else if (uprising) {
                gameGoesOn = false;
                System.out.println("\n\nThere has been an uprising by the people!");
                System.out.println("More than 45% of the people starved!");
                System.out.println("GAME OVER!");
            }

        }

    }

    /**
     * welcomeMessage() provides the welcome text at the beginning of the game
     *
     * @return a String for display before the main menu with starting values
     * for the player
     */
    String welcomeMessage() {
        String welcomeMessage = "Congratulations, you are the newest ruler of ancient Samaria,\n"
                + "elected for a 10 year term of office. Your duties are to\n"
                + "dispense food, direct farming, and buy and sell land as needed\n"
                + "to support your people. Watch out for rat infestations and the\n"
                + "plague! Grain is the general currency, measured in bushels. The\n"
                + "following will help you in your decisions:\n\n"
                + "   * Each person needs at least 20 bushels of grain per year to survive\n"
                + "   * Each person can farm at most 10 acres of land\n"
                + "   * It takes 2 bushels of grain to farm an acre of land\n"
                + "   * The market price for land fluctuates yearly\n\n"
                + "Rule wisely and you will be showered with appreciation at the\n"
                + "end of your term. Rule poorly and you will be kicked out of\n"
                + "office!\n\n"
                + "To begin, your resources are aso follows:\n"
                + "\tPopulation = 100 people\n"
                + "\tGrain on hand = 2800 bushels\n"
                + "\tLand = 1000 acres\n"
                + "\tLand value = 19 bushels of grain per acre\n\n";
        return welcomeMessage;
    }

    /**
     * Prints the summary of performance at the end of each year
     *
     * @param yearNumber integer for year number that the player is on
     * @param starvationDeaths integer indicating number of people starved
     * @param immigrants integer indicating immigration totals for the year
     * @param population integer tracking the population
     * @param harvest integer for bushels harvested this year
     * @param cropYield the number of bushels per acre harvested
     * @param ratGrain the bushels of grain eaten by rats
     * @param grainBushels the grain inventory on hand
     * @param acresLand the acres of land owned
     * @param landValue the present value of land
     *
     * @return a String for displaying the summary status
     */
    String printSummary(int yearNumber, int starvationDeaths, int immigrants, int population, int harvest, int cropYield, int ratGrain, int grainBushels, int acresLand, int landValue) {
        String annualMessage = "O great Hammurabi!\n\n"
                + "You are in year " + yearNumber + " of your ten rule\n"
                + "In the previous year " + starvationDeaths + " people starved to death.\n"
                + "In the previous year " + immigrants + " people entered the kingdom.\n"
                + "The population is now " + population + ".\n"
                + "We harvested " + harvest + " bushels at " + cropYield + " bushels per acre.\n"
                + "Rats destroyed " + ratGrain + " bushels, leaving " + grainBushels + " bushels in storage.\n"
                + "The city owns " + acresLand + " acres of land.\n"
                + "Land is currently worth " + landValue + " bushels per acre.\n";

        return annualMessage;

    }

    /**
     * Prints the final report after game is run 10 years
     *
     * @param acresLand acres of land owned
     * @param grainBushels bushels of grain owned
     * @param population number of people living in the kingdom
     *
     * @return a String for displaying the game results
     */
    String printFinalReport(int acresLand, int grainBushels, int population) {
        String finalReport = "O great Hammurabi!  Your game is over!\n\n"
                + "Here is the final report of your reign: \n\n"
                + "You ended up with a population of " + population + " people, a change of " + (population - 100) + " people.\n\n"
                + "You ended up with " + grainBushels + " bushels of grain, a change of " + (grainBushels - 2800) + " bushels.\n\n"
                + "You ended up with " + acresLand + " acres of land, a change of " + (acresLand - 1000) + " acres.\n\n"
                + "Thanks for playing!\n\n";
        return finalReport;

    }

    /**
     * A method to ask how many acres to purchase
     *
     * @param price the current value of land per acre
     * @param bushels the bushels available for purchasing the land
     *
     * @return a verified purchase number for acres to be purchased
     */
    int askHowManyAcresToBuy(int price, int bushels) {
        String s;
        boolean validInput = false;
        boolean isGoodNumber = false;
        String input = "0";
        int acresPurchased = 0;
        while (!validInput) {
            // First make sure the right input is given
            while (!isGoodNumber) {
                try {
                    System.out.print("How many acres of land to purchase at " + price + " bushels per acre? ");
                    acresPurchased = scanner.nextInt();
                    isGoodNumber = true;
                } catch (InputMismatchException e) {
                    System.out.println("O great Hammurabi, you have not entered a number correctly.  Enter a whole number. ");
                    s = scanner.next();
                }
            }
            // Then make sure the input amount is within budget
            if (acresPurchased * price > bushels) {
                System.out.println("O great Hammurabi, surely you jest.  You have only " + bushels + " bushels of grain left. \nTry again.\n ");
                isGoodNumber = false;
            } else {
                // Proper input within budget
                validInput = true;
            }
        }
        return acresPurchased;
    }

    /**
     * A method to ask how many acres to sell
     *
     * @param acresOwned the acres available for sale
     *
     * @return a verified purchase number for acres to be purchased
     */
    int askHowManyAcresToSell(int acresOwned) {
        String s;
        String input = "0";
        int acresSold = 0;
        boolean validInput = false;
        boolean isGoodNumber = false;
        while (!validInput) {
            // First make sure the right input is given
            while (!isGoodNumber) {
                try {
                    System.out.print("How many acres of land to sell of " + acresOwned + " acres owned? ");
                    acresSold = scanner.nextInt();
                    isGoodNumber = true;
                } catch (InputMismatchException e) {
                    System.out.println("O great Hammurabi, you have not entered a number correctly.  Enter a whole number. ");
                    s = scanner.next();
                }
            }
            // Then make sure the input amount is within budget
            if (acresSold > acresOwned) {
                System.out.println("O great Hammurabi, surely you jest.  You have only " + acresOwned + " acres owned.\nTry again. \n");
                isGoodNumber = false;
            } else {
                // Proper input within budget
                validInput = true;
            }
        }

        return acresSold;

    }

    /**
     * A method for determining how much grain to feed the people
     *
     * @param bushels the bushels of grain available at the present time
     *
     * @return the number of verified bushels for the people to eat
     */
    int askHowMuchGrainToFeedPeople(int bushels) {
        String s;
        String input = "0";
        int foodForThePeople = 0;
        boolean validInput = false;
        boolean isGoodNumber = false;
        while (!validInput) {
            // First make sure the right input is given
            while (!isGoodNumber) {
                try {
                    System.out.println("Each person needs at least 20 bushels of grain per year to survive.");
                    System.out.print("How many bushels of your inventory of " + bushels + " bushels of grain will you feed the people? ");
                    foodForThePeople = scanner.nextInt();
                    isGoodNumber = true;
                } catch (InputMismatchException e) {
                    System.out.println("O great Hammurabi, you have not entered a number correctly.  Enter a whole number. ");
                    s = scanner.next();
                }
            }
            // Then make sure the input amount is within budget
            if (foodForThePeople > bushels) {
                System.out.println("O great Hammurabi, surely you jest.  You have only " + bushels + " bushels owned.\nTry again. \n");
                isGoodNumber = false;
            } else {
                // Proper input within budget
                validInput = true;
            }
        }

        return foodForThePeople;

    }

    /**
     * A method for determining the number of acres to be planted
     *
     * @param acresOwned the acres of land owned
     * @param population the number of people in the kingdom
     * @param bushels the bushels of grain on hand
     *
     * @return bushels to feed the people, verified available.
     */
    int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        String s;
        String input = "0";
        int acresToPlant = 0;
        boolean validInput = false;
        boolean isGoodNumber = false;
        while (!validInput) {
            // First make sure the right input is given
            while(!isGoodNumber) {
            try {
                System.out.println("It takes one person and 20 bushels of grain for 10 acres.");
                System.out.print("How many acres of " + acresOwned + " do you want to plant? ");
                acresToPlant = scanner.nextInt();
                isGoodNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("O great Hammurabi, you have not entered a number correctly.  Enter a whole number. ");
                s = scanner.next();
            }
            }
            // Then make sure the input amount is within budget
            if (acresToPlant > acresOwned) {
                System.out.println("O great Hammurabi, surely you jest.  You have only " + acresOwned + " acres owned.\nTry again.");
                isGoodNumber = false;
            } else if (acresToPlant / 10 > population) {
                System.out.println("O great Hammurabi, surely you jest.  You have only " + population + " to plant grain.\nTry again.");
                isGoodNumber = false;
            } else if (acresToPlant * 2 > bushels) {
                System.out.println("O great Hammurabi, surely you jest.  You have only " + bushels + " bushels owned.\nTry again.");
                isGoodNumber = false;
            } else {
                validInput = true;
            }

        }

        return acresToPlant;
    }

    /**
     * Method determines annual deaths due to plague
     *
     * @param population the number of people in the kingdom
     * @return the number of people dead from plague
     */
    int plagueDeaths(int population) {
        int plagueDeaths = 0;
        boolean isPlague;
        int plagueIndex = 0 + rand.nextInt(101);
        if (plagueIndex > 85) {
            isPlague = true;
        } else {
            isPlague = false;
        }
        if (isPlague) {
            plagueDeaths = (int) (0.5 * population);
        }
        return plagueDeaths;
    }

    /**
     * Determines the number of people dead from starvation
     *
     * @param population the number of people to feed
     * @param bushelsFedToPeople the amount of food
     * @return the number not fed who died
     */
    int starvationDeaths(int population, int bushelsFedToPeople) {
        int starvationDeaths = 0;
        int peopleFed = bushelsFedToPeople / 20;
        if (population > bushelsFedToPeople / 20) {
            starvationDeaths = population - bushelsFedToPeople / 20;
        }
        return starvationDeaths;

    }

    /**
     * Determines whether or not there will be an uprising
     *
     * @param population number of people in the kingdom
     * @param howManyPeopleStarved number of people starved
     * @return true if more than 45% starved, false otherwise
     */
    boolean uprising(int population, int howManyPeopleStarved) {
        boolean isRevolt = false;
        if (howManyPeopleStarved > population * 0.45) {
            isRevolt = true;
        }
        return isRevolt;
    }

    /**
     * Determines the number of people to immigrate into the kingdom
     *
     * @param population the starting number of people in the kingdom
     * @param acresOwned land owned by the kingdom
     * @param grainInStorage grain in bushels
     * @return the number of immigrants for the year
     */
    int immigrants(int population, int acresOwned, int grainInStorage) {
        int immigrants = (20 * acresOwned + grainInStorage) / (100 * population) + 1;
        return immigrants;
    }

    /**
     * Determines crop harvest
     *
     * @param acres indicating amount of land to be planted
     * @return the bushels of grain to be harvested
     */
    int harvest(int acres) {
        int bushels = 0;
        int cropYieldIndex = rand.nextInt(6) + 1;
        bushels = acres * cropYieldIndex;
        return bushels;
    }

    /**
     * Determines amount of grain eaten by rats
     *
     * @param bushels amount of grain on hand
     * @return the bushels of grain eaten by rats
     */
    int grainEatenByRats(int bushels) {
        int ratGrain = 0;
        int ratIndex = rand.nextInt(101);
        if (ratIndex > 60) {
            ratGrain = (int) (((10 + rand.nextInt(21)) / 100.0) * bushels);
        }
        return ratGrain;
    }

    /**
     * Determines the cost of an acre of land in bushels of grain per acre
     *
     * @return the cost of land in bushels per acre
     */
    int newCostOfLand() {
        return 17 + rand.nextInt(7);

    }

}
