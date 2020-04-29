/**
 * Student:     Martin Dwyer
 * Class:       ITEC 6130, Walden University, Spring 2019
 * Week:        4
 * 
 * Description: This project includes the Hammurabi game written in Java and 
 * tested with JUnit testing.  The tests can be found in HammurabiTest.java
 */
package hammurabi;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * HammurabiTest class for JUnit testing of the Hammurabi game
 * 
 * @author Martin Dwyer
 */
public class HammurabiTest {

    /**
     * Test of welcomeMessage method, of class Hammurabi.
     */
    @Test
    public void testWelcomeMessage() {
        System.out.println("welcomeMessage");
        Hammurabi instance = new Hammurabi();
        String expResult = "Congratulations, you are the newest ruler of ancient Samaria,\n"
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
        String result = instance.welcomeMessage();
        assertEquals("Welcome message test fails", expResult, result);
    }

    /**
     * Test of printSummary method, of class Hammurabi.
     */
    @Test
    public void testPrintSummary() {
        System.out.println("printSummary with no rat problem");
        int yearNumber = 0;
        int starvationDeaths = 0;
        int immigrants = 0;
        int population = 0;
        int harvest = 0;
        int cropYield = 0;
        int ratGrain = 0;
        int grainBushels = 0;
        int acresLand = 0;
        int landValue = 0;
        Hammurabi instance1 = new Hammurabi();
        System.out.println("printSummary with rat problem");
        ratGrain = 1;
        Hammurabi instance2 = new Hammurabi();
        String expResult = "O great Hammurabi!\n\n"
                + "You are in year 0 of your ten rule\n"
                + "In the previous year 0 people starved to death.\n"
                + "In the previous year 0 people entered the kingdom.\n"
                + "The population is now 0.\n"
                + "We harvested 0 bushels at 0 bushels per acre.\n"
                + "Rats destroyed 1 bushels, leaving -1 bushels in storage.\n"
                + "The city owns 0 acres of land.\n"
                + "Land is currently worth 0 bushels per acre.\n";
        String result = instance2.printSummary(yearNumber, starvationDeaths, immigrants, population, harvest, cropYield, ratGrain, grainBushels, acresLand, landValue);
        assertEquals(expResult, result);
    }

    /**
     * Test of printFinalReport method, of class Hammurabi.
     */
    @Test
    public void testPrintFinalReport() {
        System.out.println("printFinalReport");
        int acresLand = 0;
        int grainBushels = 0;
        int population = 0;
        Hammurabi instance = new Hammurabi();
        String expResult = "O great Hammurabi!  Your game is over!\n\n"
                + "Here is the final report of your reign: \n\n"
                + "You ended up with a population of 0 people, a change of -100 people./n/n"
                + "You ended up with 0 bushels of grain, a change of -2800 bushels./n/n"
                + "You ended up with 0 acres of land, a change of -1000 acres./n/n"
                + "Thanks for playing!\n\n";;
        String result = instance.printFinalReport(acresLand, grainBushels, population);
        assertEquals(expResult, result);
    }

    /**
     * Test of plagueDeaths method, of class Hammurabi.
     */
    @Test
    public void testPlagueDeaths() {
        System.out.println("plagueDeaths");
        // Plagues occur 15% of the time.
        // when plagues occur, half of the players people die.
        // Will run method 100,000 times, with population of 1000, keeping track of plague deaths.
        // Long run average deaths expected: 10000*0.15*.5 = 75 deaths.
        // Satisfactory range 70 to 80 for method average result
        int totalDead = 0;
        double averageDead = 0;
        int population = 1000;
        Hammurabi instance = new Hammurabi();
        for (int i = 0; i < 100000; i++) {
            totalDead += instance.plagueDeaths(population);

        }
        averageDead = totalDead / 100000.00;
        assertTrue(70 < averageDead && averageDead < 80);

    }

    /**
     * Test of starvationDeaths method, of class Hammurabi.
     */
    @Test
    public void testStarvationDeaths() {
        System.out.println("starvationDeaths");
        // People need 20 bushels of grain per year to survive
        // Starvation deaths occur as a result of insufficient grain on hand
        int population = 100;
        int bushelsFedToPeople = 1800;
        Hammurabi instance = new Hammurabi();
        int expResult = 10;
        int result = instance.starvationDeaths(population, bushelsFedToPeople);
        assertEquals(expResult, result);
    }

    /**
     * Test of uprising method, of class Hammurabi.
     */
    @Test
    public void testUprising() {
        System.out.println("uprising");
        // Uprising occurs if more than 45% of the population starves
        // Testing border case
        int population = 100;
        int howManyPeopleStarved = 46;
        Hammurabi instance = new Hammurabi();
        boolean expResult = true;
        boolean result = instance.uprising(population, howManyPeopleStarved);
        assertEquals(expResult, result);
        // Testing other side of border
        howManyPeopleStarved = 44;
        expResult = false;
        result = instance.uprising(population, howManyPeopleStarved);
        assertEquals(expResult, result);
    }

    /**
     * Test of immigrants method, of class Hammurabi.
     */
    @Test
    public void testImmigrants() {
        System.out.println("immigrants");
        // Immigration is based on the formula: (20 * acresOwned + grainInStorage) / (100 * population) + 1
        int population = 100;
        int acresOwned = 1000;
        int grainInStorage = 3600;
        Hammurabi instance = new Hammurabi();
        int expResult = (20 * acresOwned + grainInStorage) / (100 * population) + 1;
        int result = instance.immigrants(population, acresOwned, grainInStorage);
        assertEquals(expResult, result);
    }

    /**
     * Test of harvest method, of class Hammurabi.
     */
    @Test
    public void testHarvest() {
        System.out.println("harvest");
        // Harvest is determined as follows: acres planted x crop yield per acre
        // Where crop yield per acre is a random number between 1 and 6 inclusive
        // In multiple trials, average of crop yield should approach 3.5
        // Setting acres = 1000, harvest should then be between 3325 and 3675 (5% sampling error)
        int acres = 1000;
        int totalHarvest = 0;
        double harvestAverage = 0.0;
        Hammurabi instance = new Hammurabi();
        for (int i = 0; i < 10000; i++) {
            totalHarvest += instance.harvest(acres);
        }
        harvestAverage = totalHarvest / 10000.0;
        assertTrue(3325 < harvestAverage && harvestAverage < 3675);
    }

    /**
     * Test of grainEatenByRats method, of class Hammurabi.
     */
    @Test
    public void testGrainEatenByRats() {
        System.out.println("grainEatenByRats");
        // Each year, there is a 40% chance of rat infestation
        // When this happens, 10% to 30% of the grain is eaten
        // The low end of the range for rat grain should tend to: bushels*0.4*0.1
        // The high end of the range for rat grain should tend to: bushels*0.4*0.3
        // Using 1000 bushels of grain, these numbers would tend to 40 and 120
        // Testing below uses a 5% sampling error for testing
        int bushels = 1000;
        Hammurabi instance = new Hammurabi();
        int totalRatGrain = 0;
        double averageRatGrain = 0.0;
        for (int i = 0; i < 10000; i++) {
            totalRatGrain += instance.grainEatenByRats(bushels);
        }
        averageRatGrain = totalRatGrain / 10000.0;
        assertTrue(38 < averageRatGrain && averageRatGrain < 120);

    }

    /**
     * Test of newCostOfLand method, of class Hammurabi.
     */
    @Test
    public void testNewCostOfLand() {
        System.out.println("newCostOfLand");
        // Cost of new land is a random number beteen 17 and 23 (inclusive)
        // The average should tend to 20
        // Testing below again uses 5% sampling error
        Hammurabi instance = new Hammurabi();
        int totalTrials = 0;
        double averageValue = 0.0;
        for (int i = 0; i < 10000; i++) {
            totalTrials += instance.newCostOfLand();
        }
        averageValue = totalTrials / 10000.00;
        assertTrue(19 <= averageValue && averageValue <= 21);
    }

}
