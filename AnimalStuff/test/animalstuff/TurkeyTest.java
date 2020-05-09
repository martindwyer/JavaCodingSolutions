package animalstuff;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TurkeyTest class for testing Turkey class constructor and methods
 * 
 * @author Martin Dwyer
 * 
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class TurkeyTest {

    /**
     * Test of movement method
     */
    @Test
    public void testMovement() {
        //  Testing movement() method
        Turkey instance = new Turkey();
        String fastMovement = "I fly for short distances, and then run on two legs";
        String slowMovement = "I walk on two legs";
        assertEquals("movement() method fails testing for fast movement", fastMovement, instance.movement(true));
        assertEquals("movement() method fails testing for slow movement", slowMovement, instance.movement(false));
        
    }
    
    /**
     * Test of sound method
     */
    @Test
    public void testSound() {
        // Testing sound() method
        Turkey instance = new Turkey();
        String expResult = "Gobble gobble gobble";
        String result = instance.sound();
        assertEquals("sound() method fails testing", expResult, result);
        
    }

    /**
     * Test of equals method
     */
    @Test
    public void testEquals() {
        Object obj = null;
        Turkey instance = new Turkey();

        // Testing not equal to null object
        boolean testResult = instance.equals(obj);
        assertFalse("equals() fails null test", testResult);

        // Testing for known equal objects...
        Turkey instanceEqual = new Turkey();
        testResult = instance.equals(instanceEqual);
        assertTrue("equals() fails for known equal object...", testResult);

        // Testing for known not-equal objects...
        Bird instanceNotEqual = new Bird("Canary");
        testResult = instance.equals(instanceNotEqual);
        assertFalse("equals() fails for known equal object...", testResult);

        // Testing for impersonator: new Animal(Finch,Feathers)
        Animal faker = new Animal("Turkey", "Feathers");
        testResult = instance.equals(faker);
        assertFalse("equals() fails the impersonator test", testResult);

    }
    
}
