package animalstuff;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * HumanTest class for testing Human class constructor and methods
 * 
 * @author Martin Dwyer
 * 
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class HumanTest {
    
    /**
     * Test of movement method
     */
    @Test
    public void testMovement() {
        //  Testing movement() method
        Human instance = new Human();
        String fastMovement = "I run real fast on two legs";
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
        Human instance = new Human();
        String expResult = "I use words";
        String result = instance.sound();
        assertEquals("sound() method fails testing", expResult, result);
        
    }

    /**
     * Test of equals method
     */
    @Test
    public void testEquals() {
        Object obj = null;
        Human instance = new Human();

        // Testing not equal to null object
        boolean testResult = instance.equals(obj);
        assertFalse("equals() fails null test", testResult);

        // Testing for known equal objects...
        Human instanceEqual = new Human();
        testResult = instance.equals(instanceEqual);
        assertTrue("equals() fails for known equal object...", testResult);

        // Testing for known not-equal objects...
        Bird instanceNotEqual = new Bird("Canary");
        testResult = instance.equals(instanceNotEqual);
        assertFalse("equals() fails for known equal object...", testResult);

        // Testing for impersonator: new Animal(Finch,Feathers)
        Animal faker = new Animal("Human", "Hair");
        testResult = instance.equals(faker);
        assertFalse("equals() fails the impersonator test", testResult);

    }    
}
