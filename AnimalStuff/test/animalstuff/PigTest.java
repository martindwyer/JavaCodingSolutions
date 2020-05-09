package animalstuff;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * PigTest class for testing Pig class constructor and methods
 * 
 * @author Martin Dwyer
 * 
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class PigTest {
    
    /**
     * Test of movement method
     */
    @Test
    public void testMovement() {
        //  Testing movement() method
        Pig instance = new Pig();
        String fastMovement = "I run real fast on four legs for very short distances";
        String slowMovement = "I walk very slowly on four legs";
        assertEquals("movement() method fails testing for fast movement", fastMovement, instance.movement(true));
        assertEquals("movement() method fails testing for slow movement", slowMovement, instance.movement(false));
        
    }
    
    /**
     * Test of sound method
     */
    @Test
    public void testSound() {
        // Testing sound() method
        Pig instance = new Pig();
        String expResult = "Oink oink oink";
        String result = instance.sound();
        assertEquals("sound() method fails testing", expResult, result);
        
    }

    /**
     * Test of equals method
     */
    @Test
    public void testEquals() {
        Object obj = null;
        Pig instance = new Pig();

        // Testing not equal to null object
        boolean testResult = instance.equals(obj);
        assertFalse("equals() fails null test", testResult);

        // Testing for known equal objects...
        Pig instanceEqual = new Pig();
        testResult = instance.equals(instanceEqual);
        assertTrue("equals() fails for known equal object...", testResult);

        // Testing for known not-equal objects...
        Bird instanceNotEqual = new Bird("Canary");
        testResult = instance.equals(instanceNotEqual);
        assertFalse("equals() fails for known equal object...", testResult);

        // Testing for impersonator: new Animal(Finch,Feathers)
        Animal faker = new Animal("Pig", "Hair");
        testResult = instance.equals(faker);
        assertFalse("equals() fails the impersonator test", testResult);

    }
    
}
